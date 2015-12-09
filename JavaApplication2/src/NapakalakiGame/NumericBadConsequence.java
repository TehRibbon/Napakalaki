/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author mario-cabesa
 */
public class NumericBadConsequence extends BadConsequence{
    private int nVisiblesTreasures;//nº de tesoros visibles que se pierden
    private int  nHiddenTreasures; //tesoros ocultos que se pierden
    
    public NumericBadConsequence(String text, int levels, int nVisibles, int nHidden){
        super(text,levels);
        this.nHiddenTreasures = nVisibles;
        this.nHiddenTreasures = nHidden;
    }
    
    @Override
    public int getVisibleTreasures(){
        return nVisiblesTreasures;
    }
    
    @Override
    public int getHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty(){
        boolean empty = false;
        if(nVisiblesTreasures == 0 && nHiddenTreasures == 0)
            empty = true;
        
        return empty;
    }
    
    @Override
    public String toString(){
        return  "\n\t>Tesoros visibles que se pierden =" + Integer.toString(nVisiblesTreasures) 
                + "\n\t>Tesoros ocultos que se pierden =" + Integer.toString(nHiddenTreasures);
    }
}
