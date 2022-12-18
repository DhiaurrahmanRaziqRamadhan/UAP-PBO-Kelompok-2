package model;

import java.sql.Connection;
import db.dbhelper;
import uap_pbo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MakananModel {

    private final Connection CONN;

    public MakananModel() {
        this.CONN = db.dbhelper.getConnection();
    }

    public void addMakanan(Makanan mkn) {
        String insert = "INSERT INTO makanan VALUES ('" + mkn.getId() + "','"
                + mkn.getNama_produk() + "','"
                + mkn.getHarga() + "','"
                + mkn.getJumlah() + "','"
                + mkn.getDiskon() + "', '"
                + mkn.getDaya_tahan() + "');";
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

    public void updateProduk(Makanan mkn, Produk prd) {//untuk memperbarui data pada query
        String update = "UPDATE makanan SET id = '" + mkn.getId() + "', nama_produk = '" + prd.getNama_produk()
                + "', harga = '" + prd.getHarga() + "', jumlah = '" + prd.getJumlah()
                + "', diskon = '" + prd.getDiskon() + "', daya_tahan = '" + mkn.getDaya_tahan()
                + "' WHERE id = '" + mkn.getId() + "';";

        try {
            if (CONN.createStatement().executeUpdate(update) > 0) {
                System.out.println("Data Berhasil Diperbarui");
            } else {
                System.out.println("Data yang dimasukkan tidak berubah");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
    }

    public void deleteProduk(Makanan mkn) {//menghapus data didalam query
        String delete = "DELETE FROM makanan WHERE id = '" + mkn.getId() + "';";

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
