/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WISATA;

/**
 *
 * @author ALYA NORMAIDA
 */
public class Wisata {
    
    int idWisata;
    String jdlWisata;
    String tglWisata;
    String infoWisata;
    String alamatWisata;
    String jnsWisata;
    int idAdmin;

    public Wisata(int idWisata, String jdlWisata, String tglWisata, String infoWisata, String alamatWisata, String jnsWisata, int idAdmin) {
        this.idWisata = idWisata;
        this.jdlWisata = jdlWisata;
        this.tglWisata = tglWisata;
        this.infoWisata = infoWisata;
        this.alamatWisata = alamatWisata;
        this.jnsWisata = jnsWisata;
        this.idAdmin = idAdmin;
    }

    // Getter dan Setter
    public int getIdWisata() {
        return idWisata;
    }

    public void setIdWisata(int idWisata) {
        this.idWisata = idWisata;
    }

    public String getJdlWisata() {
        return jdlWisata;
    }

    public void setJdlWisata(String jdlWisata) {
        this.jdlWisata = jdlWisata;
    }

    public String getTglWisata() {
        return tglWisata;
    }

    public void setTglWisata(String tglWisata) {
        this.tglWisata = tglWisata;
    }

    public String getInfoWisata() {
        return infoWisata;
    }

    public void setInfoWisata(String infoWisata) {
        this.infoWisata = infoWisata;
    }

    public String getAlamatWisata() {
        return alamatWisata;
    }

    public void setAlamatWisata(String alamatWisata) {
        this.alamatWisata = alamatWisata;
    }

    public String getJnsWisata() {
        return jnsWisata;
    }

    public void setJnsWisata(String jnsWisata) {
        this.jnsWisata = jnsWisata;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
}


