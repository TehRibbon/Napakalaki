/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.*;

/**
 *
 * @author mario-cabesa
 */
public abstract class BadConsequence{
    static final int MAXTREASURES = 10;
    private String text; //lo que dice el mal rollo
    private  int levels;//niveles que se pierden

    
    
    
    public BadConsequence(String text, int levels){
        //Inicializo todos los parámetros
        this.text = text;
        this.levels = levels;
    
    }  
     
   
    
    public int getMAXTREASURES(){
        return MAXTREASURES;
    }
    
    public abstract boolean getDeath();
   
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    public void setLevels(int level){
        this.levels = level;
    }
    
    public abstract int getVisibleTreasures();    
    
    
    public abstract int getHiddenTreasures();
    
    public abstract boolean isEmpty();
      
    
    public abstract ArrayList<TreasureKind> getSpecificVisibleTreasures();
    public abstract ArrayList<TreasureKind> getSpecificHiddenTreasures();
    
    /*Actualiza el mal rollo para que el tesoro visible t no forme parte del mismo. Es posible que
    esta actualización no implique cambio alguno, que lleve a eliminar un tipo específico de
    tesoro visible, o a reducir el número de tesoros visibles pendientes.*/
    public abstract void substractVisibleTreasure(Treasure t);
    /*Igual que el anterior, pero para los ocultos.*/
    public abstract void substractHiddenTreasure(Treasure t);
    
    /*Recibe como parámetros los tesoros visibles y ocultos de los que dispone el jugador y
    devuelve un nuevo objeto mal rollo que se ajusta a las posibilidades del jugador. Los
    atributos de BadConsequence que debemos tener en cuenta para ajustar el mal rollo que
    debe cumplir el jugador son nVisibleTreasures, nHiddenTreasures, specificVisibleTreasures y
    specificHiddenTreasures.
    
    Así, para un BadConsequence con los siguientes valores de esos atributos:
        nVisibleTreasures = 0
        nHiddenTreasures = 3
        specificVisibleTreasures = []
        specificHiddenTreasures = []
    si los parámetros recibidos son v=[ONEHAND, HELMET] y h=[SHOE], el mal rollo
    devuelto por la operación tendrá como estado:
        nVisibleTreasures = 0
        nHiddenTreasures = 1 (porque el jugador sólo puede llegar a perder un tesoro oculto)
        specificVisibleTreasures = []
        specificHiddenTreasures = []
    Pongamos otro ejemplo. Si el BadConsequence tuviese estado:
        nVisibleTreasures = 0
        nHiddenTreasures = 0
        specificVisibleTreasures = [BOTHHANDS]
        specificHiddenTreasures = [ONEHAND, ONEHAND, HELMET]
    y recibiese los parámetros v=[ONEHAND] y h=[ONEHAND, HELMET, ARMOR], el mal rollo
    devuelto por la operación tendría como estado:
        nVisibleTreasures = 0
        nHiddenTreasures = 0
        specificVisibleTreasures = []
        specificHiddenTreasures = [ONEHAND, HELMET]*/
    public abstract BadConsequence adjustToFitTreasureList(ArrayList<Treasure> visible, ArrayList<Treasure> hidden);
    

   
    
    
    public String toString(){
        return  text + "\n\t>Niveles que se pierden = " + Integer.toString(levels);
    }
    
    
    
}