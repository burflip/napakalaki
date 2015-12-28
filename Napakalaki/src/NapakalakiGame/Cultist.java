package NapakalakiGame;

/**
 *
 * @author valentin
 */
public class Cultist {
    private String name;
    private int gainedLevels;

    public Cultist(String name, int gainedLevels) {
        this.name = name;
        this.gainedLevels = gainedLevels;
    }

    public String getName() {
        return name;
    }

    public int getGainedLevels() {
        return gainedLevels;
    }
    
}
