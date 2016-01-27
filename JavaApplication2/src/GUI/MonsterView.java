/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Monster;

/**
 *
 * @author mario-cabesa
 */
public class MonsterView extends javax.swing.JPanel {
    Monster monsterModel;
    /**
     * Creates new form MonsterView
     */
    public MonsterView() {
        initComponents();
    }

    public void setMonster(Monster monstruo){
        this.monsterModel = monstruo;
        //variables auxiliares para String
        int nivel = monsterModel.getCombatLevel();
        String nivelS = Integer.toString(nivel);
        //se actualiza la vista del tesoro
        this.name.setText(monsterModel.getName());
        this.combatLevel.setText(nivelS);
        this.malRollo.setText(tipo.toString());
        this.premio.setText();
        this.levelChangeAgainstCultistPlayer.setText();
        repaint();
        revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JTextField();
        combatLevel = new javax.swing.JTextField();
        malRollo = new javax.swing.JTextField();
        premio = new javax.swing.JTextField();
        levelChangeAgainstCultistPlayer = new javax.swing.JTextField();

        name.setText("name");

        combatLevel.setText("combatLevel");

        malRollo.setText("malRollo");

        premio.setText("premio");

        levelChangeAgainstCultistPlayer.setText("levelChangeAgainstCultistPlayer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combatLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(malRollo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(premio, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(levelChangeAgainstCultistPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combatLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(malRollo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(levelChangeAgainstCultistPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(premio))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField combatLevel;
    private javax.swing.JTextField levelChangeAgainstCultistPlayer;
    private javax.swing.JTextField malRollo;
    private javax.swing.JTextField name;
    private javax.swing.JTextField premio;
    // End of variables declaration//GEN-END:variables
}
