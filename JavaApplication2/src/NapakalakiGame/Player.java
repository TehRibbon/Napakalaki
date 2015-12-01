/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;
import static NapakalakiGame.CombatResult.*;

/**
 *
 * @author mario-cabesa
 */
public class Player {
    //Atributos
    static final int MAXLEVEL = 10; 
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private CombatResult resultadoCombate;
    private ArrayList<Treasure> HiddenTreasures = new ArrayList();
    private ArrayList<Treasure> VisibleTreasures = new ArrayList();
    private BadConsequence pendingBadConsequence = new BadConsequence("",0,0,0);
    private Player enemy;
    
    
    //Constructor
    public Player(String name) {
        this.name = name;
        this.level = 1;
    }
    
   
    
    
    
    //Métodos
    
    /*Devuelve el nombre del jugador.*/
    public String getName(){
        return name;
    }
    
    /*Devuelve la vida al jugador, modificando el atributo correspondiente. */
    private void bringToLife(){
        this.dead = false;
    }
    
    /*Devuelve el nivel de combate del jugador, que viene dado por su nivel más los
      bonus que le proporcionan los tesoros que tenga equipados, según las reglas del
      juego.*/
    private int getCombatLevel(){
        int level = this.level;
        //Recorremos los tesoros para obtener el bonus
        for(Treasure t : this.HiddenTreasures){
            level += t.getBonus();
        }
        for(Treasure t : this.VisibleTreasures){
            level += t.getBonus();
        }
        return level;
    }
    /*Incrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas del juego.*/
    
    private void incrementLevels(int i){
        this.level += i;
    }
    
    /*Decrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas de
      juego.*/
    
