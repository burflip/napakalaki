/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author valentin
 */
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;

    public Monster(String name, int level, BadConsequence bc, Prize prize ) {
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badConsequence = bc;
    }

    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public Prize getPrize() {
        return prize;
    }

    public BadConsequence getBadConsequence() {
        return badConsequence;
    }
    

    @Override
    public String toString() {
        return "Monster{" + "name=" + name + ", combatLevel=" + combatLevel + ", prize=" + prize + ", badConsequence=" + badConsequence + '}';
    }    
    
    public int getLevelsGained() {
        return 0;
    }
    
    public int getTreasuresGained() {
        return 0;
    }
}
