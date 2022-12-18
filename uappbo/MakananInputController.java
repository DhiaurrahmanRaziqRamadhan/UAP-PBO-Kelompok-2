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

public class MakananInputController {
    MakananModel mkn = new MakananModel();

    @FXML
    private TextField LBdayatahan;

    @FXML
    private TextField LBdiskon;

    @FXML
    private TextField LBharga;

    @FXML
    private TextField LBid;

    @FXML
    private TextField LBjumlah;

    @FXML
    private TextField LBnama;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnKembali;

    @FXML
    public void tambah(ActionEvent event) throws IOException {
        Makanan mkn1 = new Makanan(Integer.parseInt(LBid.getText()), LBnama.getText(), Double.parseDouble(LBharga.getText()), Integer.parseInt(LBjumlah.getText()), Double.parseDouble(LBdiskon.getText()), Integer.parseInt(LBdayatahan.getText()));
        mkn.addMakanan(mkn1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProdukInput.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    public void kembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProdukInput.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}