/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author mario-cabesa
 */
public class Player {
    static final int MAXLEVEL = 10; 
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    
    public Player(String name) {
        this.name = name;
        
    }
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){//*************************
    
    }
    
    private int getCombatLevel(){
        return level;
    }
    
    private void incrementLeveles(int i){
        level += i;
    }
    
    private void decrementLevels(int i){
        level -= i;
    }
    
    private void setPendingBadConsequence(BadConsequence b){//******************************
           
    }
    
    private void applyPrize(Monster m){
    
    }
    
    private void applyBadConsequence(Monster m){
    
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
    }
    
    private void dieIfNoTreasures(){
    
    }
    
    public boolean isDead(){}
    
    public Treasure [] getHiddenTreasure(){}
    
    public Treasure[] getVisibleTreasure(){}
    
    public CombatResult(Monster m){}
    
    public void makeTreasureVisible(Treasure t){}
    
    public void discardVisibleTreasures(Treasure t){}
    
    public boolean validState(){}
    
    public void initTreasures(){}
    
    public int getLevels(){}
    
    public Treasure stealTreasure(){}
    
    public void setEnemy(Player enemy){}
    
    private Treasure giveMeATreasure(){}
    
    public boolean canISteal(){}
    
    private boolean canYouGiveMeATreasure(){}
    
    private  void haveStolen(){}
    
    public void discardAllTreasures(){}
}
