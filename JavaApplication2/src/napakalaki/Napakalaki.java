/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki; //NAPAKALAKI

import java.util.ArrayList;


/**
 *
 * @author mario
 */
public class Napakalaki{ 

    /**
     * @param args the command line arguments
     */
    
    //Atributos
    
    private static Napakalaki instance = null;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer = CardDealer.getInstance();
    private Monster currentMonster;
    
    //Constructor
    private Napakalaki(){}
    
    //Patrón Singleton
    public static Napakalaki getInstance(){
        if(instance == null){
            instance = new Napakalaki();
        }
        return instance;
    }
    
    //Métodos
    private void initPlayers(ArrayList<String> names ){}
    private Player nextPlayer(){}
    private boolean nextTurnAllowed(){}
    private void setEnemies(){}
    
    public CombatResult developCombat(){}
    public void discardVisibleTreasures(){}
    public void discardHiddenTreasures(){}
    public void makeTreasuresVisible(){}
    public void initGame(ArrayList<String> players){}
    public Player getCurrentPlayer(){}
    public Monster getCurrentMonster(){}
    public boolean nextTurn(){}
    public boolean endOfGame(CombatResult result){}
    

}