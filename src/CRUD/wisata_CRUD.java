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
public class wisata_CRUD {
   private String databasename = "alya_normaida_2210010455";
   private String username ="root";
   private String password ="";
   public static Connection connectionDB;
   
   public wisata_CRUD (){
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
   
   public void simpanWisata_CRUD(int id_wisata, String jdl_wisata, Date tgl_wisata,String info_wisata, String alamat_wisata, String jns_wisata, int id_admin ){
       try {
           String sql = "insert into wisata (id_wisata, jdl_wisata, tgl_wisata, info_wisata, alamat_wisata, jns_wisata, id_admin ) VALUE(?, ?, ?, ?, ?, ?, ?)";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1, id_wisata );
           perintah.setString(2, jdl_wisata);
           perintah.setDate(3, tgl_wisata );
           perintah.setString(4, info_wisata );
           perintah.setString(5, alamat_wisata );
           perintah.setString(6, jns_wisata );
           perintah.setInt(7, id_admin );
           perintah.executeUpdate();
           System.out.println("data berhasil tersimpan");
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
   
   public void ubahWisata_CRUD(int id_wisata, String jdl_wisata, Date tgl_wisata,String info_wisata, String alamat_wisata, String jns_wisata, int id_admin ){
       try {
           String sql = "update wisata set jdl_wisata =?, tgl_wisata =?, info_wisata =?, alamat_wisata =?, jns_wisata =?, id_admin =? WHERE id_wisata =?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setString(1, jdl_wisata );
           perintah.setDate(2, tgl_wisata);
           perintah.setString(3, info_wisata );
           perintah.setString(4, alamat_wisata );
           perintah.setString(5, jns_wisata );
           perintah.setInt(6, id_admin );
           perintah.setInt(7, id_wisata );
           perintah.executeUpdate();
           System.out.println("updated");
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
    
   public void hapusWisata_CRUD (int id_wisata) {
       try {
           String sql = "delete from wisata WHERE id_wisata = ?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1, id_wisata );

           
           perintah.executeUpdate();
           System.out.println("deleted");
           
       } 
       catch (Exception e) {
           System.out.println(e.getMessage());
    }
}
   
   public void cariwisata_CRUD(int paramid_wisata ){
       try {
           String sql = "SELECT*FROM wisata WHERE id_wisata=?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1,paramid_wisata);
           ResultSet data = perintah.executeQuery();
           while (data.next()){
               System.out.println("id_wisata:"+data.getInt("id_wisata"));
               System.out.println("jdl_wisata:"+data.getString("jdl_wisata"));
               System.out.println("tgl_wisata:"+data.getDate("tgl_wisata"));
               System.out.println("info_wisata:"+data.getString("info_wisata"));
               System.out.println("alamat_wisata:"+data.getString("alamat_wisata"));
               System.out.println("jns_wisata:"+data.getString("jns_wisata"));
               System.out.println("id_admin:"+data.getInt("id_admin"));               
           }    
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
    
    public void datawisata_CRUD(){
       try {
           Statement stmt = connectionDB.createStatement();
           ResultSet baris = stmt.executeQuery("SELECT*FROM wisata ORDER BY id_wisata ASC");
           while (baris.next()){
               System.out.println(+
                       baris.getInt("id_wisata")+"I"+
                       baris.getString("jdl_wisata")+"I"+
                       baris.getDate("tgl_wisata")+"I"+
                       baris.getString("info_wisata")+"I"+
                       baris.getString("alamat_wisata")+"I"+
                       baris.getString("jns_wisata")+"I"+
                       baris.getInt("id_admin"));
             }
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
 }
