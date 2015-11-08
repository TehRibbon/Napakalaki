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
    
    /*Constructor*/
    
    public Monster(String name, int level, BadConsequence bc, Prize price){
        this.name = name;
        this.combatLevel = level;
        this.mal_rollo=bc;
        this.premio=price;
            }
    public String getName(){
        return this.name;
    }
    
    public int getCombatLevel(){
        return this.combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return this.mal_rollo;
    }
    
    public Prize getPrize(){
        return this.premio;
    }
    
    /*Devuelve el número de niveles ganados proporcionados por su buen rollo.*/
    public int getLevelsGained(){
        return this.premio.getLevel();
    }
    
    /*Devuelve el número de tesoros ganados proporcionados por su buen rollo.*/
    public int getTreasuresGained(){
        return this.premio.getTreasures();
    }
    
    
    
    public String toString(){
        return "Nombre = " + this.name +  "\nNivel de combate = " + Integer.toString(this.combatLevel)
                + "\nMal rollo = " + this.mal_rollo.toString()+ "\nPremio = " + this.premio.toString() + "\n";
    }
    
}
