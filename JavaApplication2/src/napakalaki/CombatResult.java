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
    @Override
    public String toString(){
    String solucion = "";
    switch (this){
        case WINGAME : solucion = "Has ganado el juego.";
            break;
        case WIN : solucion = "Has ganado.";
            break;
        case LOOSE : solucion = "Has perdido";
            break;
        default: 
            return "Error.";
    }
    return solucion;
    }
    
}