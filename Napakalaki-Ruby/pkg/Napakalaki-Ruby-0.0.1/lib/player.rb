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

    def canMakeTreasureVisible (treasure)
      can_make_visible = true
      tk_hidden = treasure.type

      if (tk_hidden == TreasureKind::BOTHHAND)
        i=0
        while i<visibleTreasures.size && can_make_visible
          tk_visible = visibleTreasures[i].type
          can_make_visible = (tk_visible != TreasureKind::BOTHHAND && tk_visible != TreasureKind::ONEHAND)
          i = i + 1
        end
      elsif (tk_hidden == TreasureKind::ONEHAND)
        total_one_hand=0
        i=0
        while i<visibleTreasures.size && can_make_visible
          tk_visible = visibleTreasures[i].type
          if (tk_visible == TreasureKind::ONEHAND)
            total_one_hand = total_one_hand +1
          end
          can_make_visible = (tk_visible != TreasureKind::BOTHHAND && total_one_hand<2)
          i = i + 1
        end
      else
        i=0
        while i<visibleTreasures.size && can_make_visible
          tk_visible = visibleTreasures[i].type
          can_make_visible = (tk_visible != tk_hidden)
          i = i + 1
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
        end 
      else 
        @combatResult = CombatResult.WIN
        self.applyBadConsequence(monster)
        @combatResult = CombatResult.LOSE
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
      (b.isEmpty() and @hiddenTreasures.size() <= 4)
    end

    def initTreasures
      dealer=CardDealer.getInstance
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
      random = Random.rand(@hiddenTreasures.size())
      @hiddenTreasures.at(random)
    end

    def canYouGiveMeATreasure
      !(@hiddenTreasures.empty?)
    end

    def haveStolen
      @canISteal = false
    end

    def discardAllTreasures
      temp= Array.new(@visibleTreasures)

      temp.size().times do
        treasure = @visibleTreasures.at(i)
        discardVisibleTreasure(treasure)
      end
      
      temp = Array.new(@hiddenTreasures)
      
      temp.size().times do
        treasure = hiddenTreasures.at(i)
        discardHiddenTreasure(treasure)
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
