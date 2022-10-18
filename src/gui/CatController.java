/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.category;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceCategory;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class CatController implements Initializable {

    @FXML
    private TextField tfnomcat;
    @FXML
    private TextField tfimage;
    @FXML
    private TableView<category> tvcat;
    @FXML
    private TableColumn<category, String> colimage;
    @FXML
    private TableColumn<category, String> colnomcat;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showguicat();
    }    
        
    public void showguicat(){
    ServiceCategory sc = new ServiceCategory();   
    ObservableList<category> lista =sc.afficher();
    
    
    colnomcat.setCellValueFactory(new PropertyValueFactory<category,String>("categoryNAME"));
    colimage.setCellValueFactory(new PropertyValueFactory<category,String>("categoryIMAGE"));
    
    tvcat.setItems(lista);
    
    
    
    
    
    
    }
}
