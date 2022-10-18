/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.category;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
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
    
    @FXML
    private void ajouterCategory(ActionEvent event) throws IOException {
        ServiceCategory sp = new ServiceCategory();
         
        
        sp.ajouter(new category(tfnomcat.getText(),tfimage.getText())); //la méthode getText() retourne toujours une chaine de caractère 
        JOptionPane.showMessageDialog(null,"Category Ajoutée !");
        showguicat();
        
    }
    @FXML
    private void supprimerCategory(ActionEvent event) {
        category c = tvcat.getSelectionModel().getSelectedItem();
      
        ServiceCategory sc = new ServiceCategory();
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation supp ");
        alert.setHeaderText("Confirmation suppression category intitulé : " + c.getCategoryNAME());
        alert.setContentText("Avec confirmation cette categorie va être supprimé d'un manière difinitive");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        sc.supprimer(c);
        JOptionPane.showMessageDialog(null,"category supprimée ! ");
        showguicat();
        alert.hide();
         } else {
            alert.hide();
        }
       
        
        

    }
    @FXML
    
    private void modifiercategory(ActionEvent event) {
        

      
        
        
        category c = tvcat.getSelectionModel().getSelectedItem();
        //System.out.println(" ***********"  + e);  
        ServiceCategory sc = new ServiceCategory();
        sc.modifier(new category( c.getCategoryID(),  tfnomcat.getText()  ,   tfimage.getText()    ));
        JOptionPane.showMessageDialog(null,"categorie modifié ! ");
        showguicat();
     }
    
     @FXML
    private void editcat2(ActionEvent event) {
                     if(tvcat.getSelectionModel().getSelectedItem()!=null) {
             category c = tvcat.getSelectionModel().getSelectedItem();
             

             tfnomcat.setText(c.getCategoryNAME());
             tfimage.setText(c.getCategoryIMAGE());
             
               
    }    
                     
    }
                  
    




}
