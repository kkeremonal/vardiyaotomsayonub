
package UiDesing;

import DataBase.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class PersonelEkleme extends javax.swing.JFrame {

    PreparedStatement pst;
    Connection conn = null;
    ResultSet rs;
    Statement statement;
    String GelentcNo,GelenAd,GelenSoyad,GelenTel,GelenMail,GelenAdres,GelenSicil,GelenKadroGorev,GelenSifre,GelenStatu,GelenIzın;
    String guncelle;
    
    public PersonelEkleme() {
        initComponents();
        guncelle = "0";
        
    }
    
    public PersonelEkleme(String ad,String soyad,String tc,String tel,String mail,String adres,String sicilNo,String kadroGorev,String sifre,String statu,String izin, String update) {
        
        initComponents();
        GelentcNo=tc;
        txt_ad.setText(ad);
        txt_soyisim.setText(soyad);
        txt_tc.setText(tc);
        txt_telno.setText(tel);
        txt_mail.setText(mail);
        txt_adress.setText(adres);
        txt_sicilno.setText(sicilNo);
        txt_kadrogorev.setText(kadroGorev);
        txt_sifre.setText(sifre);
        lbl_izin.setText(izin);
        guncelle = "1";
        
        
    }

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_ad = new javax.swing.JTextField();
        txt_soyisim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_tc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_telno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_adress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_sicilno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_kadrogorev = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb_kadro = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_sifre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_izin = new javax.swing.JLabel();
        cb_gun = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personel Ekleme Sayfası");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jLabel1.setText("Personel Adı:");

        txt_ad.setFont(new java.awt.Font("sansserif", 2, 14)); 

        txt_soyisim.setFont(new java.awt.Font("sansserif", 2, 14));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jLabel2.setText("Personel Soyadı:");

        txt_tc.setFont(new java.awt.Font("sansserif", 2, 14)); 

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14));
        jLabel3.setText("T.C. Numarası:");

        txt_telno.setFont(new java.awt.Font("sansserif", 2, 14));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jLabel4.setText("Telefon Numarası:");

        txt_mail.setFont(new java.awt.Font("sansserif", 2, 14)); 

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jLabel5.setText("Mail:");

        txt_adress.setFont(new java.awt.Font("sansserif", 2, 14)); 

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jLabel6.setText("Adres:");

        txt_sicilno.setFont(new java.awt.Font("sansserif", 2, 14)); 

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jLabel7.setText("Sicil Numarası:");

        txt_kadrogorev.setFont(new java.awt.Font("sansserif", 2, 14)); 

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jLabel8.setText("Kadro:");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jLabel9.setText("Kadro Görev:");

        cb_kadro.setFont(new java.awt.Font("sansserif", 2, 14)); 
        cb_kadro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lütfen Bir Kadro Seçiniz", "Memur", "İşçi" }));
        cb_kadro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kadroActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("sansserif", 1, 18)); 
        jButton1.setText("Personeli Kaydet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 1, 18));
        jButton2.setText("Anasayfaya Dön");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt_sifre.setFont(new java.awt.Font("sansserif", 2, 14)); 

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jLabel10.setText("Sistem Şifresi:");

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jLabel11.setText("İzin Günleri:");

        lbl_izin.setFont(new java.awt.Font("sansserif", 2, 14)); 

        cb_gun.setFont(new java.awt.Font("sansserif", 2, 14)); 
        cb_gun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lütfen İzin Günü Seçiniz", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar" }));
        cb_gun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_gunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_kadro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_soyisim, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_telno, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_adress, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_sicilno, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_kadrogorev, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_sifre, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(114, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_izin, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cb_gun, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ad, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_soyisim)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tc)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_telno)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_adress)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sicilno, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kadrogorev, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_sifre)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_kadro, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_mail)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_gun, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_izin, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        YoneticiAnaSayfa frame = new YoneticiAnaSayfa();
        frame.setVisible(true);
        this.setVisible(false);
    }
