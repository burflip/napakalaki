#encoding: utf-8
require_relative 'treasure_kind.rb'

module NapakalakiGame

  class BadConsequence
    
    attr_reader :text, :levels, :death, :nVisibleTreasures, :nHiddenTreasures, :specificVisibleTreasures, :specificHiddenTreasures
    
    private_class_method :new
    
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
  
    def isEmpty()
      (@nVisibleTreasures == 0 and @nHiddenTreasures == 0 and @specificVisibleTreasures.empty? and @specificHiddenTreasures.empty?)
    end
      
    def substractVisibleTreasure(t)

        if !@specificVisibleTreasures.nil? && @specificVisibleTreasures.include?(t.type)
          @specificVisibleTreasures.delete(t.type)
        end

        if (!@nVisibleTreasures.nil? && @nVisibleTreasures>0)
            @nVisibleTreasures = @nVisibleTreasures - 1
        end
    end

    def substractHiddenTreasure(t)
        if !@specificHiddenTreasures.nil? && @specificHiddenTreasures.include?(t.type)
              @specificHiddenTreasures.delete(t.type)
        end

        if (!@nHidden.nil? && @nHidden>0)
            @nHidden = @nHidden - 1
        end
    end
    
    def self.newDeath (aText)
      self.new(aText, 0, 0, 0, [], [], true)
    end
  
    def self.newLevelSpecificTreasures (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      self.new(aText, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures,  false)
    end
  
    def self.newLevelNumberOfTreasures (aText, someLevels, someVisibleTreasures, someHiddenTreasures)
      self.new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, [], [], false)
    end
    
    def adjustToFitTreasureLists(v, h)
      
      if(@nVisibleTreasures > v.size)
        @nVisibleTreasures = v.size
      end
      
      if(@nHiddenTreasures > h.size)
        @nHiddenTreasures = h.size
      end
      
      temp_tk = Array.new
      temp_t = Array.new(v)

      for tk in @specificVisibleTreasures
        contains = false
        index = 0
        for t in temp_t
          if(tk = t.getType)
            contains = true
            index = temp_t.find_index(t)
          end
        end
        
        if(contains)
          temp_tk.push(tk)
          temp_t.delete_at(index)
        end
      end
      
      @specificVisibleTreasures = Array.new(temp_tk)
      temp_t = Array.new(h)
      temp_tk.clear
      
      for tk in @specificHiddenTreasures
        contains = false
        index = 0
        for t in temp_t
          if(tk = t.getType)
            contains = true
            index = temp_t.find_index(t)
          end
        end
        
        if(contains)
          temp_tk.push(tk)
          temp_t.delete_at(index)
        end
      end
      @specificHiddenTreasures = Array.new(temp_tk)
      self
    end
    
    def to_s
      "BadConsequence {text= #{@text} , levels= #{@levels} , nVisibleTreasures= #{@nVisibleTreasures} , nHiddenTreasures= #{@nHiddenTreasures} , death= #{@death} , specificHiddenTreasures= #{@specificHiddenTreasures} , specificVisibleTreasures= #{@specificVisibleTreasures}}"
    end
  
  end
end