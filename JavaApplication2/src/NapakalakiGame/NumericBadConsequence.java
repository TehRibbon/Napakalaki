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
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> visible, ArrayList<Treasure> hidden)
    {
        BadConsequence bad;
        ArrayList<TreasureKind> auxOcultos= new ArrayList();
        ArrayList<TreasureKind> auxVisibles  = new ArrayList(); 
        
        
        //if(this.auxOcultos.isEmpty() && this.auxVisibles.isEmpty()){
            int visibles = 0;
            int ocultos = 0;
            
            int tamV = visible.size();
            int tamO = hidden.size();
            
            if(nVisiblesTreasures <= tamV){
                visibles = nVisiblesTreasures;
            }
            else if(tamV < nVisiblesTreasures){
                visibles = tamV;
            }
            
            if(nHiddenTreasures <= tamO){
                ocultos = nHiddenTreasures;
            }
            else if(tamO < nHiddenTreasures){
                ocultos = tamO;
            }
                 
            bad = new NumericBadConsequence("",0,visibles,ocultos);
                        
            
        //    }
        return bad;
    }
        

    
    
    @Override
    public String toString(){
        return  "\n>Tesoros visibles que se pierden =" + Integer.toString(nVisiblesTreasures) 
                + "\n>Tesoros ocultos que se pierden =" + Integer.toString(nHiddenTreasures);
    }

    @Override
    public boolean getDeath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void substractVisibleTreasure(Treasure t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void substractHiddenTreasure(Treasure t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
