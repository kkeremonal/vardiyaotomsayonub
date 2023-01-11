/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UiDesing;

import DataBase.db;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huseyinkaradana
 */
public class KullaniciAnaSayfa extends javax.swing.JFrame {

    String tcNo="";
    public KullaniciAnaSayfa() {
        initComponents();
        isimKarsilama();
        tableDoldur("SELECT * FROM nobettime", tb_gorev);
    }
    
    
    public KullaniciAnaSayfa(String tc) {
        tcNo=tc;
        
        initComponents();
        isimKarsilama();
        tableDoldur("SELECT * FROM nobettime WHERE PERSONELTC='"+tcNo+"'", tb_gorev);
    }
    Connection conn=null;
    ResultSet rs;
    public void isimKarsilama(){
        
        
        String isim="";
        try {
            conn=db.java_db();
            rs=conn.prepareStatement("SELECT *FROM personeller").executeQuery();
            while(rs.next()){
                if(tcNo.equals(String.valueOf(rs.getString("tcNo")))){
                    isim=String.valueOf(rs.getString("adi"));
                    isim+=" Nöbet Takvimi";
                    txt_baslik.setText(isim);
                    break;
                }
                
            }
            
        } catch (Exception e) {
        }finally{
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
                
    }
    
    public void tableDoldur(String sql,javax.swing.JTable tb){
        tableBosalt(tb);
        DefaultTableModel model=(DefaultTableModel) tb.getModel();
        try {
            try {
            tb.removeAll();
            conn=db.java_db();
            
            rs=conn.prepareStatement(sql).executeQuery();
            
            while(rs.next()){
                
                String tarih=String.valueOf(rs.getString("NobetTarihi"));
                String saat=String.valueOf(rs.getString("NobetSaati"));
                
                Object [] eklenecek={tarih,saat};
                model.addRow(eklenecek);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        finally{
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
            
        } catch (Exception e) {
        }
    }
    public void tableBosalt(javax.swing.JTable tb){
        DefaultTableModel dm = (DefaultTableModel) tb.getModel();
        int rowCount = dm.getRowCount();
        
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_gorev = new javax.swing.JTable();
        txt_baslik = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kullanıcı Paneli");

        tb_gorev.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        tb_gorev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"26.12.2022 Pazartesi", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", null},
                {"26.12.2022 Pazartesi	", "8.00-16.00"},
                {"26.12.2022 Pazartesi	", null},
                {"26.12.2022 Pazartesi	", null},
                {"26.12.2022 Pazartesi	", null},
                {"26.12.2022 Pazartesi	", null},
                {"26.12.2022 Pazartesi	", null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nöbet Günleri", "Nöbet Saatleri"
            }
        ));
        tb_gorev.setAlignmentX(1.0F);
        tb_gorev.setAlignmentY(1.0F);
        tb_gorev.setEnabled(false);
        tb_gorev.setRowHeight(26);
        jScrollPane1.setViewportView(tb_gorev);
        if (tb_gorev.getColumnModel().getColumnCount() > 0) {
            tb_gorev.getColumnModel().getColumn(0).setMinWidth(300);
            tb_gorev.getColumnModel().getColumn(0).setMaxWidth(500);
            tb_gorev.getColumnModel().getColumn(1).setMinWidth(300);
            tb_gorev.getColumnModel().getColumn(1).setMaxWidth(500);
        }

        txt_baslik.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txt_baslik.setText("Nöbet Takvimi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txt_baslik, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_baslik, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(KullaniciAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KullaniciAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KullaniciAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KullaniciAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullaniciAnaSayfa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_gorev;
    private javax.swing.JLabel txt_baslik;
    // End of variables declaration//GEN-END:variables
}
