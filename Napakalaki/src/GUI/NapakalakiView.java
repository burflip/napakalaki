/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.CombatResult;
import NapakalakiGame.Monster;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;

/**
 *
 * @author valentin
 */
public class NapakalakiView extends javax.swing.JFrame {

    private Napakalaki napakalakiModel;
    private Player currentPlayer;
    private Monster currentMonster;
    
    public void setNapakalaki(Napakalaki n) {
        this.napakalakiModel = n;
        
        currentPlayer = napakalakiModel.getCurrentPlayer();
        playerView.setPlayer(currentPlayer);
        
        currentMonster = napakalakiModel.getCurrentMonster();
        monsterView.setMonster(currentMonster);
        
        playerView.setNapakalakiModel(napakalakiModel);
        
        nextTurnBtn.setEnabled(false);
        fightBtn.setEnabled(false);
        
        playerView.ChangeStealButton(false);
        
        repaint();
    }
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        this.setTitle("Napakalaki");
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerView = new GUI.PlayerView();
        fightBtn = new javax.swing.JButton();
        showBtn = new javax.swing.JButton();
        nextTurnBtn = new javax.swing.JButton();
        monsterView = new GUI.MonsterView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fightBtn.setText("Luchar");
        fightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fightBtnActionPerformed(evt);
            }
        });

        showBtn.setText("Mostrar");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });

        nextTurnBtn.setText("Siguiente turno");
        nextTurnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(playerView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextTurnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showBtn)
                            .addComponent(fightBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextTurnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fightBtnActionPerformed
        CombatResult combatResult = napakalakiModel.developCombat();
        
        MessageDialog msg = new MessageDialog(this, true);
        
        if (null != combatResult)
            switch (combatResult) {
            case WIN:
                msg.setMessageDialog("¡Has ganado el combate!", "Ganaste");
                break;
            case LOSE:
                msg.setMessageDialog("Has perdido el combate.\nSe te aplicará la BC.", "Combate perdido");
                break;
            case LOSEANDCONVERT:
                msg.setMessageDialog("¡Te has convertido en un Cultist!", "Conversión");
                break;
            case WINGAME:
                msg.setMessageDialog("¡Felicidades! ¡Has GANADO!", "Victoria");
                msg.setVisible(true);
                
                System.exit(0);
            default:
                break;
        }
        
        msg.setVisible(true);
        playerView.setPlayer(napakalakiModel.getCurrentPlayer());
        playerView.ChangeStealButton(true);
        nextTurnBtn.setEnabled(true);
        fightBtn.setEnabled(false);
    }//GEN-LAST:event_fightBtnActionPerformed

    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtnActionPerformed
        monsterView.ShowMonster();
        fightBtn.setEnabled(true);
        showBtn.setEnabled(false);
        playerView.ChangeMakeVisibleButton(false);
    }//GEN-LAST:event_showBtnActionPerformed

    private void nextTurnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnBtnActionPerformed
        if (!napakalakiModel.nextTurn())
        {
            MessageDialog msg = new MessageDialog(this, false);
            msg.setMessageDialog("Ahora mismo no puedes pasar turno. "
            + "No puedes tener más de 4 tesoros ni tener una BadConsequnece pendiente",
            "Error");
            msg.setVisible(true);
        }
        else
        {
            playerView.setPlayer(napakalakiModel.getCurrentPlayer());
            monsterView.setMonster(napakalakiModel.getCurrentMonster());
            showBtn.setEnabled(true);
            nextTurnBtn.setEnabled(false);
            playerView.ChangeStealButton(false);
        }
    }//GEN-LAST:event_nextTurnBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fightBtn;
    private GUI.MonsterView monsterView;
    private javax.swing.JButton nextTurnBtn;
    private GUI.PlayerView playerView;
    private javax.swing.JButton showBtn;
    // End of variables declaration//GEN-END:variables
}
