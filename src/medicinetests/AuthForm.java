package medicinetests;

import javax.swing.JOptionPane;

public class AuthForm extends javax.swing.JFrame {

    public static String fullName;
    public static int group;

    public AuthForm() {
        initComponents();

        label_info.setText("Введіть інформацію про себе.");
        label_fullname.setText("Прізвище та ім'я");
        label_group.setText("Група");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_info = new javax.swing.JLabel();
        label_fullname = new javax.swing.JLabel();
        label_group = new javax.swing.JLabel();
        tBox_group = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        tBox_fullname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        label_info.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_info.setText("jLabel1");

        label_fullname.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        label_fullname.setText("jLabel1");

        label_group.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        label_group.setText("jLabel2");

        tBox_group.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btn_save.setBackground(new java.awt.Color(0, 0, 0));
        btn_save.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Зберегти");
        btn_save.setActionCommand("Назад");
        btn_save.setPreferredSize(new java.awt.Dimension(81, 23));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        tBox_fullname.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_info)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_fullname)
                                .addComponent(label_group))
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tBox_fullname, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(tBox_group)))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(label_info)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_fullname)
                            .addComponent(tBox_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(label_group))
                    .addComponent(tBox_group, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (tBox_fullname.getText().trim().length() > 0 && tBox_group.getText().trim().length() > 0) {
            fullName = tBox_fullname.getText();

            try {
                group = Integer.parseInt(tBox_group.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Поле \"Група\" має бути цифрою.");
                return;
            }

            this.setVisible(false);
            new Design().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Поля не повинні бути порожніми.");
        }
    }//GEN-LAST:event_btn_saveActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AuthForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel label_fullname;
    private javax.swing.JLabel label_group;
    private javax.swing.JLabel label_info;
    private javax.swing.JTextField tBox_fullname;
    private javax.swing.JTextField tBox_group;
    // End of variables declaration//GEN-END:variables
}
