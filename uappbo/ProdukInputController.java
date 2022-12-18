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
import javafx.stage.Stage;

public class ProdukInputController {

   @FXML 
   private Button btnMakanan;
   
   @FXML
   private Button btnProduk;
   
   @FXML
   private Button btnKembali;
   
   @FXML
   public void makanInp (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("makananInput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnMakanan.getScene().getWindow();
       stage.setScene(new Scene(root));
   }
   
   @FXML
   public void barangIpt (ActionEvent event) throws IOException{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("barangInput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnProduk.getScene().getWindow();
       stage.setScene(new Scene(root));
   }
   
   @FXML
   public void kembali (ActionEvent event) throws IOException{       
       FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
   }
}