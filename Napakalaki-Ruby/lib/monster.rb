#encoding: utf-8
require_relative 'bad_consequence.rb'
require_relative 'prize.rb'
require_relative 'treasure_kind.rb'

module NapakalakiGame
  
  class Monster
  
    def initialize(name,level,bc,prize,ic)
      @name = name
      @level = level
      @badConsequence = bc
      @prize = prize
      @levelChangeAgainstCultistPlayer = ic
    end
  
    attr_reader :name, :level, :badConsequence, :prize, :levelChangeAgainstCultistPlayer
    
    private_class_method :new
    
    def to_s
      "Monster{ name= #{@name}, combatLevel= #{@level}, prize= #{@prize}, badConsequence= #{@badConsequence}, ic=#{@ic}"
    end
    
    def getLevelsGained
      @prize.level
    end
    
    def getTresuresGained
      @prize.treasures
    end
    
    def self.newMonster(name,level,bc,prize)
      self.new(name,level,bc,prize,nil)
    end
    
    def self.newCultistMonster(name,level,bc,prize,ic)
      self.new(name,level,bc,prize,ic)
    end
  
  end
end