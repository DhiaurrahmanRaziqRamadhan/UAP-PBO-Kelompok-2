package uap_pbo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.KategoriModel;

public class KategoriDeleteController {
    KategoriModel kategoriModel = new KategoriModel();

    @FXML
    private TextField HKategori;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    void hapus(ActionEvent event) {
        Kategori kategori = new Kategori(HKategori.getText());
        kategoriModel.deleteKategori(kategori);
    }

    @FXML
    public void kembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("kategoriView.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
