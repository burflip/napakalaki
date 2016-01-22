# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  class CultistPlayer < Player
    
    @@totalCultistPlayers = 0
    
    def initialize(p,myCultistCard)
      super(p)
      @myCultistCard = myCultistCard
      @@totalCultistPlayers += 1
    end
    
    def getCombatLevel
      level = super.getCombatLevel
      level += level*0.2
      level += @myCultistCard.getGainedLevels * @@totalCultistPlayers
    end
    
    def shouldConvert
      false
    end
    
    def getTotalCultistPlayers
      @@totalCultistPlayers
    end
    
    def canYouGiveMeATreasure
      !@visibleTreasures.isEmpty
    end
    
    def giveMeATreasure
      size = @visibleTreasures.count
      t = nil
      if(size > 0)
        random = rand(size)
        t = @visibleTreasures[random]
        @visibleTreasures.delete_at(random)
      end
    end
    
    t
  end
  
end
