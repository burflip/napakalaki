/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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
        for(String nombre : nombres) {
            this.players.add(new Player(nombre));
        }
    }
    
    private Player nextPlayer(){
        Player p;
        if(currentPlayer != null) {
            int s = this.players.size();
            int pos = this.players.indexOf(this.currentPlayer);
            if(pos == s-1) {
                p = this.players.get(0);
            } else {
                p = this.players.get(pos);
            }            
        } else {
            int random = ThreadLocalRandom.current().nextInt(0, players.size());
            p = this.players.get(random);
        }
        return p;
    }
    
    private boolean nextTurnAllowed(){
       return (this.currentPlayer == null ? true : currentPlayer.validState());
    }
    
    private void setEnemies(){
        int random = ThreadLocalRandom.current().nextInt(0, players.size());
        for(Player player : this.players){
            while(player.getName() == null ? this.players.get(random).getName() == null : player.getName().equals(this.players.get(random).getName())) {
                random = ThreadLocalRandom.current().nextInt(0, players.size());
            }
            player.setEnemy(players.get(random));
            random = ThreadLocalRandom.current().nextInt(0, players.size());
        }
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
        return (result == CombatResult.WINGAME ? true : false);
    }
    
}
