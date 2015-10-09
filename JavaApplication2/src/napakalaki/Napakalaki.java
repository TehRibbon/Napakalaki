/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki; //NAPAKALAKI

/**
 *
 * @author mario
 */
public class Napakalaki{ 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BadConsequence bc = new BadConsequence("HOlasoyunmonstruo", 5, 3, 2);
        Prize price = new Prize(4, 5);
        Monster monstruo = new Monster("monstruito", 5, bc, price);
        
        
    }
    
}