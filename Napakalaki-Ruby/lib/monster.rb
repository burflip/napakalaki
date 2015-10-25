#encoding: utf-8
require './bad_consequence.rb'
require './prize.rb'
require './treasure_kind.rb'

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
  
end