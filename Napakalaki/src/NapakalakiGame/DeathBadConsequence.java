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
public class DeathBadConsequence extends NumericBadConsequence{
    
    private boolean death=false;
    
    public DeathBadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
    }
    
}
