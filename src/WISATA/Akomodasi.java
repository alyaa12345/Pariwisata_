/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WISATA;

/**
 *
 * @author ALYA NORMAIDA
 */
   
    public class Akomodasi extends Wisata {
    int idAko;
    String jdlAko;
    String tglAko;
    String infoAko;
    String alamatAko;
    String status;

    public Akomodasi(int idWisata, String jdlWisata, String tglWisata, String infoWisata, String alamatWisata, String jnsWisata, int idAdmin,
                     int idAko, String jdlAko, String tglAko, String infoAko, String alamatAko, String status) {
        super(idWisata, jdlWisata, tglWisata, infoWisata, alamatWisata, jnsWisata, idAdmin);
        this.idAko = idAko;
        this.jdlAko = jdlAko;
        this.tglAko = tglAko;
        this.infoAko = infoAko;
        this.alamatAko = alamatAko;
        this.status = status;
    }

    // Getter dan Setter
    public int getIdAko() {
        return idAko;
    }

    public void setIdAko(int idAko) {
        this.idAko = idAko;
    }

    public String getJdlAko() {
        return jdlAko;
    }

    public void setJdlAko(String jdlAko) {
        this.jdlAko = jdlAko;
    }

    public String getTglAko() {
        return tglAko;
    }

    public void setTglAko(String tglAko) {
        this.tglAko = tglAko;
    }

    public String getInfoAko() {
        return infoAko;
    }

    public void setInfoAko(String infoAko) {
        this.infoAko = infoAko;
    }

    public String getAlamatAko() {
        return alamatAko;
    }

    public void setAlamatAko(String alamatAko) {
        this.alamatAko = alamatAko;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
