/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UiDesing;

import DataBase.db;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huseyinkaradana
 */
public class VardiyaEkle extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs, rs1;
    Statement statement;

    public VardiyaEkle() {
        initComponents();
        bilgimetni();
        personelDoldur();
    }

    String[] kampusGirisi = {"00.00 – 08.00", "08.00 – 16.00", "16.00 – 24.00"};
    String[] kampusIci = {"08.00 – 16.00", "09.00 – 17.00"};

    void bilgimetni() {
        if (txt_tarih.getText().isEmpty() == true) {
            txt_tarih.setText("12.10.2022 şeklinde giriniz (gün.ay.yıl)");
            txt_tarih.setCaretPosition(0);
            txt_tarih.setForeground(new java.awt.Color(204, 204, 204));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cb_personel = new javax.swing.JComboBox<>();
        cb_vardiyaSistemi = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cb_vardiyaSaati = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_tarih = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbl_kisiler = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vardiya Ekle");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Personel Seçiniz :");

        cb_personel.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        cb_personel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bir Personel Seçiniz" }));
        cb_personel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_personelActionPerformed(evt);
            }
        });

        cb_vardiyaSistemi.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        cb_vardiyaSistemi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bir Vardiya Sistemi Seçiniz", "Kampüs İçi", "Kampüs Dışı" }));
        cb_vardiyaSistemi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_vardiyaSistemiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Vardiya Sistemi Seçiniz :");

        cb_vardiyaSaati.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        cb_vardiyaSaati.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bir Vardiya Saati Seçiniz" }));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Vardiya Saati Seçiniz :");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setText("Vardiya Günü Giriniz :");

        txt_tarih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tarihActionPerformed(evt);
            }
        });
        txt_tarih.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tarihKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton1.setText("Anasayfaya Dön");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton2.setText("Vardiya Kaydet");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Vardiya Oluşturucu");

        lbl_kisiler.setEditable(false);
        lbl_kisiler.setColumns(20);
        lbl_kisiler.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        lbl_kisiler.setRows(5);
        jScrollPane1.setViewportView(lbl_kisiler);

        jButton3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton3.setText("Personel Sil");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(24, 24, 24)
                                        .addComponent(txt_tarih))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cb_personel, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cb_vardiyaSistemi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(23, 23, 23)
                                                .addComponent(cb_vardiyaSaati, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(jButton2)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cb_personel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cb_vardiyaSistemi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cb_vardiyaSaati)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tarih, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tarihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tarihActionPerformed

    }//GEN-LAST:event_txt_tarihActionPerformed
    String tcNo;
    Hashtable<String, String> personelTcno = new Hashtable<>();

    void personelDoldur() {
        try {
            conn = db.java_db();
            String sql = "SELECT * FROM personelvardiya.personeller";
            rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                String isim = String.valueOf(rs.getString("adi"));
                String soyad = String.valueOf(rs.getString("soyadi"));
                String isimSoyisim = isim + " " + soyad;
                personelTcno.put(isimSoyisim, String.valueOf(rs.getString("tcNo")));
                cb_personel.addItem(isimSoyisim);
            }
        } catch (Exception e) {
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

    }

    private void txt_tarihKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tarihKeyPressed
        if (txt_tarih.getForeground() != Color.BLACK) {
            if (txt_tarih.getText().equals("12.10.2022 şeklinde giriniz (gün.ay.yıl)")) {
                txt_tarih.setText("");
            }
        }
        txt_tarih.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_tarihKeyPressed
    String vardiyasistemi = "";
    private void cb_vardiyaSistemiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_vardiyaSistemiActionPerformed
        vardiyasistemi = String.valueOf(cb_vardiyaSistemi.getItemAt(cb_vardiyaSistemi.getSelectedIndex()));

        if (vardiyasistemi.equals("Kampüs İçi")) {
            cb_vardiyaSaati.removeAllItems();
            cb_vardiyaSaati.addItem("Bir Vardiya Saati Seçiniz");
            cb_vardiyaSaati.addItem(kampusIci[0]);
            cb_vardiyaSaati.addItem(kampusIci[1]);

        } else if (vardiyasistemi.equals("Kampüs Dışı")) {
            cb_vardiyaSaati.removeAllItems();
            cb_vardiyaSaati.addItem("Bir Vardiya Saati Seçiniz");
            cb_vardiyaSaati.addItem(kampusGirisi[0]);
            cb_vardiyaSaati.addItem(kampusGirisi[1]);
            cb_vardiyaSaati.addItem(kampusGirisi[2]);

        } else {
            JOptionPane.showMessageDialog(null, "Lütfen Bir Vardiya Sistemi Seçiniz...");
        }
    }//GEN-LAST:event_cb_vardiyaSistemiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        YoneticiAnaSayfa frame = new YoneticiAnaSayfa();
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    void vardiyaEkle(String data) {
        try {
            String saat = String.valueOf(cb_vardiyaSaati.getItemAt(cb_vardiyaSaati.getSelectedIndex()));
            conn = db.java_db();
            String tarih = String.valueOf(txt_tarih.getText());
            String kisi = String.valueOf(cb_personel.getItemAt(cb_personel.getSelectedIndex()));

            tcNo = personelTcno.get(data);
            String sql = "INSERT INTO `personelvardiya`.`nobettime` (`PERSONELTC`, `NobetTarihi`, `NobetSaati`, `VardiyaSistemi`) VALUES ('" + tcNo + "', '" + tarih + "', '" + saat + "', '" + vardiyasistemi + "');";
            statement = conn.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vardiyayı Kaydederken Beklenmeyen Bir Hata Oluştu...");
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean eklemeyapildiMi = false;
        for (String i : secilenKisiler) {
            try {
                boolean eklemeli_mi = false;
                String tarih = String.valueOf(txt_tarih.getText());

                tcNo = personelTcno.get(i);
                conn = db.java_db();
                String sql = "SELECT * FROM nobettime";
                rs = conn.prepareStatement(sql).executeQuery();
                while (rs.next()) {
                    if (tarih.equals(String.valueOf(rs.getString("NobetTarihi"))) && tcNo.equals(String.valueOf(rs.getString("PERSONELTC")))) {
                        eklemeli_mi = false;
                        break;
                    } else {
                        eklemeli_mi = true;
                    }
                }
                if (eklemeli_mi == true) {
                    vardiyaEkle(i);
                    eklemeyapildiMi = true;
                } else {
                    JOptionPane.showMessageDialog(null, i + " personeline ait vardiya bulunuyor.Lütfen vardiyayı düzenleyiniz");
                }
            } catch (Exception e) {
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }

        }
        if (eklemeyapildiMi == true) {
            JOptionPane.showMessageDialog(null, "Vardiyalar Başarıyla Kaydedilmiştir...");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    ArrayList<String> secilenKisiler = new ArrayList<>();

    private void cb_personelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_personelActionPerformed
        //personeller buradan seçilip listeye atılacak sonra veri tabanına ekleme yaoparken listeden silinecek
        String secilenKisi = String.valueOf(cb_personel.getItemAt(cb_personel.getSelectedIndex()));
        String secilen = "";
        if (secilenKisi.equals("Bir Personel Seçiniz")) {
            JOptionPane.showMessageDialog(null, "Lütfen Eklemek İçin Birini Seçin");
        } else {
            if (secilenKisiler.contains(secilenKisi)) {
                JOptionPane.showMessageDialog(null, "Bu kişiyi daha önce eklediniz");

            } else {
                String id = personelTcno.get(secilenKisi);
                secilenKisiler.add(secilenKisi);
                for (String i : secilenKisiler) {
                    secilen += i + "\n";

                }

                lbl_kisiler.setText(secilen);

            }
        }
    }//GEN-LAST:event_cb_personelActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String secilen = "";
        if (secilenKisiler.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Silinecek Kişi Yok ");
        } else {
            secilenKisiler.remove(secilenKisiler.size() - 1);

            for (String i : secilenKisiler) {
                secilen += i + "\n";

            }

            lbl_kisiler.setText(secilen);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(VardiyaEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VardiyaEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VardiyaEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VardiyaEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VardiyaEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_personel;
    private javax.swing.JComboBox<String> cb_vardiyaSaati;
    private javax.swing.JComboBox<String> cb_vardiyaSistemi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lbl_kisiler;
    private javax.swing.JTextField txt_tarih;
    // End of variables declaration//GEN-END:variables
}
