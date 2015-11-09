#encoding: utf-8
require_relative 'bad_consequence.rb'
require_relative 'prize.rb'
require_relative 'treasure_kind.rb'

module NapakalakiGame
  
  class Monster
  
    def initialize(name,level,bc,prize)
      @name = name
      @level = level
      @badConsequence = bc
      @prize = prize
    end
  
    attr_reader :name, :level, :badConsequence, :prize
  
    def to_s
      "Monster{ name= #{@name}, combatLevel= #{@level}, prize= #{@prize}, badConsequence= #{@badConsequence}"
    end
    
    def getLevelsGained
      @prize.level
    end
    
    def getTresuresGained
      @prize.treasures
    end
  
  end
end