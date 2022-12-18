package uap_pbo;

import static db.dbhelper.getConnection;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.BarangModel;
import model.KategoriModel;

public class KategoriViewController implements Initializable {

    KategoriModel brg = new KategoriModel();

    @FXML
    private TableColumn<Kategori, String> nKat;

    @FXML
    private Button Kkembali;

    @FXML
    private TableView<Kategori> Tkategori;
    
    @FXML
    private Button btnHapus;
    
    @FXML
    private Button btnTambah;
    
    @FXML
    public void Tambah(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("KategoriInput.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    @FXML
    void hapus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("KategoriDelete.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBarang();
    }

    @FXML
    public void kembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) Kkembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public ObservableList<Kategori> getKategoriList() {

        ObservableList<Kategori> kategoriList = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT nama_kategori FROM kategori ;";
        Statement st;
        ResultSet rs;

        try {
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            Kategori kategori;
            while (rs.next()) {
                kategori = new Kategori(rs.getString("nama_kategori"));
                kategoriList.add(kategori);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return kategoriList;
    }

    public void showBarang() {
        ObservableList<Kategori> list = getKategoriList();
        nKat.setCellValueFactory(new PropertyValueFactory<Kategori, String>("nama_kategori"));

        Tkategori.setItems(list);

    }

}
