/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class NumericBadConsequence extends BadConsequence {
    private int nVisibleTreasures, nHiddenTreasures;

    public NumericBadConsequence(String text, int levels, int nVisibleTreasures, int nHiddenTreasures) {
        super(text, levels);
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(this.nVisibleTreasures > 0) {
            this.nVisibleTreasures--;
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(this.nHiddenTreasures > 0) {
            this.nHiddenTreasures--;
        }
    }
    
    @Override
    public boolean isEmpty()
    {
        return (this.nVisibleTreasures == 0 && this.nHiddenTreasures  == 0); 
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h)
    {
        if(this.getnVisibleTreasures() > v.size()) {
            this.nVisibleTreasures = v.size();
        }
        if(this.getnHiddenTreasures() > h.size()) {
            this.nHiddenTreasures = h.size();
        }
        
        return this;
        
    }
    
    public int getnVisibleTreasures() {
        return this.nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return this.nHiddenTreasures;
    }
    
    @Override
    public String toString()
    {   
        String toRet = "Tesoros visibles que pierdes: " + nVisibleTreasures 
                + "\nTesoros ocultos que pierdes: " + nHiddenTreasures;
        
        return toRet;
    }
}
