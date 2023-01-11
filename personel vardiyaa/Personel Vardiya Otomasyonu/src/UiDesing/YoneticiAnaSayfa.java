
package UiDesing;

import DataBase.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


public class YoneticiAnaSayfa extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs,rs1;
    Statement statement;
    public YoneticiAnaSayfa() {
        initComponents();
        nobetListe();
    }
    String Gelentc;
    public YoneticiAnaSayfa(String tc) {
        initComponents();
        Gelentc=tc;
        isimKarsilama();
        nobetListe();
    }
    public void isimKarsilama(){
        
        
        String isim="";
        try {
            conn=db.java_db();
            rs=conn.prepareStatement("SELECT *FROM personeller").executeQuery();
            while(rs.next()){
                if(Gelentc.equals(String.valueOf(rs.getString("tcNo")))){
                    isim=String.valueOf(rs.getString("adi"));
                    isim+=" Yönetici Paneline Hoşgeldiniz";
                    lbl_karsilama.setText(isim);
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
    public void tableBosalt(javax.swing.JTable tb) {
        DefaultTableModel dm = (DefaultTableModel) tb.getModel();
        int rowCount = dm.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }
   
    
    public void nobetListe()
    {
        SimpleDateFormat sekil = new SimpleDateFormat("dd.MM.yyyy");
                 Date   tarih = new Date();
                
        tableBosalt(tb_nobet);
        DefaultTableModel model = (DefaultTableModel) tb_nobet.getModel();
        lbl_tarih.setText("Bugün: "+sekil.format(tarih));
        try {
            conn = db.java_db();
            System.out.println(sekil.format(tarih));
            rs = conn.prepareStatement("SELECT *FROM nobettime WHERE NobetTarihi='"+sekil.format(tarih)+"'").executeQuery();
            while (rs.next()) {
                String tc=String.valueOf(rs.getString("PERSONELTC"));
                String adSoyad ="";
                String nTarihi = String.valueOf(rs.getString("NobetTarihi"));
                String nSaati = String.valueOf(rs.getString("NobetSaati"));
                String vardiya=String.valueOf(rs.getString("VardiyaSistemi"));
                
                rs1=conn.prepareStatement("SELECT * FROM personeller WHERE tcNo='"+tc+"'").executeQuery();
                String gorev="";
                while(rs1.next()){
                    gorev=String.valueOf(rs1.getString("kadroGorev"));
                    String ad= String.valueOf(rs1.getString("adi"));
                    String soyad= String.valueOf(rs1.getString("soyadi"));
                    adSoyad=ad+" "+soyad;
                }if(!adSoyad.equals("")&& !gorev.equals("") && !nSaati.equals("")){
                    Object[] eklenecek = {adSoyad,gorev,vardiya,nSaati};
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
    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        lbl_karsilama = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_nobet = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_vardiyaDuzenle = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btn_vardiyalarıGoruntule = new javax.swing.JButton();
        lbl_tarih = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yönetici Paneli");

        lbl_karsilama.setFont(new java.awt.Font("sansserif", 1, 14));
        lbl_karsilama.setText("(yönetici adı) Hoşgeldiniz");

        jPanel1.setBorder(null);

        tb_nobet.setFont(new java.awt.Font("sansserif", 3, 12)); 
        tb_nobet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Hüseyin Karadana", "Memur", null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Personel Adı", "Görev", "Vardiya Sistemi", "Çalışma Saatleri"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_nobet.setRowHeight(26);
        jScrollPane1.setViewportView(tb_nobet);
        if (tb_nobet.getColumnModel().getColumnCount() > 0) {
            tb_nobet.getColumnModel().getColumn(0).setResizable(false);
            tb_nobet.getColumnModel().getColumn(1).setResizable(false);
            tb_nobet.getColumnModel().getColumn(2).setResizable(false);
            tb_nobet.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); 
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bugün Nöbetçi Personeller Ve Nöbet Saatleri");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jButton1.setFont(new java.awt.Font("sansserif", 1, 14));
        jButton1.setText("Personel Eklemek İçin Tıklayınız");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_vardiyaDuzenle.setFont(new java.awt.Font("sansserif", 1, 14)); 
        btn_vardiyaDuzenle.setText("Vardiya Ekle");
        btn_vardiyaDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vardiyaDuzenleActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jButton3.setText("Giriş Sayfasına Gitmek İçin Tıklayınız");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("sansserif", 1, 14)); 
        jButton4.setText("Personelleri Görüntüle");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btn_vardiyalarıGoruntule.setFont(new java.awt.Font("sansserif", 1, 14)); 
        btn_vardiyalarıGoruntule.setText("Vardiyaları Görüntüle");
        btn_vardiyalarıGoruntule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vardiyalarıGoruntuleActionPerformed(evt);
            }
        });

        lbl_tarih.setFont(new java.awt.Font("sansserif", 1, 12));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_vardiyaDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_vardiyalarıGoruntule, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lbl_karsilama, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(lbl_tarih, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_karsilama, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(lbl_tarih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn_vardiyaDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_vardiyalarıGoruntule, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
        );

        pack();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        Login frame=new Login();
        frame.setVisible(true);
        this.setVisible(false);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        PersonelEkleme frame=new PersonelEkleme();
        frame.setVisible(true);
        this.setVisible(false);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        Personeller frame=new Personeller();
        frame.setVisible(true);
        this.setVisible(false);
    }

    private void btn_vardiyalarıGoruntuleActionPerformed(java.awt.event.ActionEvent evt) {
        Vardiyalar frame=new Vardiyalar();
        frame.setVisible(true);
        this.setVisible(false);
        
    }

    private void btn_vardiyaDuzenleActionPerformed(java.awt.event.ActionEvent evt) {
        VardiyaEkle frame=new VardiyaEkle();
        frame.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(YoneticiAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YoneticiAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YoneticiAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YoneticiAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YoneticiAnaSayfa().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton btn_vardiyaDuzenle;
    private javax.swing.JButton btn_vardiyalarıGoruntule;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_karsilama;
    private javax.swing.JLabel lbl_tarih;
    private javax.swing.JTable tb_nobet;
    
}
