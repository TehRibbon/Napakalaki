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
    /*Inicializa el array de jugadores que contiene Napakalaki, creando tantos jugadores como
      elementos haya en names, que es el array de String que contiene el nombre de los
      jugadores.*/
    private void initPlayers(ArrayList<String> names ){
        //Inicializamos el array de players
            players = new ArrayList();
            
            for(String iterador : names){
                players.add(new Player(iterador));
            }
        
    
    
    }
    
    /*Decide qué jugador es el siguiente en jugar.
      En primer lugar, se calcula el índice que ocupa el siguiente jugador en la lista de jugadores.
      Se pueden dar dos posibilidades:
      ◦ Que sea la primera jugada, en este caso hay que generar un número aleatorio entre 0 y
      el número de jugadores menos 1. Este número indicará el índice que ocupa en la lista
      de jugadores el jugador que comenzará la partida.
      ◦ Que no sea la primera jugada, en este caso el índice es el del jugador que se encuentra
      en la posición siguiente respecto al jugador actual. Hay que tener en cuenta que si el
      jugador actual está en la última posición de la lista, el siguiente será el que está en la
      primera posición.
      Una vez calculado el índice, se devuelve el jugador que ocupa esa posición.*/
    private Player nextPlayer(){

        int aux,total_jugadores, indice_jugadores, indice_jugador_actual;
        total_jugadores = players.size();//Obtenemos numero de jugadores
        aux = total_jugadores-1;
        
        if(currentPlayer == null){
            for(int i=0; i<1; i++)
                indice_jugadores = (int)(Math.random()* aux);
        }
        else if(indice_jugador_actual == total_jugadores) //Caso en el que el jugador esta en la última posición de la lista
                indice_jugadores = players.get(0);
            }
            else{
                indice_jugador_actual++;
                
            }
        return players.get(indice_jugadores);
    
    }
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