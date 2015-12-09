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
public class DeathBadConsequence extends NumericBadConsequence {
    private boolean death; //mal rollo de tipo muerte
    public DeathBadConsequence(String text, boolean death){
        super(text,0,0,0);
        this.death = death;
    }
    
    @Override
    public boolean getDeath(){
        return death;
    }
    
    @Override
    public boolean isEmpty(){
        boolean empty = false;
        if(death == false )
            empty = true;
        
        return empty;
    }
}
