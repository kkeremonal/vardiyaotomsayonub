

package DataBase;
import UiDesing.YoneticiAnaSayfa;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class db {
    Connection conn=null;
    public static Connection java_db(){
        try{
            
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/personelvardiya?useTimezone=true&serverTimezone=UTC","root","12345678");
            return conn;
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,e);
            return null;
        }

    }
    public static void girisYap(String kadi,String sifre){
            Connection conn = null;
         ResultSet rs=null;
         
         
         
        try {
            conn=db.java_db();
            rs=conn.createStatement().executeQuery("SELECT * FROM gb");
             
            while(rs.next()){
                System.out.println(String.valueOf(rs.getString(2)));//2 kullanıcı adları,3 şifreler
                if(kadi.equals(kadi.equals(String.valueOf(rs.getString(2))))&&sifre.equals(rs.getString(3))){
                    JOptionPane.showMessageDialog(null,"Giriş Başarılı...");
                    if(String.valueOf(rs.getString(4)).equals("Yonetici")){
                        YoneticiAnaSayfa frame=new YoneticiAnaSayfa();
                        frame.setVisible(true);
                    }
                    
                }
            }
        } catch (Exception e) {
        }finally{
            try {
                conn.close();
            } catch (Exception e) {
            }}
        }
        
        
    }
    