String calismaSaati;
    int izingunSayac=0;
    private void cb_kadroActionPerformed(java.awt.event.ActionEvent evt) {
        if (cb_kadro.getItemAt(cb_kadro.getSelectedIndex()).equals("Memur")) {
            izingunSayac=2;
            calismaSaati="40";
        } else {
            izingunSayac=1;
            calismaSaati="45";
        }
    }
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (guncelle.equals("0")) {
            String isim = String.valueOf(txt_ad.getText());
            String soyisim = String.valueOf(txt_soyisim.getText());
            String tcNo = String.valueOf(txt_tc.getText());
            String telNo = String.valueOf(txt_telno.getText());
            String mail = String.valueOf(txt_mail.getText());
            String adres = String.valueOf(txt_adress.getText());
            String sicilNo = String.valueOf(txt_sicilno.getText());
            String kadrogörev = String.valueOf(txt_kadrogorev.getText());
            String sozlesme = String.valueOf(cb_kadro.getItemAt(cb_kadro.getSelectedIndex()));
            String sifre = String.valueOf(txt_sifre.getText());
            String izinGunu = String.valueOf(lbl_izin.getText());
            
            try {
                if (isim.trim().equals("") || soyisim.trim().equals("") || tcNo.trim().equals("") || telNo.trim().equals("") || mail.trim().equals("") || adres.trim().equals("") || sicilNo.trim().equals("") || kadrogörev.trim().equals("") || sozlesme.trim().equals("") || sifre.trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Hiçbir yer boş bırakılamaz...");
                } else {
                    conn = db.java_db();
                    String sql = "INSERT INTO `personelvardiya`.`personeller` (`adi`, `soyadi`, `tcNo`, `telNo`, `mail`, `adres`, `sicilNo`, `kadroGorev`, `sifre`, `statu`, `IZINGUNU`,`CalismaSaati`) VALUES ('" + isim + "', '" + soyisim + "', '" + tcNo + "', '" + telNo + "', '" + mail + "', '" + adres + "', '" + sicilNo + "', '" + kadrogörev + "', '" + sifre + "', '" + sozlesme + "', '" + izinGunu + "','"+calismaSaati+"');";
                    
                    statement = conn.createStatement();
                    statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, isim + " Başarıyla Sisteme Kaydedilmiştir...");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, " Beklenemyen Bir Hata Oluştu...");
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        } else if (guncelle.equals("1")) {
            try {
                conn=db.java_db();
                
                String isim = String.valueOf(txt_ad.getText());
                String soyisim = String.valueOf(txt_soyisim.getText());
                String tcNo = String.valueOf(txt_tc.getText());
                String telNo = String.valueOf(txt_telno.getText());
                String mail = String.valueOf(txt_mail.getText());
                String adres = String.valueOf(txt_adress.getText());
                String sicilNo = String.valueOf(txt_sicilno.getText());
                String kadrogörev = String.valueOf(txt_kadrogorev.getText());
                String sozlesme = String.valueOf(cb_kadro.getItemAt(cb_kadro.getSelectedIndex()));
                String sifre = String.valueOf(txt_sifre.getText());
                String izinGunu = String.valueOf(lbl_izin.getText());
                
                
                String sql="UPDATE personeller SET `adi` = '"+isim+"', `soyadi` = '"+soyisim+"', `tcNo` = '"+tcNo+"', `telNo` = '"+telNo+"', `mail` = '"+mail+"', `adres` = '"+adres+"', `sicilNo` = '"+sicilNo+"', `kadroGorev` = '"+kadrogörev+"', `sifre` = '"+sifre+"', `statu` = '"+sozlesme+"', `IZINGUNU` = '"+izinGunu+"',`CalismaSaati` = '"+calismaSaati+"' WHERE (`tcNo` = '"+GelentcNo+"');";
                statement = conn.createStatement();
                statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,isim+" Personel Bilgileri Güncellendi...");
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Güncelleme Hatası...");
            }finally{
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
        

    }
int cikis=1;
String izingunleri="";

    private void cb_gunActionPerformed(java.awt.event.ActionEvent evt) {
        if(cikis>izingunSayac){
            cikis=1;
            izingunleri="";
            lbl_izin.setText("");
        }
        
       
        if (cb_gun.getItemAt(cb_gun.getSelectedIndex()).equals("Pazartesi")) {
            izingunleri+=" Pazartesi";
            lbl_izin.setText(izingunleri);
            cikis++;
        } else if(cb_gun.getItemAt(cb_gun.getSelectedIndex()).equals("Salı")){
            izingunleri+=" Salı";
            lbl_izin.setText(izingunleri);
            cikis++;
        }else if(cb_gun.getItemAt(cb_gun.getSelectedIndex()).equals("Çarşamba")){
            izingunleri+=" Çarşamba";
            lbl_izin.setText(izingunleri);
            cikis++;
        }else if(cb_gun.getItemAt(cb_gun.getSelectedIndex()).equals("Perşembe")){
            izingunleri+=" Perşembe";
            lbl_izin.setText(izingunleri);
            cikis++;
        }else if(cb_gun.getItemAt(cb_gun.getSelectedIndex()).equals("Cuma")){
            izingunleri+=" Cuma";
            lbl_izin.setText(izingunleri);
            cikis++;
        }else if(cb_gun.getItemAt(cb_gun.getSelectedIndex()).equals("Cumartesi")){
            izingunleri+=" Cumartesi";
            lbl_izin.setText(izingunleri);
            cikis++;
        }else if(cb_gun.getItemAt(cb_gun.getSelectedIndex()).equals("Pazar")){
            izingunleri+=" pazar";
            lbl_izin.setText(izingunleri);
            cikis++;
        }
        
    }
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PersonelEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonelEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonelEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonelEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonelEkleme().setVisible(true);
            }
        });
    }

    
    private javax.swing.JComboBox<String> cb_gun;
    private javax.swing.JComboBox<String> cb_kadro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_izin;
    private javax.swing.JTextField txt_ad;
    private javax.swing.JTextField txt_adress;
    private javax.swing.JTextField txt_kadrogorev;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_sicilno;
    private javax.swing.JTextField txt_sifre;
    private javax.swing.JTextField txt_soyisim;
    private javax.swing.JTextField txt_tc;
    private javax.swing.JTextField txt_telno;
   
}
