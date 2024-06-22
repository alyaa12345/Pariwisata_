/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import static CRUD.wisata_CRUD.connectionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

/**
 *
 * @author ALYA NORMAIDA
 */
public class akomodasi_CRUD {
   private String databasename = "alya_normaida_2210010455";
   private String username ="root";
   private String password ="";
   public static Connection connectionDB;
   
  public akomodasi_CRUD (){
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
  public void simpanakomodasi_CRUD(int id_ako, String jdl_ako, Date tgl_ako,String info_ako, String alamat_ako, String status, int id_admin ){
       try {
           String sql = "insert into Akomodasi (id_ako, jdl_ako, tgl_ako, info_ako, alamat_ako, status, id_admin ) VALUE(?, ?, ?, ?, ?, ?, ?)";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1, id_ako );
           perintah.setString(2, jdl_ako);
           perintah.setDate(3, tgl_ako );
           perintah.setString(4, info_ako );
           perintah.setString(5, alamat_ako );
           perintah.setString(6, status );
           perintah.setInt(7, id_admin );
           perintah.executeUpdate();
           System.out.println("data berhasil tersimpan");
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
   
   public void ubahakomodasi_CRUD(int id_ako, String jdl_ako, Date tgl_ako,String info_ako, String alamat_ako, String status, int id_admin ){
       try {
           String sql = "update Akomodasi set jdl_ako = ?, tgl_ako = ?, info_ako = ?, alamat_ako = ?, status = ?, id_admin = ? WHERE id_ako =?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setString(1, jdl_ako );
           perintah.setDate(2, tgl_ako);
           perintah.setString(3, info_ako );
           perintah.setString(4, alamat_ako );
           perintah.setString(5, status );
           perintah.setInt(6, id_admin ); 
           perintah.setInt(7, id_ako );
           perintah.executeUpdate();
           System.out.println("updated");
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
    
   public void hapusakomodasi_CRUD (int id_ako) {
       try {
           String sql = "delete from akomodasi WHERE id_ako = ?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1, id_ako );

           
           perintah.executeUpdate();
           System.out.println("deleted");
           
       } 
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
    public void cariakomodasi_CRUD(int paramid_ako ){
       try {
           String sql = "SELECT*FROM akomodasi WHERE id_ako=?";
           PreparedStatement perintah = connectionDB.prepareStatement(sql);
           perintah.setInt(1,paramid_ako);
           ResultSet data = perintah.executeQuery();
           while (data.next()){
               System.out.println("id_ako:"+data.getInt("id_ako"));
               System.out.println("jdl_ako:"+data.getString("jdl_ako"));
               System.out.println("tgl_ako:"+data.getDate("tgl_ako"));
               System.out.println("info_ako:"+data.getString("info_ako"));
               System.out.println("alamat_ako:"+data.getString("alamat_ako"));
               System.out.println("status:"+data.getString("status"));
               System.out.println("id_admin:"+data.getInt("id_admin"));               
           }    
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
    
    public void dataakomodasi_CRUD(){
       try {
           Statement stmt = connectionDB.createStatement();
           ResultSet baris = stmt.executeQuery("SELECT*FROM akomodasi ORDER BY id_ako ASC");
           while (baris.next()){
               System.out.println(+
                       baris.getInt("id_ako")+"I"+
                       baris.getString("jdl_ako")+"I"+
                       baris.getDate("tgl_ako")+"I"+
                       baris.getString("info_ako")+"I"+
                       baris.getString("alamat_ako")+"I"+
                       baris.getString("status_ako")+"I"+
                       baris.getInt("id_admin"));
             }
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
}
