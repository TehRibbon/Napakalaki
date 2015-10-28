/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author mario-cabesa
 */
//EXAMEN-inicio
public class AlterEgo {
    private ArrayList<Monster> array_monstruos = new ArrayList();
    private final String descripcion = "Un alter ego es una personalidad alternativa y los monstruos también pueden tener amigos."; 
    public int nivelDeBondad;
    
    //Constructores
    public AlterEgo(int valor_bondad, ArrayList<Monster> monstruos){
        nivelDeBondad = valor_bondad;
        array_monstruos = monstruos;
    }
    
    public AlterEgo(int valor_bondad){
        nivelDeBondad= valor_bondad;
    }
    
    int getNivelDeBondad(){
        return nivelDeBondad;
    }
    
    
    public String toString(){
        return  "\nNivel de bondad = " + nivelDeBondad + "Su número de amigos es: " + array_monstruos;
    }

    
}
//EXAMEN-fin
