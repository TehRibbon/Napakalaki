/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author mario-cabesa
 */
public class CardDealer {
    //Atributos
    
    private static CardDealer instance = null;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Cultist> usedCultists;
    private ArrayList<Cultist> unusedCultists;
    
    //Constructor
    private CardDealer(){
    }
    
    //Patrón enumeration
    public static CardDealer getInstance(){
        if (instance == null){
            instance = new CardDealer();
        }
        return instance;
    }
    
    /*Inicializa el mazo de cartas de Tesoros (unusedTreasures) con todas las cartas de
      tesoros proporcionadas en el documento de cartas de tesoros.*/
    private void initTreasureCardDeck(){
        
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        
        unusedTreasures.add(new Treasure("Sí mi amo", 4, TreasureKind.HELMET) );
        unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOES) );
        unusedTreasures.add(new Treasure("Capucha de Cthulhu",3, TreasureKind.HELMET) );
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR) );
        unusedTreasures.add(new Treasure("Botas de lluvia ácida",1, TreasureKind.BOTHHANDS) );
        unusedTreasures.add(new Treasure("Casco minero",2,TreasureKind.HELMET) );
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS) );
        unusedTreasures.add(new Treasure("Camiseta de la UGR",1, TreasureKind.ARMOR) );
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND) );
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",2, TreasureKind.ONEHAND) );
        unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET) );
        unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND) );
        unusedTreasures.add(new Treasure("El aparato de Pr. Tesla", 4, TreasureKind.ARMOR) );
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS) );
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND) );
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS) );
        unusedTreasures.add(new Treasure("Garabato místico", 2, TreasureKind.ONEHAND) );
        unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR) );
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS) );
        unusedTreasures.add(new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND) );
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS) );
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS) );
        unusedTreasures.add(new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND) );
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET) );
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND) );
        unusedTreasures.add(new Treasure("Necro-playboycón", 3, TreasureKind.ONEHAND) );
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND) );
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS) );    
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND) );
        unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET) );
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES) );
        
    }
    /*Inicializa el mazo de cartas de monstruos (unusedMonsters), con todas las cartas
      de monstruos proporcionadas en el documento de cartas de monstruos. Se
      recomienda reutilizar el código desarrollado en la primera práctica para construir
      las cartas de monstruos. Usa el atributo de clase definido en la clase
      BadConsequence MAXTREASURES para los monstruos cuyo mal rollo sea
      pérdida de todos los tesoros visibles u ocultos.*/
    
    private void initMonsterCardDeck(){
        
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        
        BadConsequence constante = new NumericBadConsequence("",0,0,0);
        //Byakhees de bonanza
        BadConsequence badConsequence1 = new SpecificBadConsequence( "Pierdes tu armadura visible y otra oculta.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize1 = new Prize(2,1);
        unusedMonsters.add(new Monster("Byakhees de bonanza",8, badConsequence1, prize1));
        //Chibithulhu 
        BadConsequence badConsequence2 = new SpecificBadConsequence( "Embobados con el lindo primigenio te descartas de tu casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        Prize prize2 = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence2, prize2));
        //El sopor de Dunwich
        BadConsequence badConsequence3 = new SpecificBadConsequence( "El primordial bostezo contagioso. Pierdes el calzado visible.",0,new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList(Arrays.asList()));
        Prize prize3 = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich",2, badConsequence3, prize3));
        // Ángeles de la noche ibicenca
        BadConsequence badConsequence4 = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible  y 1 mano oculta.",0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize4 = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca",14, badConsequence4, prize4));
        //El gorrón del umbral
        BadConsequence badConsequence5 = new NumericBadConsequence("Pierdes todos tus tesoros visibles.",0,constante.getMAXTREASURES(), 0);
        Prize prize5 = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón del umbral",10, badConsequence5, prize5));
        //H.P. Munchcraft
        BadConsequence badConsequence6 = new SpecificBadConsequence("Pierdes la armadura visible.",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        Prize prize6 = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft",6, badConsequence6, prize6));
        //Bichgooth
        BadConsequence badConsequence7 = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        Prize prize7 = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth",2, badConsequence7, prize7));
        //El rey de la rosa
        BadConsequence badConsequence = new NumericBadConsequence( "Pierdes 5 niveles y 3 tesoros visibles." ,5, 3, 0);
        Prize prize8 = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa",13, badConsequence, prize8));
        //La que redacta en las tinieblas
        BadConsequence badConsequence9 = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles.", 2,0,0 );
        Prize prize9 = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas",2, badConsequence9, prize9));
        //Los hondos
        BadConsequence badConsequence10 = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.", true);
        Prize prize10 = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos",8, badConsequence10, prize10));
        //Semillas Cthulhu
        BadConsequence badConsequence11 = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2,0,2 );
        Prize prize11 = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu",4, badConsequence11, prize11));
        //Dameargo
        BadConsequence badConsequence12 = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList()));
        Prize prize12 = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo",1, badConsequence12, prize12));
        //Pollipólipo volante     
        BadConsequence badConsequence13 = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3,0,0 );
        Prize prize13 = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante",3, badConsequence13, prize13));
        //YskhtihyssgGoth
        BadConsequence badConsequence14 = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true );
        Prize prize14 = new Prize(3,1);
        unusedMonsters.add(new Monster("YskhtihyssgGothe",12, badConsequence14, prize14));
        //Familia feliz
        BadConsequence badConsequence15 = new DeathBadConsequence("La familia te atrapa. Estás muerto.", true );
        Prize prize15 = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz",1, badConsequence15, prize15));
        //Robbogoth
        BadConsequence badConsequence16 = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles.",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        Prize prize16 = new Prize(2,1);
        unusedMonsters.add(new Monster("Robbogoth",8, badConsequence16, prize16));
        //El espía
        BadConsequence badConsequence17 = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible.",0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        Prize prize17 = new Prize(1,1);
        unusedMonsters.add(new Monster("El espía",5, badConsequence17, prize17));
        //El Lenguas
        BadConsequence badConsequence18 = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",2,5,0 );
        Prize prize18 = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas",20, badConsequence18, prize18));
        //Bicéfalo
        BadConsequence badConsequence19 = new NumericBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3,constante.getMAXTREASURES(),0 );
        Prize prize19 = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo",20, badConsequence19, prize19));
        //El mal indecible impronunciable
        BadConsequence badConsequence20 = new NumericBadConsequence("Pierdes 1 mano visible",0,1,0);
        Prize prize20 = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable",10,badConsequence20,prize20,-2));
        //Testigos oculares
        BadConsequence badConsequence21 = new NumericBadConsequence("Pierdes tust tesoros visibles. Ja ja ja.",0,constante.getMAXTREASURES(),0);
        Prize prize21 = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos oculares",6,badConsequence20,prize20,2));
        //El gran cthulhu
        BadConsequence badConsequence22 = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres.",true);
        Prize prize22 = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran Cthulhu",20,badConsequence22,prize22,4));
        //Serpiente Político
        BadConsequence badConsequence23 = new NumericBadConsequence("Tu gobierno te recorta dos niveles.",2,0,0);
        Prize prize23 = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Político",8,badConsequence23,prize23,-2));
        //Felpuggoth
        BadConsequence badConsequence24 = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.",0,new ArrayList(Arrays.asList(TreasureKind.HELMET,TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,TreasureKind.ONEHAND)));
        Prize prize24 = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth",2,badConsequence24,prize24,5));
        //Shoggoth
        BadConsequence badConsequence25 = new NumericBadConsequence("Pierdes 2 niveles.",2,0,0);
        Prize prize25 = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth",16,badConsequence25,prize25,-4));
        //Lolitagooth
        BadConsequence badConsequence26 = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles.",2,0,0);
        Prize prize26 = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth",2,badConsequence26,prize26,3));
    
    }

    private void initCultistCardDeck(){
        unusedCultists = new ArrayList();
        usedCultists = new ArrayList();
        
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",1));
    }
   
    /*Baraja el mazo de cartas de tesoros unusedTreasures.*/
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    /*Baraja el mazo de cartas de monstruos unusedMonsters.*/
    private void shuffleMonster(){
        Collections.shuffle(unusedMonsters);
    }
    
     /*Baraja el mazo de cartas de Cultist*/
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
        
    /*Devuelve el siguiente tesoro que hay en el mazo de tesoros (unusedTreasures) y lo elimina
    de él. Si al iniciar el método el mazo unusedTreasures estuviese vacío, pasa el mazo de
    descartes (usedTreasures) al mazo de tesoros (unusedTreasures) y barájalo, dejando el
    mazo de descartes vacío.*/
    public Treasure nextTreasure(){

        
        //recorro mazo de descartes e inicializo unusedTreasures
        if(unusedTreasures.isEmpty()){
            for(Treasure t : this.usedTreasures){
                this.unusedTreasures.add(t);
            }
        //barajo el mazo
            this.shuffleTreasures();
        //Elimino el mazo de descartes
            this.usedTreasures.clear();
        }
        Treasure siguiente_tesoro = this.unusedTreasures.get(0);
        
        this.unusedTreasures.remove(siguiente_tesoro);
        this.usedTreasures.add(siguiente_tesoro);
        
        //obtengo primera carta del mazo
      return siguiente_tesoro;
    }
    
    /*Igual que la anterior pero con el mazo de monstruos.*/
    public Monster nextMonster(){
         
        
        //recorro mazo de descartes e inicializo unusedTreasures
        if(unusedMonsters.isEmpty()){
            for(Monster it : this.usedMonsters){
                this.unusedMonsters.add(it);
            }
        //barajo el mazo
            this.shuffleTreasures();
        //Elimino el mazo de descartes
            this.usedMonsters.clear();
        }
        
    
        Monster primer_monstruo = this.unusedMonsters.get(0);
        this.unusedMonsters.remove(primer_monstruo);
        this.usedMonsters.add(primer_monstruo);
        //obtengo primera carta del mazo
        return primer_monstruo;
        
        
    }
    
    /*Introduce en el mazo de descartes de tesoros (usedTreasures) el tesoro t.*/
    public void giveTreasureBack(Treasure t){
        this.usedTreasures.add(t);
    }
    
    /*Introduce en el mazo de descartes de monstruos (usedMonsters) al monstruo m.*/
    
    public void giveMonsterBack(Monster m){
        this.usedMonsters.add(m);
    }
    
    public Cultist nextCultist(){
      //recorro mazo de descartes e inicializo unusedCultist
        if(unusedCultists.isEmpty()){
            for(Cultist t : this.usedCultists){
                this.unusedCultists.add(t);
            }
        //barajo el mazo
            this.shuffleCultists();
        //Elimino el mazo de descartes
            this.usedCultists.clear();
        }
        Cultist siguiente_tesoro = this.unusedCultists.get(0);
        
        this.unusedCultists.remove(siguiente_tesoro);
        this.usedCultists.add(siguiente_tesoro);
        
        //obtengo primera carta del mazo
      return siguiente_tesoro;
    }
  
    
    public void initCards(){
        this.initTreasureCardDeck();
        this.shuffleTreasures();
        
        this.initMonsterCardDeck();
        this.shuffleMonster();
        
        this.shuffleCultists();
        this.shuffleCultists();        
        
        
    }   
}
