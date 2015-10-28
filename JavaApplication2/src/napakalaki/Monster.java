/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author mario
 */

public class Monster {
    private final String name;
    private final int combatLevel;
    private BadConsequence mal_rollo;
    private Prize premio;
        
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return mal_rollo;
    }
    
    public Prize getPrize(){
        return premio;
    }
    
    public int getLevelsGained(){
        return premio.getLevel();
    }
    
    public Monster(String name, int level, BadConsequence bc, Prize price){
        this.name = name;
        this.combatLevel = level;
        this.mal_rollo=bc;
        this.premio=price;
            }
    
    public String toString(){
        return "Nombre = " + name +  "\nNivel de combate = " + Integer.toString(combatLevel)
                + "\nMal rollo = " + mal_rollo.toString()+ "\nPremio = " + premio.toString() + "\n";
    }
    
}
