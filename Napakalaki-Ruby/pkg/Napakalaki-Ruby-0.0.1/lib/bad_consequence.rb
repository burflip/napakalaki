#encoding: utf-8
require './treasure_kind.rb'
module NapakalakiGame

  class BadConsequence
    
    @@MAXTREASURES = 10
    
    def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
      @text = aText
      @levels = someLevels
      @death = death
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
      @specificVisibleTreasures = someSpecificVisibleTreasures
      @specificHiddenTreasures = someSpecificHiddenTreasures
    end
  
    private_class_method :new
  
    attr_reader :text, :levels, :death, :nVisibleTreasures, :nHiddenTreasures, :specificVisibleTreasures, :specificHiddenTreasures
      
    def substractVisibleTreasure(t)
      
    end
    
    def substractHiddenTreasure(t)
      
    end
    
    def self.newDeath (aText)
      new(aText, 0, 0, 0, [], [], true)
    end
  
    def self.newLevelSpecificTreasures (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      new(aText, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures,  false)
    end
  
    def self.newLevelNumberOfTreasures (aText, someLevels, someVisibleTreasures, someHiddenTreasures)
      new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, [], [], false)
    end
    
    def adjustToFiTreasureLists(v,h)
      
    end
    
    def to_s
      "BadConsequence {text= #{@text} , levels= #{@levels} , nVisibleTreasures= #{@nVisibleTreasures} , nHiddenTreasures= #{@nHiddenTreasures} , death= #{@death} , specificHiddenTreasures= #{@specificHiddenTreasures} , specificVisibleTreasures= #{@specificVisibleTreasures}}"
    end
  
  end
end