package NapakalakiGame;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author valentin
 */
public class CultistPlayer extends Player {
    
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;

    public CultistPlayer(Player p, Cultist myCultistCard) {
        super(p);
        this.myCultistCard = myCultistCard;
        CultistPlayer.totalCultistPlayers++;
    }
    
    public int getCombatLevel() {
        float level = super.getCombatLevel();
        level += level*0.20;
        level += this.myCultistCard.getGainedLevels()*CultistPlayer.totalCultistPlayers;
        return (Math.round(level));
    }
    
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    protected boolean shouldConvert() {
        return false;
    }

    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
    
    protected boolean canYouGiveMeATreasure(){
        return !(this.visibleTreasures.isEmpty());
    }
    
    private Treasure giveMeATreasure(){
        int t_i = this.visibleTreasures.size();
        Treasure t;
        if(t_i > 0) {
           int random = ThreadLocalRandom.current().nextInt(0, t_i);
           t = this.visibleTreasures.get(random);
           this.visibleTreasures.remove(random);
        } else {
            t =  null;
        }
        return t;
    }
    
    
        
}
