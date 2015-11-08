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
public enum CombatResult {
    
    WINGAME, WIN, LOOSE;
    
    public String toString(){
    switch (this){
        case WINGAME:
            return "Has ganado el juego.";
        case WIN:
            return "Has ganado";
        case LOOSE:
            return "Has perdido";
        default: 
            return "Error.";
    }
    }
    
}
