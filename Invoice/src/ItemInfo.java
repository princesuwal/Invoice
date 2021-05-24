/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author princ
 */
public class ItemInfo extends javax.swing.JFrame {

    /**
     * Creates new form ItemInfo
     */
    public ItemInfo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ItemInfoPanel = new javax.swing.JPanel();
        BacktoMainBtn = new javax.swing.JButton();
        CurrentInvoice = new javax.swing.JLabel();
        DateField = new javax.swing.JTextField();
        ItemInfoTitle = new javax.swing.JLabel();
        QtyLabel = new javax.swing.JLabel();
        ItemLabel = new javax.swing.JLabel();
        ModelLabel = new javax.swing.JLabel();
        ProblemLabel = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        EnterBtn = new javax.swing.JButton();
        ItemField = new javax.swing.JTextField();
        ModelField = new javax.swing.JTextField();
        QtyField = new javax.swing.JTextField();
        ProblemField = new javax.swing.JTextField();
        PriceField = new javax.swing.JTextField();
        DescriptionScrollPane = new javax.swing.JScrollPane();
        DescriptionField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 750));

        BacktoMainBtn.setFont(new java.awt.Font("Sylfaen", 0, 25)); // NOI18N
        BacktoMainBtn.setText("< Main Menu");
        BacktoMainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BacktoMainBtnActionPerformed(evt);
            }
        });

        CurrentInvoice.setFont(new java.awt.Font("Sylfaen", 0, 25)); // NOI18N
        CurrentInvoice.setText("Current Invoice No.");

        DateField.setFont(new java.awt.Font("Sylfaen", 0, 25)); // NOI18N
        DateField.setText("Date()");
        DateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateFieldActionPerformed(evt);
            }
        });

        ItemInfoTitle.setFont(new java.awt.Font("Sylfaen", 0, 45)); // NOI18N
        ItemInfoTitle.setText("Enter Item Description");

        QtyLabel.setFont(new java.awt.Font("Sylfaen", 0, 45)); // NOI18N
        QtyLabel.setText("Qty :");

        ItemLabel.setFont(new java.awt.Font("Sylfaen", 0, 45)); // NOI18N
        ItemLabel.setText("Item :");

        ModelLabel.setFont(new java.awt.Font("Sylfaen", 0, 45)); // NOI18N
        ModelLabel.setText("Model No. :");

        ProblemLabel.setFont(new java.awt.Font("Sylfaen", 0, 45)); // NOI18N
        ProblemLabel.setText("Problem :");

        DescriptionLabel.setFont(new java.awt.Font("Sylfaen", 0, 45)); // NOI18N
        DescriptionLabel.setText("Description :");

        PriceLabel.setFont(new java.awt.Font("Sylfaen", 0, 45)); // NOI18N
        PriceLabel.setText("Price :");

        EnterBtn.setFont(new java.awt.Font("Sylfaen", 0, 25)); // NOI18N
        EnterBtn.setText("Enter");
        EnterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterBtnActionPerformed(evt);
            }
        });

        ItemField.setFont(new java.awt.Font("Sylfaen", 0, 40)); // NOI18N

        ModelField.setFont(new java.awt.Font("Sylfaen", 0, 40)); // NOI18N
        ModelField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModelFieldActionPerformed(evt);
            }
        });

        QtyField.setFont(new java.awt.Font("Sylfaen", 0, 40)); // NOI18N
        QtyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QtyFieldActionPerformed(evt);
            }
        });

        ProblemField.setFont(new java.awt.Font("Sylfaen", 0, 40)); // NOI18N
        ProblemField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemFieldActionPerformed(evt);
            }
        });

        PriceField.setFont(new java.awt.Font("Sylfaen", 0, 40)); // NOI18N
        PriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceFieldActionPerformed(evt);
            }
        });

        DescriptionField.setColumns(20);
        DescriptionField.setFont(new java.awt.Font("Sylfaen", 0, 25)); // NOI18N
        DescriptionField.setRows(5);
        DescriptionScrollPane.setViewportView(DescriptionField);

        javax.swing.GroupLayout ItemInfoPanelLayout = new javax.swing.GroupLayout(ItemInfoPanel);
        ItemInfoPanel.setLayout(ItemInfoPanelLayout);
        ItemInfoPanelLayout.setHorizontalGroup(
            ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemInfoPanelLayout.createSequentialGroup()
                .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemInfoPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ItemInfoTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CurrentInvoice))
                    .addGroup(ItemInfoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ItemInfoPanelLayout.createSequentialGroup()
                                .addComponent(BacktoMainBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemInfoPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(EnterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemInfoPanelLayout.createSequentialGroup()
                                .addComponent(ItemLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ItemField, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemInfoPanelLayout.createSequentialGroup()
                                .addComponent(QtyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(QtyField, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ItemInfoPanelLayout.createSequentialGroup()
                                .addComponent(ModelLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(ModelField, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemInfoPanelLayout.createSequentialGroup()
                                .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ProblemLabel)
                                    .addComponent(DescriptionLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ProblemField, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                                    .addComponent(DescriptionScrollPane)))))
                    .addGroup(ItemInfoPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(PriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ItemInfoPanelLayout.setVerticalGroup(
            ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BacktoMainBtn)
                    .addComponent(DateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ItemInfoPanelLayout.createSequentialGroup()
                        .addComponent(ItemInfoTitle)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemInfoPanelLayout.createSequentialGroup()
                        .addComponent(CurrentInvoice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QtyLabel)
                    .addComponent(QtyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemLabel)
                    .addComponent(ItemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModelLabel)
                    .addComponent(ModelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProblemLabel)
                    .addComponent(ProblemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ItemInfoPanelLayout.createSequentialGroup()
                        .addComponent(DescriptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ItemInfoPanelLayout.createSequentialGroup()
                        .addComponent(DescriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ItemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PriceLabel)
                            .addComponent(PriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)))
                .addComponent(EnterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ItemInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ItemInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateFieldActionPerformed

    private void BacktoMainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BacktoMainBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BacktoMainBtnActionPerformed

    private void EnterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnterBtnActionPerformed

    private void ModelFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModelFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModelFieldActionPerformed

    private void QtyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QtyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QtyFieldActionPerformed

    private void ProblemFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProblemFieldActionPerformed

    private void PriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BacktoMainBtn;
    private javax.swing.JLabel CurrentInvoice;
    private javax.swing.JTextField DateField;
    private javax.swing.JTextArea DescriptionField;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JScrollPane DescriptionScrollPane;
    private javax.swing.JButton EnterBtn;
    private javax.swing.JTextField ItemField;
    private javax.swing.JPanel ItemInfoPanel;
    private javax.swing.JLabel ItemInfoTitle;
    private javax.swing.JLabel ItemLabel;
    private javax.swing.JTextField ModelField;
    private javax.swing.JLabel ModelLabel;
    private javax.swing.JTextField PriceField;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JTextField ProblemField;
    private javax.swing.JLabel ProblemLabel;
    private javax.swing.JTextField QtyField;
    private javax.swing.JLabel QtyLabel;
    // End of variables declaration//GEN-END:variables
}