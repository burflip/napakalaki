package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author valentin
 */
public class BadConsequence {
    public static final int MAXTREASURES = 10;
    
    private String text;
    private int levels=0, nVisibleTreasures=0, nHiddenTreasures=0;
    private boolean death=false;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    public boolean isEmpty(){
        return (this.nHiddenTreasures == 0 && this.nVisibleTreasures == 0 && this.specificHiddenTreasures.isEmpty() && this.specificVisibleTreasures.isEmpty());
    }
    
    public BadConsequence() {
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }

    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }

    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
        this.specificVisibleTreasures = (ArrayList<TreasureKind>) tVisible.clone();
        this.specificHiddenTreasures = (ArrayList<TreasureKind>) tHidden.clone();
        this.text = text;
        this.levels = levels;
    }
    
    public BadConsequence(BadConsequence b) {
        this.text = b.getText();
        this.levels = b.getLevels();
        this.nVisibleTreasures = b.getnVisibleTreasures();
        this.nHiddenTreasures = b.getnHiddenTreasures();
        specificHiddenTreasures = new ArrayList<>(b.getSpecificHiddenTreasures());
        specificVisibleTreasures = new ArrayList<>(b.getSpecificVisibleTreasures());
    }

    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }

    public boolean isDeath() {
        return death;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }

    @Override
    public String toString() {
        return "BadConsequence{\n" + "text=\n" + text + "\n levels=" + levels + "\n nVisibleTreasures=" + nVisibleTreasures + "\n nHiddenTreasures=" + nHiddenTreasures + "\n death=" + death + "\n specificHiddenTreasures=" + specificHiddenTreasures + "\n specificVisibleTreasures=" + specificVisibleTreasures + "\n}";
    }  
    
    public void substractVisibleTreasure(Treasure t){
        int i = this.specificVisibleTreasures.indexOf(t.getType());
        if(i == -1 && this.nVisibleTreasures > 0) {
            this.nVisibleTreasures--;
        } else if (i != -1) {
            this.specificVisibleTreasures.remove(i);
        }
    }
    
    public void substractHiddenTreasure(Treasure t){
        int i = this.specificHiddenTreasures.indexOf(t.getType());
        if(i == -1 && this.nHiddenTreasures > 0) {
            this.nHiddenTreasures--;
        } else if (i != -1) {
            this.specificHiddenTreasures.remove(i);
        }
    }
    
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
    } 
}
