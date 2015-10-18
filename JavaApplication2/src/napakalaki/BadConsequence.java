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
    
     public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        
    }
     
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
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
    
    public ArrayList<TreasureKind> getTesorosEspecificosOcultos(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getTesorosEspecificosVisibles(){
        return specificVisibleTreasures;
    }

   
    
    private String auxiliarString(ArrayList<TreasureKind> datos){ //Para recorrer los vectores

        String solucion="" ;

        for (TreasureKind uno: datos){

            solucion += uno.toString() + "\t";
        }
        return solucion;

    }
    
    public String toString(){
        return "Texto = " + text + " niveles que se pierden = " + Integer.toString(levels) 
                + "Tesoros visibles que se pierden =" + Integer.toString(nVisiblesTreasures) 
                + "Tesoros ocultos que se pierden =" + Integer.toString(nHiddenTreasures)  
                + "Tesoros ocultos específicos =" + auxiliarString(specificHiddenTreasures)
                + "Tesoros visibles específicos =" + auxiliarString(specificVisibleTreasures)
                ;
    }
    
    
    
}