/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mario-cabesa
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
    
        /*
        ArrayList<Monster> monstruos = new ArrayList();
        
       
        //Byakhees de bonanza
        BadConsequence badConsequence1 = new BadConsequence( "Pierdes tu armadura visible y otra oculta.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize1 = new Prize(2,1);
        monstruos.add(new Monster("Byakhees de bonanza",8, badConsequence1, prize1));
        //Chibithulhu 
        BadConsequence badConsequence2 = new BadConsequence ( "Embobados con el lindo primigenio te descartas de tu casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        Prize prize2 = new Prize(1,1);
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence2, prize2));
        //El sopor de Dunwich
        BadConsequence badConsequence3 = new BadConsequence( "El primordial bostezo contagioso. Pierdes el calzado visible.",0,new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList(Arrays.asList()));
        Prize prize3 = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich",2, badConsequence3, prize3));
        // Ángeles de la noche ibicenca
        BadConsequence badConsequence4 = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible  y 1 mano oculta.",0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize4 = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca",14, badConsequence4, prize4));
        //El gorrón del umbral
        BadConsequence badConsequence5 = new BadConsequence("Pierdes todos tus tesoros visibles.",0,5,0);
        Prize prize5 = new Prize(3,1);
        monstruos.add(new Monster("El gorrón del umbral",10, badConsequence5, prize5));
        //H.P. Munchcraft
        BadConsequence badConsequence6 = new BadConsequence("Pierdes la armadura visible.",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        Prize prize6 = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft",6, badConsequence6, prize6));
        //Bichgooth
        BadConsequence badConsequence7 = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        Prize prize7 = new Prize(1,1);
        monstruos.add(new Monster("Bichgooth",2, badConsequence7, prize7));
        //El rey de la rosa
        BadConsequence badConsequence = new BadConsequence( "Pierdes 5 niveles y 3 tesoros visibles." ,5, 3, 0);
        Prize prize8 = new Prize(4,2);
        monstruos.add(new Monster("El rey de rosa",13, badConsequence, prize8));
        //La que redacta en las tinieblas
        BadConsequence badConsequence9 = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2,0,0 );
        Prize prize9 = new Prize(1,1);
        monstruos.add(new Monster("La que redacta en las tinieblas",2, badConsequence9, prize9));
        //Los hondos
        BadConsequence badConsequence10 = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.", true);
        Prize prize10 = new Prize(2,1);
        monstruos.add(new Monster("Los hondos",8, badConsequence10, prize10));
        //Semillas Cthulhu
        BadConsequence badConsequence11 = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2,0,2 );
        Prize prize11 = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu",4, badConsequence11, prize11));
        //Dameargo
        BadConsequence badConsequence12 = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList()));
        Prize prize12 = new Prize(2,1);
        monstruos.add(new Monster("Dameargo",1, badConsequence12, prize12));
        //Pollipólipo volante     
        BadConsequence badConsequence13 = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3,0,0 );
        Prize prize13 = new Prize(1,1);
        monstruos.add(new Monster("Pollipólipo volante",3, badConsequence13, prize13));
        //YskhtihyssgGoth
        BadConsequence badConsequence14 = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true );
        Prize prize14 = new Prize(3,1);
        monstruos.add(new Monster("YskhtihyssgGothe",12, badConsequence14, prize14));
        //Familia feliz
        BadConsequence badConsequence15 = new BadConsequence("La familia te atrapa. Estás muerto.", true );
        Prize prize15 = new Prize(4,1);
        monstruos.add(new Monster("Familia feliz",1, badConsequence15, prize15));
        //Robbogoth
        BadConsequence badConsequence16 = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles.",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        Prize prize16 = new Prize(2,1);
        monstruos.add(new Monster("Robbogoth",8, badConsequence16, prize16));
        //El espía
        BadConsequence badConsequence17 = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.",0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        Prize prize17 = new Prize(1,1);
        monstruos.add(new Monster("El espía",5, badConsequence17, prize17));
        //El Lenguas
        BadConsequence badConsequence18 = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",2,5,0 );
        Prize prize18 = new Prize(1,1);
        monstruos.add(new Monster("El Lenguas",20, badConsequence18, prize18));
        //Bicéfalo
        BadConsequence badConsequence19 = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3,5,0 );
        Prize prize19 = new Prize(1,1);
        monstruos.add(new Monster("BIcéfalo",20, badConsequence19, prize19));
               
        //COMPROBACIONES
        
        System.out.print("Tienen un nivel superior a 10: \n");
        
        for (Monster iterador: monstruos){
            if(iterador.getCombatLevel() < 10){
                System.out.print(iterador.toString());
                System.out.print("\n");
            }
        }
        
        System.out.print("Tienen un mal rollo que implica sólo pérdida de niveles: \n");
        
        for(Monster iterador: monstruos){
            if(iterador.getBadConsequence().getLevels() > 0){
                    System.out.print(iterador.toString());
                System.out.print("\n");
            }
        }
        
        System.out.print("Su buen rollo indica una ganancia de niveles superior  a 1: \n");
        
        for(Monster iterador: monstruos){
            if(iterador.getPrize().getLevel() > 1){
                System.out.print(iterador.toString());
                System.out.print("\n");
            }
        }    
    
        System.out.print("Su mal rollo supone la pérdida de tesoros 'ARMOR', tanto visibles como ocultos: \n");
        
        for(Monster iterador: monstruos){
            ArrayList<TreasureKind> auxVisibles, auxOcultos;
            auxVisibles = iterador.getBadConsequence().getSpecificVisibleTreasures();
            auxOcultos = iterador.getBadConsequence().getSpecificHiddenTreasures();
            
                for(TreasureKind primero: auxVisibles){
                    if("ARMOR".equals(primero.toString())){
                    System.out.print(iterador.toString());
                    System.out.print("\n");
                    }
                }
                for(TreasureKind segundo: auxOcultos){
                    if("ARMOR".equals(segundo.toString())) 
                    System.out.print(iterador.toString());
                System.out.print("\n");
                    
                }
        }
    */
        //DIAGRAMA UML
        
        
    
    
    
    }
    
}