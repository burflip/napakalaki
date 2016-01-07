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
public class SpecificBadConsequence {
    private ArrayList<TreasureKind> specificHiddenTreasures, specificVisibleTreasures;
    
    
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
}
