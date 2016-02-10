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
public class SpecificBadConsequence extends BadConsequence{
    private ArrayList<TreasureKind> specificHiddenTreasures, specificVisibleTreasures;

    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> specificHiddenTreasures, ArrayList<TreasureKind> specificVisibleTreasures) {
        super(text,levels);
        this.specificHiddenTreasures = specificHiddenTreasures;
        this.specificVisibleTreasures = specificVisibleTreasures;
    }
    
    
    
    public void substractVisibleTreasure(Treasure t){
        int i = this.specificVisibleTreasures.indexOf(t.getType());
        if (i != -1)
            this.specificVisibleTreasures.remove(i);
    }
    
    public void substractHiddenTreasure(Treasure t){
        int i = this.specificHiddenTreasures.indexOf(t.getType());
        if (i != -1)
            this.specificHiddenTreasures.remove(i);
    }
    
    @Override
    public boolean isEmpty()
    {
        return (this.specificVisibleTreasures.isEmpty() && this.specificHiddenTreasures.isEmpty()); 
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        ArrayList<TreasureKind> temp_tk = new ArrayList();
        ArrayList<Treasure> temp_t = new ArrayList(v);
        
        for(TreasureKind tk:this.specificVisibleTreasures) {
            boolean contains = false;
            int index = 0;
            for(Treasure t:temp_t) {
                if(tk == t.getType()) {
                    contains = true;
                    index = temp_t.indexOf(t);
                }
            }
            
            if(contains) {
                temp_tk.add(tk);
                temp_t.remove(index);
            }
                
        }
        
        this.specificVisibleTreasures = new ArrayList(temp_tk);
        temp_t = new ArrayList(h);
        temp_tk.clear();
        
        for(TreasureKind tk:this.specificHiddenTreasures) {
            boolean contains = false;
            int index = 0;
            for(Treasure t:temp_t) {
                if(tk == t.getType()) {
                    contains = true;
                    index = temp_t.indexOf(t);
                }
            }
            
            if(contains) {
               temp_tk.add(tk);
               temp_t.remove(index); 
            } 
        }
        
        this.specificHiddenTreasures = new ArrayList(temp_tk);
        
        return this;
    }
    @Override
    public String toString()
    {
        String toRet = "";
        
        if (!specificVisibleTreasures.isEmpty())
        {
            toRet = "\nT.V. que pierdes: ";

            for (int i = 0; i < specificVisibleTreasures.size(); i++)
                toRet += specificVisibleTreasures.get(i) + " ";
        }

        if (!specificHiddenTreasures.isEmpty())
        {
            toRet = "\nT.O. que pierdes: ";

            for (int i = 0; i < specificHiddenTreasures.size(); i++)
                toRet += specificHiddenTreasures.get(i) + " ";
        }
        
        return toRet;
    }
}
