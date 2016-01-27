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
public class Prize {
    private int treasures;//Tesoros que se obtienen como premio
    private int level;//Niveles que se obtienen como premio
    
    public Prize(int treasures, int level){
        this.treasures = treasures;
        this.level = level;
    }
    
    public int getTreasures(){
        return treasures;
    }
    
    public int getLevel(){
        return level;
    }
    
    
    public String toString(){
        return "Tesoros = " + Integer.toString(getTreasures()) + "  Niveles = " + Integer.toString(level);
    }

    /**
     * @param treasures the treasures to set
     */
    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }
 
    
    
}
