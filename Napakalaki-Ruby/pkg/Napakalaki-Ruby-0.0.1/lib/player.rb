#encoding: utf-8
require 'treasure.rb'
require 'bad_consequence.rb'

module NapakalakiGame
  class Player
    
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
    
    @@MAXLEVEL = 10
    
    def initialize(name)
      @name = name
      @level = "level"
      @dead = false
      @canISteal = "canISteal"
      @enemy = "enemy"
      @visibleTreasures = Array.new
      @hiddenTreasures = Array.new
      @pendingBadConsequence = "pendingBad"
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
      else
        @level = final_level
      end
    end
    
    def setPendingBadConsequence(b)
      @pendingBadConsequence = b
    end
    
    def applyPrize(m)

    end

    def applyBadConsequence(m)

    end

    def canMakeTreasureVisible(t)
      true
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

    def combat(m)
      
    end

    def makeTreasureVisible

    end

    def discardVisibleTreasure

    end

    def discardHiddenTreasure

    end
    def validState
      (b.isEmpty() and @hiddenTreasures.size() <= 4)
    end

    def initTreasures

    end
    
    def getLevels # Se puede usar directamente obj.level, gracias a attr_reader
      @level
    end

    def stealTreasure
  
    end

    def setEnemy(enemy) # Se puede usar directamente obj.enemy, gracias a attr_writer
      @enemy = enemy
    end

    def giveMeATreasure
 
    end

    #Omito esta definición, pues la forma de usar canISteal es la misa gracias a
    # attr_reader
    #def canISteal
    #  @canISteal
    #end

    def canYouGiveMeATreasure
      !(@hiddenTreasures.empty?)
    end

    def haveStolen
      @canISteal = false
    end

    def discardAllTreasures

    end
    
    
    
    
    
  end
end
