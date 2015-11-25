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

public class Dice {
    private static Dice instance = null;
    
    //Constructor
    private Dice(){}
    
    //Patron de singleton
    
    public static Dice getInstance(){
        if (instance == null){
            instance = new Dice();
        }
        return instance;
    }
    
    public static int nextNumber(){
        int resultado=0;
        //Genera un número aleatorio entre 1 y 6 (ambos incluidos).
        for(int i=0; i<6; i++)
            resultado = (int)(Math.random()*6)+1;
        return resultado;
    }
}
