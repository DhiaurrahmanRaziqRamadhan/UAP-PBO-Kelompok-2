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
import model.PenjualModel;

public class InputPenjualanController implements Initializable {
    PenjualModel peju =new PenjualModel();
     @FXML
    private TextField Dharga;

    @FXML
    private TextField Djumlah;

    @FXML
    private TextField Dnama;

    @FXML
    private TextField Dstok;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnLihat;

    @FXML
    private Button btnTambah;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
   public void kembali (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
   }

    @FXML
    void lihat(ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("penjualanView.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnLihat.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
   public void tambah (ActionEvent event) throws IOException{
       Penjualan pj = new Penjualan(Dnama.getText(),Integer.parseInt(Djumlah.getText()),Integer.parseInt(Dstok.getText()),Double.parseDouble(Dharga.getText()));
       peju.addPenjualan(pj);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnTambah.getScene().getWindow();
       stage.setScene(new Scene(root));
   }
    
}
