/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager; //menghubungkan database
import java.sql.PreparedStatement; // periksa sql [CRUD]
/**
 *
 * @author ALYA NORMAIDA
 */
public class DATABASE {
   private String databasename = "alya_normaida_2210010455";
   private String username ="root";
   private String password ="";
   public static Connection connectionDB;
   
   public DATABASE (){
       try {
          String location = "jdbc:mysql://localhost/" + databasename;
          Class.forName("com.mysql.jdbc.Driver");
          connectionDB =DriverManager.getConnection(location, username, password);
          System.out.println("database terkoneksi");
       }
        catch (Exception e) {
            System.out.println(e.getMessage());
       }
   }
   
   public void simpanuji(String NIK, String NAMA, String TELPON, String ALAMAT ){
       try {
           String sql = "insert into uji (NIK, NAMA, TELPON, ALAMAT) VALUE(?, ?, ?, ?)";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setString(1, NIK );
           perintah.setString(2, NAMA );
           perintah.setString(3, TELPON );
           perintah.setString(4, ALAMAT );
           perintah.executeUpdate();
           System.out.println("data berhasil tersimpan");
           
       } 
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
   }
   
   public void ubahuji(String NIK, String NAMA, String TELPON, String ALAMAT ){
       try {
           String sql = "update uji set nama = ?, TELPON = ?, ALAMAT =? WHERE NIK =?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setString(1, NAMA );
           perintah.setString(2, TELPON );
           perintah.setString(3, ALAMAT );
           perintah.setString(4, NIK );
           
           perintah.executeUpdate();
           System.out.println("updated");
           
       } 
       catch (Exception e) {
           System.out.println(e.getMessage());
    }
}
   
   public void hapusuji(String NIK){
       try {
           String sql = "delete from uji WHERE NIK = ?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setString(1, NIK );

           
           perintah.executeUpdate();
           System.out.println("deleted");
           
       } 
       catch (Exception e) {
           System.out.println(e.getMessage());
    }
}
   
}
