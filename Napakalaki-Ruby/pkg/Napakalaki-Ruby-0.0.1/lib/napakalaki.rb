#encoding: utf-8
include Singleton

require './monster.rb'
require './player.rb'
require './card_dealer.rb'
require './combat_result.rb'

module NapakalakiGame
  class Napakalaki
    def initialize(currentPlayer,players,dealer,currentMonster)
      @currentPlayer = ""
      @players = ""
      @dealer = ""
      @currentMonster = ""
    end
    
    def initPlayers(names)
      
    end
    
    def nextPlayer()
      
    end
    
    def nextTurnAllowed()
      true
    end
    
    def setEnemies()
      
    end
    
    def developCombat()
      
    end
    
    def discardVisibleTreasures(treasures)
      
    end
    
    def discardHiddenTreasures(treasures)
      
    end
    
    def makeTreasuresVisible(treasures)
      
    end
    
    def initGame(players)
      
    end
    
    def nextTurn()
      true
    end
    
    def endOfGame(result)
      true
    end
    
    private :initialize, :initPlayers, :nextPlayer, :nextTurnAllowed, :setEnemies
    attr_accesor :currentPlayer, :currentMonster
    
  end
end