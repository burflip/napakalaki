/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Valentin
 */
public class Player {
    public static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead, canISteal;
    private Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures, visibleTreasures;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    private void bringToLife(){
        this.dead = true;
    }
    
    private int getCombatLevel(){
        
        int combatLevel = this.getLevels();
        for (Treasure t: this.visibleTreasures){
            combatLevel += t.getBonus();
        }
        return combatLevel;
    }
    
    private void incrementLevels(int l){
        int final_level = this.level + l;
        if(final_level > 10){
            this.level = 10;
        } else {
            this.level = final_level;
        }
    }
    
    private void decrementLevels(int l){
        int final_level = this.level - l;
        if(final_level < 1){
            this.level = 1;
        } else {
            this.level = final_level;
        }
    }
    
    private void setPendingBadConsequence(BadConsequence bad) {
        this.pendingBadConsequence = bad;
    }
    
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();
        this.incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        if(nTreasures > 0) {
            CardDealer dealer;
            dealer = CardDealer.getInstance();
            for(int i=0; i<nTreasures;i++) {
                Treasure t = dealer.nextTreasure();
                this.hiddenTreasures.add(t);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence pendingBad, badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        this.decrementLevels(nLevels);
        pendingBad = badConsequence.adjustToFitTreasureLists(this.visibleTreasures, hiddenTreasures);
        this.setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        boolean can_make = true;
        boolean has_one_hand = false;
        boolean has_two_hand = false;
        boolean has_two_handed = false;
        for(Iterator<Treasure> iter = this.visibleTreasures.iterator(); iter.hasNext() && can_make;) {
            Treasure current_t = iter.next();
            if(current_t.getType() == t.getType() && t.getType() != TreasureKind.ONEHAND) {
                can_make=false;
            } else if(current_t.getType() == t.getType() && t.getType() == TreasureKind.ONEHAND && has_two_hand == true) {
                can_make=false;
            }
            
            if(current_t.getType() == TreasureKind.ONEHAND && has_one_hand == false) {
                has_one_hand = true;
            } else if(current_t.getType() == TreasureKind.ONEHAND && has_two_hand == false) {
                has_two_hand = true;
            } else if(current_t.getType() == TreasureKind.BOTHHANDS) {
                has_two_handed = true;
            }
            
            if(t.getType() == TreasureKind.BOTHHANDS && has_one_hand){
                can_make = false;
            }
            
            if(t.getType() == TreasureKind.ONEHAND && has_two_handed){
                can_make = false;
            }
        }
        return true;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int treasures = 0;
        for(Treasure tesoro:this.visibleTreasures){
            if(tesoro.getType() == tKind){
                treasures++;
            }
        }
        return treasures;
    }
    
    private void dieIfNoTreasures(){
        if(this.hiddenTreasures.isEmpty() && this.visibleTreasures.isEmpty()){
            this.dead = true;
        }
    }

    public int getLevels() {
        return level;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isCanISteal() {
        return canISteal;
    }

    public Player getEnemy() {
        return enemy;
    }

    public BadConsequence getPendingBadConsequence() {
        return pendingBadConsequence;
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
        int myLevel = this.getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        CombatResult c_result;
        if(myLevel > monsterLevel) {
            this.applyPrize(m);
            if(this.level >= MAXLEVEL) {
                c_result = CombatResult.WINGAME;
            } else {
                c_result = CombatResult.WIN;
            }
        } else {
            this.applyBadConsequence(m);
            c_result = CombatResult.LOSE;
        }
        return c_result;
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canI = this.canMakeTreasureVisible(t);
        if(canI) {
            this.visibleTreasures.add(t);
            this.hiddenTreasures.remove(t);
        }
    }
    
    void discardVisibleTreasure(Treasure t){
        this.visibleTreasures.remove(t);
        if(this.pendingBadConsequence != null && !this.pendingBadConsequence.isEmpty()){
            this.pendingBadConsequence.substractVisibleTreasure(t);
        }
        this.dieIfNoTreasures();
    }
    
    void discardHiddenTreasure(Treasure t){
        this.hiddenTreasures.remove(t);
        if(this.pendingBadConsequence != null && !this.pendingBadConsequence.isEmpty()){
            this.pendingBadConsequence.substractHiddenTreasure(t);
        }
        this.dieIfNoTreasures();
    }
    public boolean validState(){
        return (this.pendingBadConsequence.isEmpty() && this.hiddenTreasures.size() <= 4);
    }
    
    public void initTreasures(){
        Dice dice = Dice.getInstance();
        CardDealer dealer = CardDealer.getInstance();
        
        this.bringToLife();
        Treasure t = dealer.nextTreasure();
        this.hiddenTreasures.add(t);
        int number = dice.nextNumber();
        if(number > 1) {
            t = dealer.nextTreasure();
            this.hiddenTreasures.add(t);
        }
        if(number == 6){
            t = dealer.nextTreasure();
            this.hiddenTreasures.add(t);
        }
    } 
    
    public Treasure stealTreasure(){
        boolean canI = this.canISteal();
        Treasure t = null;
        if(canI) {
            boolean canYou = this.enemy.canYouGiveMeATreasure();
            if(canYou) {
                Treasure treasure = this.enemy.giveMeATreasure();
                this.hiddenTreasures.add(treasure);
                this.haveStolen();
            }
        }
        return t;
    }
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure(){
        int t_i = this.hiddenTreasures.size();
        Treasure t;
        if(t_i > 0) {
           int random = ThreadLocalRandom.current().nextInt(0, t_i);
           t = this.hiddenTreasures.get(t_i);
        } else {
            t =  null;
        }
        
        return t;
    }
    
    public boolean canISteal(){
        return true;
    }
    
    private boolean canYouGiveMeATreasure(){
        return !(this.hiddenTreasures.isEmpty());
    }
    
    private void haveStolen(){
        this.canISteal = true;
    }
    
    private void discardAllTreasures(){
        for(Treasure t:this.visibleTreasures) {
            this.discardVisibleTreasure(t);
        }
        for(Treasure t:this.hiddenTreasures) {
            this.discardHiddenTreasure(t);
        }
    }
    
    
}
