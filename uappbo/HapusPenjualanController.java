package uap_pbo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MakananModel;
import model.PenjualModel;

public class HapusPenjualanController {
    PenjualModel peju = new PenjualModel();

    @FXML
    private TextField flNama;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    public void hapus(ActionEvent event) throws IOException {
        Penjualan pr = new Penjualan(flNama.getText());
        pr.getNama_produk();
        peju.deleteProduk(pr);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hapusPenjualan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnHapus.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    public void kembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}