    private void decrementLevels(int i){
        this.level -= i;
        
        //El mínimo nivel es 1
        
        if(this.level < 1)
            this.level = 1;
    }
    /*Asigna el mal rollo al jugador, dándole valor a su atributo pendingBadConsequence.*/
    
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence = b;
    }
    
    /*Esta operación es la encargada de aplicar el buen rollo del monstruo vencido al jugador,
    sumando los niveles correspondientes y pidiendo al CardDealer que le dé el número de
    tesoros indicado en el buen rollo del monstruo. Esos tesoros se añaden a sus tesoros
    ocultos.*/
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();
        
        this.incrementLevels(nLevels);
        
        int nTreasures = m.getTreasuresGained();
        
        if(nTreasures > 0){
            CardDealer dealer = CardDealer.getInstance();
            
            for(int i= 0; i<= nTreasures; i++){
                
                Treasure t = dealer.nextTreasure();
                this.HiddenTreasures.add(t);
            }
        }    
    
    }
    
    /*Cuando el jugador ha perdido el combate, hay que considerar el mal rollo que le impone el
    monstruo con el que combatió. Para ello, decrementa sus niveles según indica el mal rollo y
    guarda una copia de un objeto badConsequence ajustada a los tesoros que puede perder.
    Es decir, un objeto mal rollo que refleje el mal rollo indicado por el monstruo pero
    eliminando las condiciones que el jugador no pueda cumplir según los tesoros de que
    disponga (por ejemplo si el mal rollo del monstruo implica perder 2 tesoros visibles y el
    jugador sólo tiene 1, entonces el mal rollo pendiente será de sólo 1 tesoro visible). La
    operación encargada de hacer esto es adjustToFitTreasureList de la clase badConsequence.
    Éste es el mal rollo pendiente (pendingbadConsequence) que el jugador almacenará y que
    deberá cumplir descartándose de esos tesoros antes de que pueda pasar al siguiente turno.*/
    private void applyBadConsequence(Monster m){
        BadConsequence badconsequence = m.getBadConsequence();
        int nLevels = badconsequence.getLevels();
        this.decrementLevels(nLevels);
        pendingBadConsequence = badconsequence.adjustToFitTreasureList(VisibleTreasures, HiddenTreasures);
        
        this.setPendingBadConsequence(pendingBadConsequence);
    }
    
    /*Devuelve el número de tesoros visibles de tipo tKind que tiene el jugador.*/
    private int howManyVisibleTreasures(TreasureKind tKind){
        int contador = 0;
        for(Treasure t : this.VisibleTreasures){
            if(t.getType() == tKind)
                contador++;
        }
        return contador;
    }
    
    /*Cambia el estado de jugador a muerto, modificando el correspondiente atributo.
      Esto ocurre cuando el jugador, por algún motivo, ha perdido todos sus tesoros.*/
    private void dieIfNoTreasures(){
        if(this.HiddenTreasures.isEmpty() && this.VisibleTreasures.isEmpty())
           this.dead = true;
    }
    
    /*Devuelve true si el jugador está muerto, false en caso contrario.*/
    
    public boolean isDead(){
       return this.dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return HiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return VisibleTreasures;
    }
    
    public CombatResult combat(Monster m){
        CombatResult combatResult;
        int myLevel = getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        
        if(myLevel > monsterLevel){
            this.applyPrize(m);
            
            if(myLevel >= MAXLEVEL)
                combatResult = WINGAME;
            else
                combatResult = WIN;
        }
        else{
            applyBadConsequence(m);
            combatResult = LOSE;
        }
        
        return combatResult;
    }
    
    /*Convierte un tesoro en visible*/
    public void makeTreasureVisible(Treasure t){
    boolean canI = this.canMakeTreasureVisible(t);
    
        if(canI){
            this.VisibleTreasures.add(t);
            this.HiddenTreasures.remove(t);
        }
    }
    
    /*Descarta un tesoro visible, si pendingBadConsequence está vacio se elimina un tesoro visible. Si no hay tesoros se llama a dieIfNoTreasures*/
    public void discardVisibleTreasures(Treasure t){
        this.VisibleTreasures.remove(t);
        
        if(this.pendingBadConsequence != null && !this.pendingBadConsequence.isEmpty()){
            this.pendingBadConsequence.substractVisibleTreasure(t);
            
        }
        
        this.dieIfNoTreasures();
    }
    
    /*Análogo al método anterior pero con los tesoros ocultos*/
    public void discardHiddenTreasures(Treasure t){
        this.HiddenTreasures.remove(t);
        
        if(this.pendingBadConsequence != null && !this.pendingBadConsequence.isEmpty()){
            this.pendingBadConsequence.substractHiddenTreasure(t);
        }
        
        this.dieIfNoTreasures();
                
    }
    /*Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y no tiene
      más de 4 tesoros ocultos, y false en caso contrario. Para comprobar que el jugador
      no tenga mal rollo que cumplir, utiliza el método isEmpty de la clase
      BadConsequence.*/
    
    public boolean validState(){
        boolean resultado = true;
        if( (!this.pendingBadConsequence.isEmpty() ) || (this.HiddenTreasures.size() > 4) )
            resultado = false;
        return resultado;
    }
    
    
    /*Cuando un jugador está en su primer turno o se ha quedado sin tesoros, hay que
    proporcionarle nuevos tesoros para que pueda seguir jugando. El número de tesoros que se
    les proporciona viene dado por el valor que saque al tirar el dado:
        -Si (dado == 1) roba un tesoro.
        -Si (1 < dado< 6) roba dos tesoros.
        -Si (dado == 6) roba tres tesoros.*/
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        this.HiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        
        if(number == 6){
            treasure = dealer.nextTreasure();
            this.HiddenTreasures.add(treasure);
        }
        
        if(number > 1){
            treasure = dealer.nextTreasure();
            this.HiddenTreasures.add(treasure);
            
        }
    }
    
    /*Devuelve el nivel del jugador.*/
    public int getLevels(){
        return level;
    }
    
    /*Cuando el jugador decide robar un tesoro a su enemigo, este método comprueba que
    puede hacerlo (sólo se puede robar un tesoro durante la partida) y que su enemigo tiene
    tesoros ocultos para ser robados (canYouGiveMeATreasure()), en el caso que así sea éste le
    proporciona un tesoro que se almacenará con sus ocultos. El jugador no puede volver a
    robar otro tesoro durante la partida. En el caso que no se haya podido robar el tesoro por
    algún motivo se devuelve null.*/
    public Treasure stealTreasure(){
        boolean canI = canISteal();
        Treasure treasure = null;
        if(canI){
            boolean canYou = enemy.canYouGiveMeATreasure();
            if(canYou){
                treasure = enemy.giveMeATreasure();                
                HiddenTreasures.add(treasure);
                this.haveStolen();
            } 
            
        }
        
        
        return treasure;
        
    }
    
    /*Asigna valor al atributo que referencia al enemigo del jugador.*/
    public Player getEnemy(){
        return this.enemy;
    }
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    /*Roba un tesoro*/
    private Treasure giveMeATreasure(){
        Treasure solucion;
        int posAleatoria = (int) (Math.random()*HiddenTreasures.size());
        solucion = HiddenTreasures.get(posAleatoria);
            
        return solucion;
    }
    
    /*Devuelve true si el jugador no ha robado ningún tesoro a su enemigo y false en
      caso contrario.*/
    public boolean canISteal(){
        return canISteal;
    }
    
    /*Devuelve true si el jugador tiene tesoros para ser robados por otro jugador y false
      en caso contrario.*/
    
    private boolean canYouGiveMeATreasure(){
        boolean solucion = false;
        
        if(HiddenTreasures.size() > 0 || VisibleTreasures.size() >0){
            solucion = true;
        }
       return solucion;
    }
    
    /*Cambia el atributo canISteal a false cuando el jugador roba un tesoro.*/
    private  void haveStolen(){
        canISteal = false;
    }
    
    /*El jugador se descarta de todos sus tesoros ocultos y visibles. Para cada tesoro que se
    descarta se hace uso de la operación discardVisibleTreasure(t:Treasure) o
    discardHiddenTreasure(t:Treasure) según corresponda, de esa forma se verifica si se cumple
    con algún mal rollo pendiente.*/
    public void discardAllTreasures(){
        for(int i=1; i<VisibleTreasures.size(); i++){
            Treasure treasure_visible = VisibleTreasures.get(i);
            discardVisibleTreasures(treasure_visible);
        }
        
        for(int j=1; j<HiddenTreasures.size(); j++){
            Treasure treasure_oculto = HiddenTreasures.get(j);
            discardHiddenTreasures(treasure_oculto);
        }
        
    }
    
    /*Comprueba si el tesoro t se puede pasar de oculto a visible según las reglas del juego.*/
    private boolean canMakeTreasureVisible(Treasure t){
        boolean resultado = false;
        TreasureKind tipo = t.getType();
        if(this.VisibleTreasures.size() < 4 ){
            switch(tipo){
                case ONEHAND: //Hay que hacer una serie de comprobaciones
                    //Comprobamos si tiene 
                    if(tipo == TreasureKind.BOTHHANDS)
                        resultado = false;
                    else{
                        int i=0;
                        //Comprobamos si tiene algun tesoro de una mano
                        for(Treasure tesoros : this.VisibleTreasures){
                            if(tesoros.getType().equals(TreasureKind.ONEHAND)){
                                i++;
                            }
                        }
                        
                        if( i == 2)
                            resultado = false;
                        else
                            resultado = true;
                        }
                    
                    break;
                case BOTHHANDS:
                    if(howManyVisibleTreasures(TreasureKind.ONEHAND) > 0){
                        resultado = false;
                    } else {
                        int j=0;
                        //Comprobamos si tiene algun tesoro de una mano
                        for(Treasure te : this.VisibleTreasures){
                            if(te.getType().equals(TreasureKind.BOTHHANDS)){
                                j++;
                            }
                        }
                        
                        if( j == 1){
                            resultado = false;
                        }
                        else
                            resultado = true;
                        
                        break;
                    }
                    default: 
                    resultado = howManyVisibleTreasures(tipo) == 0;
         
                    break;
            }
                
        }
        return resultado;
    }
    
    /*Devuelve un tesoro elegido al azar de entre los tesoros ocultos del jugador.*/
    private Treasure giveMeAtreasure() {

        Treasure tesoro;
        Random rand = new Random();
        int numero = rand.nextInt(this.HiddenTreasures.size());
        tesoro = this.HiddenTreasures.get(numero);
        return tesoro;
    }
    
    @Override
    public String toString(){
        
        return this.name;
    }
}
