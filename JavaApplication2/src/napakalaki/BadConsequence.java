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
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        //Inicializo todos los parámetros
        this.text = text;
        this.levels = levels;
        this.nVisiblesTreasures = nVisible; 
        this.nHiddenTreasures = nHidden;
    
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
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures  = new ArrayList();       

    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        
}
    
    
    
}