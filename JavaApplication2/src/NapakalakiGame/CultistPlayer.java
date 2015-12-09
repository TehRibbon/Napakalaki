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
public class CultistPlayer extends Player{
    
    private Cultist myCultistCard;
    private static int totalCultistPlayers = 0;
   
    CultistPlayer(Player p, Cultist c){
        super(p);
        totalCultistPlayers++;
        this.myCultistCard = c;        
        
    }
    @Override
    protected int getCombatLevel(){
        double resultado = 0;
        double nivel = 0;
        double porcentaje = 0;
        nivel = super.getCombatLevel();
        porcentaje = nivel* 0.2;
        resultado = nivel + porcentaje + (myCultistCard.getGainedLevels() * totalCultistPlayers);
        int solucion = (int)resultado;
        
        return solucion; 
    }
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    @Override
    protected Treasure giveMeATreasure(){
        Treasure solucion;
        int posAleatoria = (int) (Math.random()*getVisibleTreasures().size());
        solucion = getVisibleTreasures().get(posAleatoria);
            
        return solucion;
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        boolean solucion = false;
        
        if(getVisibleTreasures().size() > 0){
            solucion = true;
        }
       return solucion;
    }
    public int getTotalCultistPlayers(){
        return this.totalCultistPlayers;
    }
    
    }
    

