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
public enum CombatResult {
    
    WINGAME, WIN, LOSE, LOSEANDCONVERT;
    @Override
    public String toString(){
    String solucion = "";
    switch (this){
        case WINGAME : solucion = "Has ganado el juego.";
            break;
        case WIN : solucion = "Has ganado.";
            break;
        case LOSE : solucion = "Has perdido";
            break;
        case LOSEANDCONVERT : solucion = "Has perdido y te conviertes a sectario.";
                break;
        default: 
            return "Error.";
    }
    return solucion;
    }
    
}
