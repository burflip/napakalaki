# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  class Treasure
    attr_accesor :name, :bonus, :type
    
    def initialize(name,bonus,t)
      @name = name
      @bonus = bonus
      @type = t
    end    
    
  end
end
