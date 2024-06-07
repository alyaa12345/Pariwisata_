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
public class pesan_CRUD {
   private String databasename = "alya_normaida_2210010455";
   private String username ="root";
   private String password ="";
   public static Connection connectionDB;
   
   public pesan_CRUD (){
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
   
   public void simpanpesan_CRUD(int id_pesan, String jdl_pesan, Date tgl_pesan,String dari, String email, String pesan, int id_admin ){
       try {
           String sql = "insert into pesan (id_pesan, jdl_pesan, tgl_pesan, dari, email, pesan, id_admin ) VALUE(?, ?, ?, ?, ?, ?, ?)";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1, id_pesan );
           perintah.setString(2, jdl_pesan);
           perintah.setDate(3, tgl_pesan );
           perintah.setString(4, dari );
           perintah.setString(5, email );
           perintah.setString(6, pesan );
           perintah.setInt(7, id_admin );
           perintah.executeUpdate();
           System.out.println("data berhasil tersimpan");
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
   
   public void ubahpesan_CRUD(int id_pesan, String jdl_pesan, Date tgl_pesan,String dari, String email, String pesan, int id_admin ){
       try {
           String sql = "update pesan set jdl_pesan = ?, tgl_pesan = ?, dari = ?, email = ?, pesan = ?, id_admin = ? WHERE id_pesan =?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setString(1, jdl_pesan );
           perintah.setDate(2, tgl_pesan);
           perintah.setString(3, dari );
           perintah.setString(4, email );
           perintah.setString(5, pesan );
           perintah.setInt(6, id_admin );
           perintah.setInt(7, id_pesan );
           perintah.executeUpdate();
           System.out.println("updated");
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
    
   public void hapuspesan_CRUD (int id_pesan) {
       try {
           String sql = "delete from pesan WHERE id_pesan = ?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1, id_pesan );

           
           perintah.executeUpdate();
           System.out.println("deleted");
           
       } 
       catch (Exception e) {
           System.out.println(e.getMessage());
    }
}
   public void caripesan_CRUD(int paramid_pesan ){
       try {
           String sql = "SELECT*FROM pesan WHERE id_pesan=?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1,paramid_pesan);
           ResultSet data = perintah.executeQuery();
           while (data.next()){
               System.out.println("id_pesan:"+data.getInt("id_pesan"));
               System.out.println("jdl_pesan:"+data.getString("jdl_pesan"));
               System.out.println("tgl_pesan:"+data.getDate("tgl_pesan"));
               System.out.println("dari:"+data.getString("dari"));
               System.out.println("email:"+data.getString("email"));
               System.out.println("pesan:"+data.getString("pesan"));
               System.out.println("id_admin:"+data.getInt("id_admin"));               
           }    
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
    
    public void datapesan_CRUD(){
       try {
           Statement stmt = connectionDB.createStatement();
           ResultSet baris = stmt.executeQuery("SELECT*FROM pesan ORDER BY id_pesan ASC");
           while (baris.next()){
               System.out.println(+
                       baris.getInt("id_pesan")+"I"+
                       baris.getString("jdl_pesan")+"I"+
                       baris.getDate("tgl_pesan")+"I"+
                       baris.getString("dari")+"I"+
                       baris.getString("email")+"I"+
                       baris.getString("pesan")+"I"+
                       baris.getInt("id_admin"));
             }
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
 }
