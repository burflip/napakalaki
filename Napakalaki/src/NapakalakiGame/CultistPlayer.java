package NapakalakiGame;

/**
 *
 * @author valentin
 */
public class CultistPlayer extends Player {
    
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;

    public CultistPlayer(Cultist myCultistCard, Player p) {
        super(p);
        this.myCultistCard = myCultistCard;
    }
    
    protected int getCombatLevel() {
        return 1;
    }
    
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    protected boolean shouldConvert() {
        return true;
    }
    
    private Treasure giveMATreasure() {
        return new Treasure("",1,TreasureKind.ARMOR);
    }
    
    private boolean canYouGiveMeATreasure() {
        return true;
    }

    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }    
    
    
}
