/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import static CRUD.DATABASE.connectionDB;
import static CRUD.akomodasi_CRUD.connectionDB;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager; //menghubungkan database
import java.sql.PreparedStatement; // periksa sql [CRUD]
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author ALYA NORMAIDA
 */
public class informasi_CRUD {
   private String databasename = "alya_normaida_2210010455";
   private String username ="root";
   private String password ="";
   public static Connection connectionDB;
   
   public informasi_CRUD (){
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
   
   public void simpaninformasi_CRUD(int id_info, String jdl_info, Date tgl_info, String info, String alamat_gmb, int id_admin ){
       try {
           String sql = "insert into informasi (id_info, jdl_info, tgl_info, info, alamat_gmb, id_admin ) VALUE(?, ?, ?, ?, ?, ?)";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1, id_info );
           perintah.setString(2, jdl_info);
           perintah.setDate(3, tgl_info );
           perintah.setString(4, info );
           perintah.setString(5, alamat_gmb );
           perintah.setInt(6, id_admin );
           perintah.executeUpdate();
           System.out.println("data berhasil tersimpan");
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
   
   public void ubahinformasi_CRUD(int id_info, String jdl_info, Date tgl_info, String info, String alamat_gmb, int id_admin ){
       try {
           String sql = "update informasi set jdl_info = ?, tgl_info = ?, info = ?, alamat_gmb = ?, id_admin = ? WHERE id_info =?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setString(1, jdl_info );
           perintah.setDate(2, tgl_info);
           perintah.setString(3, info );
           perintah.setString(4, alamat_gmb );
           perintah.setInt(5, id_admin );
           perintah.setInt(6, id_info );
           perintah.executeUpdate();
           System.out.println("updated");
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
    
   public void hapusinformasi_CRUD (int id_info ) {
       try {
           String sql = "delete from informasi WHERE id_info = ?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1, id_info );

           
           perintah.executeUpdate();
           System.out.println("deleted");
           
       } 
       catch (Exception e) {
           System.out.println(e.getMessage());
    }
}
   public void cariinformasi_CRUD(int paramid_info ){
       try {
           String sql = "SELECT*FROM informasi WHERE id_info=?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1,paramid_info);
           ResultSet data = perintah.executeQuery();
           while (data.next()){
               System.out.println("id_info:"+data.getInt("id_info"));
               System.out.println("jdl_info:"+data.getString("jdl_info"));
               System.out.println("tgl_info:"+data.getDate("tgl_info"));
               System.out.println("info:"+data.getString("info"));
               System.out.println("alamat_gmb:"+data.getString("alamat_gmb"));
               System.out.println("id_admin:"+data.getInt("id_admin"));               
           }    
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
    
    public void datainformasi_CRUD(){
       try {
           Statement stmt = connectionDB.createStatement();
           ResultSet baris = stmt.executeQuery("SELECT*FROM informasi ORDER BY id_info ASC");
           while (baris.next()){
               System.out.println(+
                       baris.getInt("id_info")+"I"+
                       baris.getString("jdl_info")+"I"+
                       baris.getDate("tgl_ako")+"I"+
                       baris.getString("info")+"I"+
                       baris.getString("alamat_gmb")+"I"+
                       baris.getInt("id_admin"));
             }
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
 }
