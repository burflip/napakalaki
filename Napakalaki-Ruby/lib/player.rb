#encoding: utf-8
require './treasure.rb'
require './bad_consequence.rb'

module NapakalakiGame
  class Player
    
    @@MAXLEVEL = 10
    
    def initialize(name)
      @name = name
      @level = "level"
      @dead = "dead"
      @canISteal = "canISteal"
      @enemy = "enemy"
      @visibleTreasures = "visibleTreasures"
      @hiddenTreasures = "hiddenTreasures"
      @pendingBadConsequence = "pendingBad"
    end
    
    def bringToLife
      
    end
    
    def getCombatLevel
      
    end
    
    def incrementLevels(l)
      
    end
    
    def decrementLevels(l)
      
    end
    
    def applyPrize(m)

    end

    def applyBadConsequence(m)

    end

    def  canMakeTreasureVisible(t)
      true
    end

    def howManyVisibleTreasures(tKind)
      0
    end

    def  dieIfNoTreasures

    end

    def combat(m)
      
    end

    def  makeTreasureVisible

    end

    def discardVisibleTreasure

    end

    def discardHiddenTreasure

    end
    def validState
      true
    end

    def initTreasures

    end

    def stealTreasure
  
    end

    def setEnemy(enemy)

    end

    def giveMeATreasure
 
    end

    def canISteal
      true
    end

    def canYouGiveMeATreasure
      true
    end

    def haveStolen

    end

    def discardAllTreasures

    end
    
    private :bringToLife 
    attr_accesor :name, :level, :dead, :canISteal, :enemy, :visibleTreasures, :hiddenTreasures, :pendingBadConsequence
    
  end
end
