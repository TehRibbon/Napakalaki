/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

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
    private ArrayList<Treasure> HiddenTreasures;
    private ArrayList<Treasure> VisibleTreasures;
    private BadConsequence pendingBadConsequence;
    private Player enemy;
    
    
    //Constructor
    public Player(String name) {
        this.name = name;
        
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
    
    private void incrementLeveles(int i){
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
    
    private void applyPrize(Monster m){
    
    }
    
    private void applyBadConsequence(Monster m){
    
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
    
    public Treasure [] getHiddenTreasure(){}
    
    public Treasure[] getVisibleTreasure(){}
    
    public CombatResult(Monster m){}
    
    public void makeTreasureVisible(Treasure t){}
    
    public void discardVisibleTreasures(Treasure t){}
    
    /*Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y no tiene
      más de 4 tesoros ocultos, y false en caso contrario. Para comprobar que el jugador
      no tenga mal rollo que cumplir, utiliza el método isEmpty de la clase
      BadConsequence.*/
    
    public boolean validState(){
        boolean resultado = false;
        if( (this.pendingBadConsequence.isEmpty() ) && (this.HiddenTreasures.size() <= 4) )
            resultado = true;
        return resultado;
    }
    
    public void initTreasures(){}
    
    /*Devuelve el nivel del jugador.*/
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){}
    
    /*Asigna valor al atributo que referencia al enemigo del jugador.*/
    public Player getEnemy(){
        return this.enemy;
    }
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure(){}
    
    /*Devuelve true si el jugador no ha robado ningún tesoro a su enemigo y false en
      caso contrario.*/
    public boolean canISteal(){
        return canISteal;
    }
    
    /*Devuelve true si el jugador tiene tesoros para ser robados por otro jugador y false
      en caso contrario.*/
    
    private boolean canYouGiveMeATreasure(){
        boolean canYou = false;
        if(canISteal == true)
            canYou = true;
        return canYou;
    }
    
    /*Cambia el atributo canISteal a false cuando el jugador roba un tesoro.*/
    private  void haveStolen(){
        canISteal = false;
    }
    
    public void discardAllTreasures(){}
}
