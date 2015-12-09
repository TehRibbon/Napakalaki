/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author mario-cabesa
 */
public class SpecificBadConsequence extends BadConsequence{
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures  = new ArrayList(); 
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super(text,levels);
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
        
    }
    
    @Override
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    @Override
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        this.specificVisibleTreasures.remove(t.getType());
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        this.specificHiddenTreasures.remove(t.getType());
    }
    
    @Override
    public boolean isEmpty(){
        boolean empty = false;
        if(specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty())
            empty = true;
        
        return empty;
    }
    @Override
    public String toString(){
        return  "\n\t>Tesoros ocultos específicos que se pierden =" + specificHiddenTreasures
                + "\n\t>Tesoros visibles específicos que se pierden=" + specificVisibleTreasures;
    }
}
