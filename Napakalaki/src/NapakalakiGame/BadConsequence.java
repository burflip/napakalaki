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
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public boolean isEmpty(){
        return (this.nHiddenTreasures == 0 && this.nVisibleTreasures == 0 && this.specificHiddenTreasures.isEmpty() && this.specificVisibleTreasures.isEmpty());
    }
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }

    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
    }

    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
        this.specificVisibleTreasures = (ArrayList<TreasureKind>) tVisible.clone();
        this.specificHiddenTreasures = (ArrayList<TreasureKind>) tHidden.clone();
        this.text = text;
        this.levels = levels;
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
        return "BadConsequence{" + "text=" + text + ", levels=" + levels + ", nVisibleTreasures=" + nVisibleTreasures + ", nHiddenTreasures=" + nHiddenTreasures + ", death=" + death + ", specificHiddenTreasures=" + specificHiddenTreasures + ", specificVisibleTreasures=" + specificVisibleTreasures + '}';
    }  
    
    public void substractVisibleTreasure(Treasure t){
        
    }
    
    public void substractHiddenTreasure(Treasure t){
        
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        return this;
    } 
}
