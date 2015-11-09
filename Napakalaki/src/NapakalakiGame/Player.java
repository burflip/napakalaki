/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

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
        if(final_level> 10){
            this.level = 10;
        } else {
            this.level = final_level;
        }
    }
    
    private void decrementLevels(int l){
        
    }
    
    private void setPendingBadConsequence(BadConsequence bad) {
        
    }
    
    private void applyPrize(Monster m){
        
    }
    
    private void applyBadConsequence(Monster m){
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        return true;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        return 0;
    }
    
    private void dieIfNoTreasures(){
        
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
        return CombatResult.WIN;
    }
    
    public void makeTreasureVisible(Treasure t){
        
    }
    
    void discardVisibleTreasure(Treasure t){
        
    }
    
    void discardHiddenTreasure(Treasure t){
        
    }
    public boolean validState(){
        return true;
    }
    
    public void initTreasures(){
        
    } 
    
    public Treasure stealTreasure(){
        return new Treasure("", 0, TreasureKind.ARMOR);
    }
    
    public void setEnemy(Player enemy){
        
    }
    
    private Treasure giveMeATreasure(){
        return new Treasure("", 0, TreasureKind.ARMOR);
    }
    
    public boolean canISteal(){
        return true;
    }
    
    private boolean canYouGiveMeATreasure(){
        return true;
    }
    
    private void haveStolen(){
        
    }
    
    private void discardAllTreasures(){
        
    }
    
    
}
