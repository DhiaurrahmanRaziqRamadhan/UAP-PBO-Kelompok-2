package model;

import java.sql.Connection;
import db.dbhelper;
import static db.dbhelper.getConnection;
import uap_pbo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class BarangModel {

    private final Connection CONN;

    public BarangModel() {
        this.CONN = db.dbhelper.getConnection();
    }

    public void addBarang(Barang barang) {
        String insert = "INSERT INTO barang VALUES ('" + barang.getBarcode() + "','" + barang.getNama_produk()
                + "','" + barang.getHarga() + "','" + barang.getJumlah()
                + "','" + barang.getDiskon() + "','" + barang.getExpired() + "','" + barang.getKategori() + "');";
        try {
            if (CONN.createStatement().executeUpdate(insert) > 0) {
                System.out.println("Data Berhasil Dimasukkan");
            } else {
                System.out.println("Data yang dimasukkan sudah ada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
    }

    public void updateBarang(Barang barang, Produk produk, Kategori kategori) {//untuk memperbarui data pada query
        String update = "UPDATE barang SET barcode = '" + barang.getBarcode() + "', nama_produk = '" + produk.getNama_produk()
                + "', harga = '" + produk.getHarga() + "', jumlah = '" + produk.getHarga()
                + "', diskon = '" + produk.getDiskon() + "', expired = '" + barang.getExpired() + "', kategori = '" + kategori.getNama_kategori()
                + "' WHERE barcode = '" + barang.getBarcode() + "';";
        try {
            if (CONN.createStatement().executeUpdate(update) > 0) {
                System.out.println("Data Berhasil Diperbarui");
            } else {
                System.out.println("Data yang dimasukkan tidak berubah");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
    }

    public void deleteProduk(Barang barang) {//menghapus data didalam query
        String delete = "DELETE FROM barang WHERE barcode = '" + barang.getBarcode() + "';";

        try {
            if (CONN.createStatement().executeUpdate(delete) > 0) {
                System.out.println("Data Berhasil Dihapus");
            } else {
                System.out.println("Data Gagal dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
        }
    }

    public void selectProduk(Kategori kategori) {
        String select = "SELECT FROM barang WHERE barcode = '" + kategori.getNama_kategori() + "';";

        try {
            if (CONN.createStatement().executeUpdate(select) > 0) {
                System.out.println("Data Berhasil Ditampilkan");
            } else {
                System.out.println("Data Gagal ditampilkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal ditampilkan");
        }
    }
}
