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
public class BadConsequence {
    static final int MAXTREASURES = 10;
    private String text; //lo que dice el mal rollo
    private  int levels;//niveles que se pierden
    private int nVisiblesTreasures;//nº de tesoros visibles que se pierden
    private int  nHiddenTreasures; //tesoros ocultos que se pierden
    private boolean death; //mal rollo de tipo muerte
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures  = new ArrayList(); 
    
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        //Inicializo todos los parámetros
        this.text = text;
        this.levels = levels;
        this.nVisiblesTreasures = nVisible; 
        this.nHiddenTreasures = nHidden;
    
    }
    
     public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        
    }
     
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
    }
    
    public int getMAXTREASURES(){
        return MAXTREASURES;
    }
    
    public boolean getDeath(){
        return death;
    }
   
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    public void setLevels(int level){
        this.levels = level;
    }
    
    public int getVisibleTreasures(){
        return nVisiblesTreasures;
    }
    
    public int getHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public boolean isEmpty(){
        boolean empty = false;
        if(text == "" && death == false && levels == 0 && nVisiblesTreasures == 0 && nHiddenTreasures == 0 && specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty() )
            empty = true;
        
        return empty;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    /*Actualiza el mal rollo para que el tesoro visible t no forme parte del mismo. Es posible que
    esta actualización no implique cambio alguno, que lleve a eliminar un tipo específico de
    tesoro visible, o a reducir el número de tesoros visibles pendientes.*/
    void substractVisibleTreasure(Treasure t){
        this.specificVisibleTreasures.remove(t.getType());
    }
    /*Igual que el anterior, pero para los ocultos.*/
    void substractHiddenTreasure(Treasure t){
        this.specificHiddenTreasures.remove(t.getType());
    }
    
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
    BadConsequence adjustToFitTreasureList(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        ArrayList<TreasureKind> tVisible = new ArrayList();
        ArrayList<TreasureKind> tHidden = new ArrayList();
        
        for(Treasure t: visible){
            if (!tVisible.contains(t.getType()))
                tVisible.add(t.getType());
        }
        
        for(Treasure t: hidden){
            if(!tHidden.contains(t.getType())) 
                tHidden.add(t.getType());
        }
        
        BadConsequence bad = new BadConsequence(this.text,0, tVisible, tHidden);
        
        return bad;
        
        
    }
    

   
    
    private String auxiliarString(ArrayList<TreasureKind> datos){ //Para recorrer los vectores

        String solucion="" ;

        for (TreasureKind uno: datos){

            solucion += uno.toString() + "\t";
        }
        return solucion;

    }
    
    public String toString(){
        return  text + "\nNiveles que se pierden = " + Integer.toString(levels) 
                + "\nTesoros visibles que se pierden =" + Integer.toString(nVisiblesTreasures) 
                + "\nTesoros ocultos que se pierden =" + Integer.toString(nHiddenTreasures)  
                + "\nTesoros ocultos específicos que se pierden =" + auxiliarString(specificHiddenTreasures)
                + "\nTesoros visibles específicos que se pierden=" + auxiliarString(specificVisibleTreasures)
                ;
    }
    
    
    
}