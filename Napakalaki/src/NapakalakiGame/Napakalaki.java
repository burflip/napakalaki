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
public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    private Player currentPlayer;
    private ArrayList<Player> players = new ArrayList<>();
    private Monster currentMonster;
    private CardDealer dealer = CardDealer.getInstance();
    
    private Napakalaki(){
        
    }
    
    private void initPlayers(ArrayList<String> nombres){
        
    }
    
    private Player nextPlayer(){
        return new Player("");
    }
    
    private boolean nextTurnAllowed(){
        return true;
    }
    
    private void setEnemies(){
        
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){
        return CombatResult.WIN;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        
    }
    
    public void initGame(ArrayList<String> players){
        
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Monster getCurrentMonster() {
        return currentMonster;
    }
    
    public boolean nextTurn(){
        return true;
    }
    public boolean endOfGame(CombatResult result){
        return true;
    }
    
}
