#encoding: utf-8

require 'singleton'
require_relative 'monster'
require_relative 'player'
require_relative 'card_dealer'
require_relative 'combat_result'

module NapakalakiGame
  class Napakalaki
    
    include Singleton
    
    def initialize
      @currentPlayer = nil
      @players = Array.new
      @dealer = ""
      @currentMonster = ""
    end
    
    def initPlayers(names)
      names.each { |name| @players << Player.new(name) }
    end
    
    def nextPlayer()
      total_players = @players.length

      if (@current_player == nil) then
        next_index = rand(total_players)

      else
         current_player_index = @players.index(@current_player)

        if current_player_index == total_players then
          next_index = 0

        else
          next_index = current_player_index + 1
        end
      end
      
      next_player = @players.at(next_index)
      @current_player = next_player

      return @current_player
    end
    
    def nextTurnAllowed()
      if @currentPlayer == nil
        true
      else
        @currentPlayer.validState
      end
    end
    
    def setEnemies()
      i=0
      while(i<@players.length)
        numero=rand(@players.length)
        while(numero==i)
          numero=rand(@players.length)
        end
        @players[i].setEnemy(@players[numero])
        i=i+1
      end
    end
    
    def developCombat()
      @dealer.giveMonsterBack(@currentMonster)
      result=@currentPlayer.combat(@currentMonster)
      if result == CombatResult::LOSEANDCONVERT
        cultist = @dealer.nextCultist
        p = CultistPlayer.new(@currentPlayer,cultist)
        @players.insert(@players.index(@currentPlayer),p)
        @players.pop(@players.index(@currentPlayer))
        @currentPlayer = p        
      end
      result
    end
    
    def discardVisibleTreasures(treasures)
      for t in treasures
        @currentPlayer.discardVisibleTreasure(t)
        @dealer.giveTreasureBack(t)
      end
    end
    
    def discardHiddenTreasures(treasures)
      for t in treasures
        @currentPlayer.discardHiddenTreasure(t)
        @dealer.giveTreasureBack(t)
      end
    end
    
    def makeTreasuresVisible(treasures)
      for t in treasures
        @currentPlayer.makeTreasureVisible(t)
      end
    end
    
    def initGame(players)
      initPlayers(players)
      setEnemies
      CardDealer.instance.initCards
      nextTurn
    end
    
    def nextTurn()
      stateOK = self.nextTurnAllowed
        
      if stateOK == true
        @currentMonster = @dealer.nextMonster
        @currentPlayer = nextPlayer
        muerto = @currentPlayer.isDead
        if muerto == true  
          @currentPlayer.initTreasures  
        end
      end
      stateOK
    end
    
    def endOfGame(result)
      res=false
      if(result==[CombatResult::WINGAME])
        res=true
      end
      res
    end
    
    private :initialize, :initPlayers, :nextPlayer, :nextTurnAllowed, :setEnemies
    attr_accessor :currentPlayer, :currentMonster
    
  end
end
