# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  class Treasure
    attr_accessor :name, :bonus, :type
    
    def initialize(n,b,t)
      @name = n
      @bonus = b
      @type = t
    end    
    
  end
end
