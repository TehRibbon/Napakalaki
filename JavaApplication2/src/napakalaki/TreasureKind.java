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
public enum TreasureKind {

    ARMOR, ONEHAND, BOTHHANDS, HELMET, SHOES;
    @Override
    public String toString(){
    String solucion = "";
    switch (this) {
        case ARMOR : solucion = "ARMOR";
                break;
        case ONEHAND : solucion = "ONEHAND";
                break;
        case BOTHHANDS : solucion = "BOTHHANDS";
                break;
        case HELMET : solucion = "HELMET";
                break;
        case SHOES : solucion = "SHOES";
                break;
    }
    return solucion;
    
    }

}
