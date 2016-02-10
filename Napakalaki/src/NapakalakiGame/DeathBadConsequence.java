/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

public class DeathBadConsequence extends NumericBadConsequence{
    
    private boolean death=false;
    
    public DeathBadConsequence(String text, boolean death) {
        super(text,Player.MAXLEVEL,MAXTREASURES,MAXTREASURES);
        this.text = text;
        this.death = death;
    }
   
    @Override
    public String toString()
    {
        String toRet = "Estás muerto\nDescarta todos tus tesoros";
        
        return toRet;
    }
}
