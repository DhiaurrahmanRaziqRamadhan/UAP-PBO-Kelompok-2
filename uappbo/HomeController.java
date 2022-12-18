package uap_pbo;

import static db.dbhelper.getConnection;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HomeController implements Initializable {

    @FXML
    private TableColumn<Makanan, Integer> Mdaya;

    @FXML
    private TableColumn<Makanan, Double> Mdiskon;

    @FXML
    private TableColumn<Makanan, Double> Mharga;

    @FXML
    private TableColumn<Makanan, Integer> Mid;

    @FXML
    private TableColumn<Makanan, Integer> Mjumlah;

    @FXML
    private TableColumn<Makanan, String> Mnama;

    @FXML
    private TableView<Barang> TBbarang;

    @FXML
    private TableView<Makanan> TBmakanan;

    @FXML
    private TableColumn<Barang, String> Tbar;

    @FXML
    private TableColumn<Barang, Double> Tdiskon;

    @FXML
    private TableColumn<Barang, String> Texp;

    @FXML
    private TableColumn<Barang, Double> Tharga;

    @FXML
    private TableColumn<Barang, Integer> Tjumlah;

    @FXML
    private TableColumn<Barang, String> Tkat;

    @FXML
    private TableColumn<Barang, String> Tnama;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnLihat;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnhdp;

    @FXML
    private Button btntdp;

    @FXML
    private Button LihatData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBarang();
        showMakanan();
    }

    @FXML
    public void lihatKategori(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("kategoriView.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnLihat.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    public void tambahData(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("inputPenjualan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btntdp.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    public void hapusData(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hapusPenjualan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnhdp.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    public void tambahProduk(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProdukInput.fxml"));
        Parent root = (Parent) loader.load();

        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    public void hapusProduk(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("produkDelete.fxml"));
        Parent root = (Parent) loader.load();

        Stage stage = (Stage) btnHapus.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public ObservableList<Makanan> getMakananList() {
        ObservableList<Makanan> makananList = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT * FROM makanan;";
        Statement st;
        ResultSet rs;

        try {
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            Makanan makanan;
            while (rs.next()) {
                makanan = new Makanan(rs.getInt("id"), rs.getString("nama_produk"), rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"), rs.getInt("daya_tahan"));
                makananList.add(makanan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return makananList;
    }

    public void showMakanan() {
        ObservableList<Makanan> list = getMakananList();
        Mid.setCellValueFactory(new PropertyValueFactory<Makanan, Integer>("id"));
        Mnama.setCellValueFactory(new PropertyValueFactory<Makanan, String>("nama_produk"));
        Mharga.setCellValueFactory(new PropertyValueFactory<Makanan, Double>("harga"));
        Mjumlah.setCellValueFactory(new PropertyValueFactory<Makanan, Integer>("jumlah"));
        Mdiskon.setCellValueFactory(new PropertyValueFactory<Makanan, Double>("diskon"));
        Mdaya.setCellValueFactory(new PropertyValueFactory<Makanan, Integer>("daya_tahan"));

        TBmakanan.setItems(list);
    }

    public ObservableList<Barang> getBarangList() {
        ObservableList<Barang> barangList = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT * FROM barang;";
        Statement st;
        ResultSet rs;

        try {
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            Barang barang;
            while (rs.next()) {
                barang = new Barang(rs.getString("barcode"), rs.getString("nama_produk"), rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"), rs.getString("expired"), rs.getString("kategori"));
                barangList.add(barang);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return barangList;
    }

    public void showBarang() {
        ObservableList<Barang> list = getBarangList();
        Tbar.setCellValueFactory(new PropertyValueFactory<Barang, String>("barcode"));
        Tnama.setCellValueFactory(new PropertyValueFactory<Barang, String>("nama_produk"));
        Tharga.setCellValueFactory(new PropertyValueFactory<Barang, Double>("harga"));
        Tjumlah.setCellValueFactory(new PropertyValueFactory<Barang, Integer>("jumlah"));
        Tdiskon.setCellValueFactory(new PropertyValueFactory<Barang, Double>("diskon"));
        Texp.setCellValueFactory(new PropertyValueFactory<Barang, String>("expired"));
        Tkat.setCellValueFactory(new PropertyValueFactory<Barang, String>("kategori"));
        TBbarang.setItems(list);
    }
}