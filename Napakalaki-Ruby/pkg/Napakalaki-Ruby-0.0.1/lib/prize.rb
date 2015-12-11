#encoding: utf-8
module NapakalakiGame
  class Prize
  
    def initialize(treasures, level)
      @treasures = treasures
      @level = level
    end
  
  
    attr_reader :treasures, :level
  
    def to_s
      "Prize {Tesoros ganados: #{@treasures} \n Niveles ganados: #{@level}}"
    end
  
  end
end