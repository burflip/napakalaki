#encoding: utf-8
require_relative 'treasure'
require_relative 'bad_consequence'

module NapakalakiGame
  class Player
    
    @@MAXLEVEL = 10
    
    def initialize(name)
      @name = name
      @level = "level"
      @dead = false
      @canISteal = true
      @enemy = ""
      @visibleTreasures = Array.new
      @hiddenTreasures = Array.new
      @pendingBadConsequence = ""
    end
    
    def getName # Se puede usar directamente obj.name, gracias a attr_reader
      @name
    end
    
    def bringToLife
      @dead = true
    end
    
    def getCombatLevel
      bonus = 0
      @visibleTreasures.each do |tesoro| 
        bonus += tesoro.bonus
      end
      @level + bonus
    end
    
    def incrementLevels(l)
      final_level = @level + l
      if(final_level > 10)
        @level = 10
      else
        @level = final_level
      end
    end
    
    def decrementLevels(l)
      final_level = @level - l
      if(final_level < 1)
        @level = 1
        @dead = true
        discardAllTreasures
      else
        @level = final_level
      end
    end
    
    def setPendingBadConsequence(b)
      @pendingBadConsequence = b
    end
    
    def applyPrize(m)
      nLevels = m.getLevelsGained
      incrementLevels(nLevels)
      nTreasures = m.getTreasuresGained
      if(nTreasures > 0)
        for i in 0..nTreasures
          t =CardDealer.instance.nextTreasure
          @hiddenTreasures.push(t)
        end
      end
    end

    def applyBadConsequence(badConsequence)
      n_levels = @level
      decrementLevels(n_levels)
      @pendingBadConsequence = badConsequence.adjustToFitTreasureLists(@visible_treasures, @hidden_treasures)
    end

    def canMakeTreasureVisible (t)
      can_make_visible = true
      has_one_hand = false
      has_two_hand = false
      has_two_handed = false
      tk_hidden = t.type

      @visibleTreasures.each do |treasure|
        if treasure.type == tk_hidden && treasure.type != TreasureKind::ONEHAND
          can_make_visible = false
          break
        elsif treasure.type == tk_hidden && treasure.type == TreasureKind::ONEHAND && has_two_hand
          can_make_visible = false
          break
        end
        
        if treasure.type == TreasureKind::ONEHAND && !has_one_hand
          has_one_hand = true
        elsif treasure.type == TreasureKind::ONEHAND && !has_two_hand
          has_two_hand = true
        elsif treasure.type == TreasureKind::BOTHHANDS
          has_two_handed = true          
        end
        
        if tk_hidden == TreasureKind::BOTHHANDS and has_one_hand
          can_make_visible = false
          break
        elsif tk_hidden == TreasureKind::ONEHAND and (has_two_handed or has_two_hand)
          can_make_visible = false
          break
        end
        
      end
      
      can_make_visible;
    end

    def howManyVisibleTreasures(tKind)
      numero_tesoros = 0
      @visibleTreasures.each do |tesoro|
        if(tesoro.type == tKind)
          numero_tesoros += 1
        end
      end
      numero_tesoros
    end

    def dieIfNoTreasures
      if(@visibleTreasures.empty? and @hiddenTreasures.empty?)
        @dead = true
      end
    end
    
    def isDead
      @dead
    end

    def combat (m)
      myLevel = self.getCombatLevel
      monsterLevel = m.getCombatLevel
      if (myLevel > monsterLevel)
        applyPrize(m)
        if (@level >= @@MAXLEVEL) 
          @combatResult = CombatResult.WINGAME
        else
          @combatResult = CombatResult.WIN
        end 
      else 
        if shouldConvert
          @combatResult = CombatResult.LOSEANDCONVERT
        else
          applyBadConsequence(monster)
          @combatResult = CombatResult.LOSE
        end
      end
      @combatResult
    end

    def makeTreasureVisible (treasure)
      canI = canMakeTreasureVisible(treasure)
       if canI == true
         @visibleTreasures.push(treasure)
         @hiddenTreasures.delete(treasure)
       end
    end

    def discardVisibleTreasure(t)
      dealer = CardDealer.instance
      dealer.giveTreasureBack(@visibleTreasures.delete(t))

      if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty
        @pendingBadConsequence.substractVisibleTreasure(t)
      end

      dieIfNoTreasures
    end

    def discardHiddenTreasure(t)
      dealer =CardDealer.instance
      dealer.giveTreasureBack(@hiddenTreasures.delete(t))

      if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty
         @pendingBadConsequence.substractHiddenTreasure(t)
      end

      dieIfNoTreasures
    end
    
    def validState
      (@pendingBadConsequence.isEmpty and @hiddenTreasures.size <= 4)
    end

    def initTreasures
      dealer=CardDealer.instance
      dice=Dice.instance
      self.bringToLife
      treasure=dealer.nextTreasure 
      @hiddenTreasures<<treasure
      number=dice.nextNumber

      if(number>1)
        treasure=dealer.nextTreasure
        @hiddenTreasures<<treasure
      end

      if(number==6)
        treasure=dealer.nextTreasure
        @hiddenTreasures<<treasure
      end
    end
    
    def getLevels
      @level
    end

    def stealTreasure
      canI=@canISteal
      if(canI)
        canYou = enemy.canYouGiveMeATreasure()
        if(canYou)
          treasure = enemy.giveMeATreasure()
          hiddenTreasures.add(treasure)
          haveStolen()
        end
      end
      treasure
    end

    def setEnemy(enemy)
      @enemy = enemy
    end

    def giveMeATreasure
      ts = @hiddenTreasures.size
      if(ts > 0)
         random = Random.rand(@hiddenTreasures.size())
         r = @hiddenTreasures.at(random)
         @hiddenTreasueres.remove_at(random)
      else
        r = nil
      end
      r     
    end

    def canYouGiveMeATreasure
      !(@hiddenTreasures.empty?)
    end

    def haveStolen
      @canISteal = false
    end

    def discardAllTreasures
      temp= Array.new(@visibleTreasures)

      temp.each do |t|
         discardVisibleTreasure(t)
      end
      
      temp = Array.new(@hiddenTreasures)
      
      temp.each do |t|
         discardHiddenTreasure(t)
      end
      
    end
    
    def to_s()
      "Nombre: #{@name} Nivel: #{@level}"
    end
    
    attr_reader :name, :level, :dead, :canISteal, :visibleTreasures, :hiddenTreasures, :pendingBadConsequence
    attr_writer :enemy
    
    private :bringToLife,
      :getCombatLevel,
      :incrementLevels,
      :decrementLevels,
      :setPendingBadConsequence,
      :applyPrize,
      :applyBadConsequence, 
      :canMakeTreasureVisible,
      :howManyVisibleTreasures,
      :dieIfNoTreasures
    
    
    
  end
end
