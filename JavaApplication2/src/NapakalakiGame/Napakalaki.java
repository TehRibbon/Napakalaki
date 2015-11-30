/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame; //NAPAKALAKI

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
            dealer = CardDealer.getInstance();
            players = new ArrayList();
            
            for(String iterador: names){
                players.add(new Player(iterador));
                
                
            }
            
            
            currentPlayer = nextPlayer();
        
    
    
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
        boolean solucion = true;
        
        if(currentPlayer != null)
            solucion = currentPlayer.validState();
        
        return solucion;
    }
    
    /*Se asigna un enemigo a cada jugador. Esta asignación se hace de forma aleatoria teniendo
      en cuenta que un jugador no puede ser enemigo de sí mismo.*/
    private void setEnemies(){
        int tamanio = players.size();
        int posAleatoria; 
        
        for(Player iterador: players){
            posAleatoria = (int) (Math.random() * tamanio);
            
            while(players.get(posAleatoria) == iterador){
                posAleatoria = (int) (Math.random() * tamanio);
            }
                
            iterador.setEnemy(players.get(posAleatoria)); 
        }    
       
    }
    
    /*Operación responsabilidad de la única instancia de Napakalaki, la cual pasa el control al
    jugador actual (currentPlayer) para que lleve a cabo el combate con el monstruo que le ha
    tocado (currentMonster). El método de la clase Player con esa responsabilidad es
    combat(currentMonster:Monster): CombatResult, cuyo comportamiento general (también
    reflejado en el diagrama y responsabilidad de Player) es: si el nivel de combate del jugador
    supera al del monstruo, se aplica el buen rollo y se puede ganar el combate o el juego, en
    otro caso, el jugador pierde el combate y se aplica el mal rollo correspondiente.*/
    public CombatResult developCombat(){
        CombatResult combat = currentPlayer.combat(currentMonster);
        
        this.dealer.giveMonsterBack(this.currentMonster);
        return combat;
        
        
    }
    
    /*Operación encargada de eliminar los tesoros visibles indicados de la lista de tesoros
    visibles del jugador. Al eliminar esos tesoros, si el jugador tiene un mal rollo pendiente, se
    indica a éste dicho descarte para su posible actualización. Finalmente, se invoca a
    dieIfNoTreasure() para comprobar si se ha quedado sin tesoros y en ese caso pasar a
    estado de muerto. Los tesoros descartados se devuelven al CardDealer.*/
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure it: treasures){
            this.currentPlayer.discardVisibleTreasures(it);
            this.dealer.giveTreasureBack(it);
        }
            
    }
    
    
    /*Análoga a la operación anterior aplicada a tesoros ocultos.
    Plantéate como ejercicio de refuerzo realizar el diagrama de comunicación correspondiente
    a esta operación.*/
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(Treasure it: treasures){
            this.currentPlayer.discardHiddenTreasures(it);
            this.dealer.giveTreasureBack(it);
        }
    }
    
    /*Operación en la que se pide al jugador actual que pase tesoros ocultos a visibles, siempre
    que pueda hacerlo según las reglas del juego, para ello desde Player se ejecuta el método:
    canMakeTreasureVisible(treasures:Treasure ):boolean*/
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure it: treasures){
            currentPlayer.makeTreasureVisible(it);
        }
    }
    
    /*Se encarga de solicitar a CardDealer la inicialización de los mazos de cartas de Tesoros y
    de Monstruos, de inicializar los jugadores proporcionándoles un nombre, asignarle a cada
    jugador su enemigo y de iniciar el juego con la llamada a nextTurn() para pasar al siguiente
    turno (que en este caso será el primero).*/
    public void initGame(ArrayList<String> players){
        
        this.initPlayers(players);
        this.dealer.initCards();
        this.nextTurn();
        
        this.setEnemies();
        
     
        

        }
    
    /*Devuelve el jugador actual (currentPlayer).*/
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    /*Devuelve el monstruo en juego (currentMonster).*/
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    /*Esta operación usa el método nextTurnAllowed(), donde se verifica si el jugador activo
    (currentPlayer) cumple con las reglas del juego para poder terminar su turno.
    En caso el caso que nextTurnIsAllowed() devuelva true, se le solicita a CardDealer el
    siguiente monstruo al que se enfrentará ese jugador (currentMonster) y se actualiza el
    jugador activo al siguiente jugador.
    En caso de que el nuevo jugador activo esté muerto, por el comb ate en su anterior turno o
    porque es el primer turno, se inicializan sus tesoros siguiendo las reglas del juego. La
    inicialización de los tesoros se encuentra recogida en el diagrama subordinado
    initTreasures.*/
    public boolean nextTurn(){
        
        boolean stateOk = nextTurnAllowed();
        boolean dead = currentPlayer.isDead();
        currentPlayer.toString();
        if(stateOk){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
             System.out.println("valid state ok"); 
            if(dead){
                currentPlayer.initTreasures();
                System.out.println("inicializo treasures");
            }
        } else {
            this.currentMonster = this.dealer.nextMonster(); //Al no poder cambiar de turno, el monstruo no cambia
        }
        
        if(currentPlayer == null)
            stateOk = true;
        
        return stateOk;

    }
    
    /*Devuelve true si el parámetro result es WINGAME (valor del enumerado CombatResult). En
      caso contrario devuelve false.*/
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGAME;
    
    }
    
   
}