
package UiDesing;

import DataBase.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Personeller extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs;
    Statement statement;
    String tcNo;

    
    public Personeller() {
        initComponents();
        tableBosalt(tb_personeller);
        personelDoldur();
    }
  

    public void tableBosalt(javax.swing.JTable tb) {
        DefaultTableModel dm = (DefaultTableModel) tb.getModel();
        int rowCount = dm.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }

    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_personeller = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        personelDuzenle = new javax.swing.JButton();
        personelSil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_personeller.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        tb_personeller.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"deneme1", "dafd", null, "zabıta", "cumartesi,pazar"},
                {"deneme2", "fdsasdf", null, "güvenlik", "pazartesi"},
                {"deneme3", "fds", null, "bekci", "pazar"},
                {"deneme4", "fds", null, "muhasebe", "perşembe"}
            },
            new String [] {
                "Ad", "Soyad", "Personel T.C. No", "Görev", "İzin Günü"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_personeller.setRowHeight(26);
        jScrollPane1.setViewportView(tb_personeller);
        if (tb_personeller.getColumnModel().getColumnCount() > 0) {
            tb_personeller.getColumnModel().getColumn(0).setResizable(false);
        }

        jButton2.setFont(new java.awt.Font("sansserif", 1, 18));
        jButton2.setText("Anasayfaya Dön");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("sansserif", 1, 18)); 
        jButton3.setText("Personel Ekle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        personelDuzenle.setFont(new java.awt.Font("sansserif", 1, 18));
        personelDuzenle.setText("Personeli Düzenle");
        personelDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personelDuzenleActionPerformed(evt);
            }
        });

        personelSil.setFont(new java.awt.Font("sansserif", 1, 18)); 
        personelSil.setText("Personel Sil");
        personelSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personelSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(personelSil, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(personelDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personelSil, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personelDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        YoneticiAnaSayfa frame = new YoneticiAnaSayfa();
        frame.setVisible(true);
        this.setVisible(false);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        PersonelEkleme frame = new PersonelEkleme();
        frame.setVisible(true);
        this.setVisible(false);
    }
String isim,soyisim,telNo,mail,adres,sicilNo,kadroGorev,sifre,statu,IZINGUNU;
        
    private void personelDuzenleActionPerformed(java.awt.event.ActionEvent evt) {
        int seciliRow = tb_personeller.getSelectedRow();
        DefaultTableModel dm = (DefaultTableModel) tb_personeller.getModel();
        if (seciliRow == -1) {
            if (tb_personeller.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Personel Tablosu Boş");
            } else {
                JOptionPane.showMessageDialog(null, "Bilgileri Güncellenecek Personeli Seçiniz");
            }
        } else {
             
            try {
                
                conn=db.java_db();
                
                personelTC=String.valueOf(dm.getValueAt(seciliRow, 2)).trim();
                String tc=personelTC;
                
                String sql="SELECT * FROM personelvardiya.personeller WHERE tcNo='"+tc+"'; ";
                rs=conn.prepareStatement(sql).executeQuery();
                
                while(rs.next()){
                    
                        isim=String.valueOf(rs.getString("adi"));
                        soyisim=String.valueOf(rs.getString("soyadi"));
                        telNo=String.valueOf(rs.getString("telNo"));
                        mail=String.valueOf(rs.getString("mail"));
                        adres=String.valueOf(rs.getString("adres"));
                        sicilNo=String.valueOf(rs.getString("sicilNo"));
                        kadroGorev=String.valueOf(rs.getString("kadroGorev"));
                        sifre=String.valueOf(rs.getString("sifre"));
                        statu=String.valueOf(rs.getString("statu"));
                        IZINGUNU=String.valueOf(rs.getString("IZINGUNU"));
                        
                    
                
                }
                
            } catch (Exception e) {
            }finally{
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
            
            PersonelEkleme frame = new PersonelEkleme(isim,soyisim,personelTC,telNo,mail,adres,sicilNo,kadroGorev,sifre,statu,IZINGUNU," ");
            frame.setVisible(true);
          this.setVisible(false);
        }
        
        
    }
    
    String personelTC = "";

    public void personelDoldur() {
        tableBosalt(tb_personeller);
        DefaultTableModel model = (DefaultTableModel) tb_personeller.getModel();
        try {
            conn = db.java_db();
            rs = conn.prepareStatement("SELECT *FROM personeller").executeQuery();
            while (rs.next()) {
                String ad = String.valueOf(rs.getString("adi"));
                String soyad = String.valueOf(rs.getString("soyadi"));
                String gorev = String.valueOf(rs.getString("kadroGorev"));
                String izin = String.valueOf(rs.getString("IZINGUNU"));
                personelTC = String.valueOf(rs.getString("tcNo"));
                if(!ad.equals("")&&!soyad.equals("")&&!personelTC.equals("")&&!gorev.equals("")&&!izin.equals("")){
                    Object[] eklenecek = {ad, soyad,personelTC ,gorev, izin};
                    model.addRow(eklenecek);
                }
                
            }
        } catch (Exception e) {
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

    private void personelSilActionPerformed(java.awt.event.ActionEvent evt) {
        int seciliRow = tb_personeller.getSelectedRow();
        DefaultTableModel dm = (DefaultTableModel) tb_personeller.getModel();
        if (seciliRow == -1) {
            if (tb_personeller.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Personel Tablosu Boş");
            } else {
                JOptionPane.showMessageDialog(null, "Bilgileri Silinecek Personeli Seçiniz");
            }
        } else {
            String secilentcNo = String.valueOf(dm.getValueAt(seciliRow, 2)).trim();
            String isim=String.valueOf(dm.getValueAt(seciliRow, 0));
            System.out.println(secilentcNo);
            
            try {
                conn = db.java_db();

                String sql = "DELETE FROM `personelvardiya`.`personeller` WHERE (`tcNo` = '"+secilentcNo+"');";

                statement=conn.createStatement();
                statement.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, isim + " Başarıyla Silinmiştir...");
            } catch (Exception e) {
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
            dm.removeRow(seciliRow);
            
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
            java.util.logging.Logger.getLogger(Personeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personeller().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton personelDuzenle;
    private javax.swing.JButton personelSil;
    private javax.swing.JTable tb_personeller;
 
}
