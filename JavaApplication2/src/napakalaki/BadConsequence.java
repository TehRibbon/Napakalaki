/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

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
    
    public int getTesorosVisibles(){
        return nVisiblesTreasures;
    }
    
    public int getTesorosOcultos(){
        return nHiddenTreasures;
    }
    
    public boolean isEmpty(){
        boolean empty = false;
        if(text == "" && death == false && levels == 0 && nVisiblesTreasures == 0 && nHiddenTreasures == 0 && specificVisibleTreasures == new ArrayList(Arrays.asList()) && specificHiddenTreasures == new ArrayList(Arrays.asList()) )
            empty = true;
        
        return empty;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    void substractVisibleTreasure(Treasure t){
        //
    }
    
    void substractHiddenTreasure(Treasure t){
        //
    }
    
        
    BadConsequence adjustToFitTreasureList(ArrayList<TreasureKind> visible, ArrayList<TreasureKind> hidden){
        //
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