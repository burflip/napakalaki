package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author valentin
 */
public abstract class BadConsequence {
    public static final int MAXTREASURES = 10;
    
    protected String text;
    protected int levels=0;
    
    
    
    public abstract boolean isEmpty();
    
    //return (this.nHiddenTreasures == 0 && this.nVisibleTreasures == 0 && this.specificHiddenTreasures.isEmpty() && this.specificVisibleTreasures.isEmpty());

    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure>v, ArrayList<Treasure> h);
    /*
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        if(this.getnVisibleTreasures() > v.size()) {
            this.nVisibleTreasures = v.size();
        }
        if(this.getnHiddenTreasures() > h.size()) {
            this.nHiddenTreasures = h.size();
        }
        
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
    } */
}
