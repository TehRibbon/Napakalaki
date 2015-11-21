/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki; //NAPAKALAKI

import java.util.ArrayList;
import java.util.Random;


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
        
        int indice_siguiente = 0;
        Player nextPlayer;
        int total_jugadores;
        total_jugadores = this.players.size();//Obtenemos numero de jugadores
        
        //si no está definido el jugador actual significa que es la primera jugada
        if(currentPlayer == null){
            for(int i=0; i<1; i++)
                indice_siguiente = (int)(Math.random()* total_jugadores);
        }
        else{ 
            
            int indiceJugadorActual= this.players.indexOf(this.currentPlayer);
            
            if ( indiceJugadorActual == total_jugadores - 1){
            //Si es el ultimo seleccionamos el primero
                indice_siguiente = 0;
            } 
            else {
                //seleccionamos el siguiente
                indice_siguiente = indiceJugadorActual + 1;
            }
            
        }
        
        nextPlayer = this.players.get(indice_siguiente);
        
        this.currentPlayer = nextPlayer;
        
        
        return this.currentPlayer;
    
    }
    
    /*Método que comprueba si el jugador activo (currentPlayer) cumple con las reglas del juego
      para poder terminar su turno. Devuelve false si el jugador activo no puede pasar de turno y
      true en caso contrario, para ello usa el método de Player validState() donde se realizan las
      comprobaciones pertinentes.*/
    private boolean nextTurnAllowed(){
        return currentPlayer.validState();
    }
    
    /*Se asigna un enemigo a cada jugador. Esta asignación se hace de forma aleatoria teniendo
      en cuenta que un jugador no puede ser enemigo de sí mismo.*/
    private void setEnemies(){
        Random rand = new Random(); //creamos instancia de Random
        int posAleatoria = rand.nextInt(players.size());
        for(Player iterador: players){
            while(iterador != iterador.getEnemy()){
                iterador.setEnemy(players.get(posAleatoria)); 
            }    
        }
    }
    
    public CombatResult developCombat(){}
    public void discardVisibleTreasures(){}
    public void discardHiddenTreasures(){}
    public void makeTreasuresVisible(){}
    
    /*Se encarga de solicitar a CardDealer la inicialización de los mazos de cartas de Tesoros y
    de Monstruos, de inicializar los jugadores proporcionándoles un nombre, asignarle a cada
    jugador su enemigo y de iniciar el juego con la llamada a nextTurn() para pasar al siguiente
    turno (que en este caso será el primero).*/
    public void initGame(ArrayList<String> players){
    
    }
    
    /*Devuelve el jugador actual (currentPlayer).*/
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    /*Devuelve el monstruo en juego (currentMonster).*/
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    public boolean nextTurn(){}
    
    /*Devuelve true si el parámetro result es WINGAME (valor del enumerado CombatResult). En
      caso contrario devuelve false.*/
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGAME;
    
    }
}