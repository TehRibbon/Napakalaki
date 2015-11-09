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
public class Dice {
    private static Dice instance = null;
    
    //Constructor
    private Dice(){}
    
    //Patron de enumeration
    
    public static Dice getInstance(){
        if (instance == null){
            instance = new Dice();
        }
        return instance;
    }
    
    public static int nextNumber(){
        
        //Nose como va..
    
    }
}
