/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author mario
 */

public class Monster {
    private final String name;
    private final int combatLevel;
    private BadConsequence mal_rollo;
    private Prize premio;
    private int levelChangeAgainstCultistPlayer;
    
    /*Constructor*/
    
    public Monster(String name, int level, BadConsequence bc, Prize price){
        this.name = name;
        this.combatLevel = level;
        this.mal_rollo=bc;
        this.premio=price;
        levelChangeAgainstCultistPlayer = 0;
    }
    
    public Monster(String name, int levels, BadConsequence badConsequence, Prize p, int IC){
        this.name = name;
        this.combatLevel = levels;
        this.mal_rollo = badConsequence;
        this.premio = p;
        this.levelChangeAgainstCultistPlayer = IC;
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
    
    public int getCombatLevelAgainstCultistPlayer(){
        int solucion = this.combatLevel + this.levelChangeAgainstCultistPlayer;
        return solucion;
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
         return "Nombre = " + this.name +  "\n\t>Nivel de combate = " + Integer.toString(this.combatLevel)
                + "\n\t>Mal rollo = " + this.mal_rollo.toString()+ "\n\t>Premio = " + this.premio.toString() + "\n";
    }
    
   
}
