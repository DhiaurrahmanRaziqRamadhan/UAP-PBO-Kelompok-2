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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PenjualanViewController implements Initializable { 
    
    @FXML
    private Button btnEdit;

    @FXML
    private Button btnKembali;

    @FXML
    private TableColumn<Penjualan, Double> tbHarga;

    @FXML
    private TableColumn<Penjualan, Integer> tbJumlah;

    @FXML
    private TableColumn<Penjualan, String> tbNama;

    @FXML
    private TableColumn<Penjualan, Integer> tbStok;
    
    @FXML
    private TableView<Penjualan> tbData;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPenjualan();
    }  

    @FXML
    public void editTable(ActionEvent event)throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("inputPenjualan.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnEdit.getScene().getWindow();
       stage.setScene(new Scene(root));
   }   

   @FXML
   public void kembali (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
   }   
   
   public ObservableList<Penjualan> getPenjualanList(){
       ObservableList<Penjualan> penjualanList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT * FROM penjualan;";
       Statement st;
       ResultSet rs; 
       
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Penjualan pj;
           while(rs.next()){
              pj = new Penjualan(rs.getString("nama_produk"),rs.getInt("jumlahProduk"),rs.getInt("stok"),rs.getDouble("harga"));
               penjualanList.add(pj);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return penjualanList;
   }
   
    public void showPenjualan(){
       ObservableList<Penjualan> list = getPenjualanList();
       tbNama.setCellValueFactory(new PropertyValueFactory<Penjualan,String>("nama_produk"));
       tbJumlah.setCellValueFactory(new PropertyValueFactory<Penjualan,Integer>("jumlahProduk"));
       tbStok.setCellValueFactory(new PropertyValueFactory<Penjualan,Integer>("stok"));
       tbHarga.setCellValueFactory(new PropertyValueFactory<Penjualan,Double>("harga"));
       
       tbData.setItems(list);
   }
}
