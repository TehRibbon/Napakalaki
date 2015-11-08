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
public class CardDealer {
    //Atributos
    
    private static CardDealer instance = null;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Monster> unusedMonsters;
    
    //Constructor
    private CardDealer(){}
    
    //Patrón enumeration
    public static CardDealer getInstance(){
        if (instance == null){
            instance = new CardDealer();
        }
        return instance;
    }
    
    private void initTreasureCardDeck(){}
    
    private void initMonsterCardDeck(){}
    
    private void shuffleTreasures(){}
    
    private void shuffleMonster(){}
    
    public Treasure nextTreasure(){}
    
    public Monster nextMonster(){}
    
    public void giveTreasureBack(Treasure t){}
    
    public void giveMonsterBack(Monster m){}
    
    public void initCards(){}
}
