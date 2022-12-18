package model;

import java.sql.Connection;
import db.dbhelper;
import uap_pbo.Produk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdukModel {

    private final Connection CONN;

    public ProdukModel() {
        this.CONN = dbhelper.getConnection();
    }

    public void addProduk(Produk prd) {
        String insert = "INSERT INTO produk VALUES ('"
                + prd.getNama_produk() + "', '" + prd.getHarga() + "', '" + prd.getJumlah() + "','" + prd.getDiskon() + "'" + ");";

        try {
            if (CONN.createStatement().executeUpdate(insert) > 0) {
                System.out.println("Data Berhasil Dimasukkan");
            } else {
                System.out.println("Data yang dimasukkan sudah ada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
    }

    public void updateProduk(Produk prd) {//untuk memperbarui data pada query
        String update = "UPDATE produk SET nama_produk = '" + prd.getNama_produk() + "', harga = '" + prd.getHarga() + "', jumlah =" + prd.getJumlah() + "',diskon = " + prd.getDiskon() + "' WHERE nama_produk = '" + prd.getOldname() + "';";

        try {
            if (CONN.createStatement().executeUpdate(update) > 0) {
                System.out.println("Data Berhasil Diperbarui");
            } else {
                System.out.println("Data yang dimasukkan tidak berubah");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
    }

    public void deleteProduk(Produk prd) {//menghapus data didalam query
        String delete = "DELETE FROM produk WHERE nama_produk = '" + prd.getNama_produk() + "';";

        try {
            if (CONN.createStatement().executeUpdate(delete) > 0) {
                System.out.println("Data Berhasil Dihapus");
            } else {
                System.out.println("Data Gagal dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
        }
    }

    public ArrayList<Produk> getProduk() {
        String query = "SELECT * FROM produk";
        ArrayList<Produk> produk = new ArrayList<Produk>();
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while (rs.next()) {
                Produk temp = new Produk(rs.getString("nama_produk"), rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"));
                produk.add(temp);
            }
            System.out.println("Berhasil mengambil data");
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data" + e.getMessage());
        }
        return produk;
    }
}
