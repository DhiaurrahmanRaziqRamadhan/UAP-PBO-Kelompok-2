package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uap_pbo.Kategori;
import uap_pbo.Produk;

public class KategoriModel {
    
    private final Connection CONN;

    public KategoriModel() {
        this.CONN = db.dbhelper.getConnection();
    }
    
    public void addKategori(Kategori kategori) {
        String insert = "INSERT INTO kategori VALUES ('" + kategori.getNama_kategori() + "');";
        try {
            if (CONN.createStatement().executeUpdate(insert) > 0) {
                System.out.println("Data Berhasil Dimasukkan");
            } else {
                System.out.println("Data yang dimasukkan sudah ada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
    }

    public void deleteKategori(Kategori kategori) {//menghapus data didalam query
        String delete = "DELETE FROM kategori  WHERE nama_kategori = '" + kategori.getNama_kategori() + "';";

        try {
            if (CONN.createStatement().executeUpdate(delete) > 0) {
                System.out.println("Data Berhasil Dihapus");
            } else {
                System.out.println("Data Gagal dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
        }
    }
}
