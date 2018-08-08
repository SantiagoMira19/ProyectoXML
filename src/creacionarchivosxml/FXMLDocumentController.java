/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creacionarchivosxml;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import modelo.Empleado;

/**
 *
 * @author santiago.mira
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label lbTitulo;
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbDireccion;
    @FXML
    private Label lbEdad;
    @FXML
    private Label lbCodigo;
    @FXML
    private Label lbDpto;
    @FXML
    private TextField tbNombre;
     @FXML
    private TextField tbDireccion;
     @FXML
    private TextField tbEdad;
     @FXML
    private TextField tbCodigo;
     @FXML
    private TextField tbDepto;
      
    LinkedList<Empleado> listaEmpleados;
    
    @FXML
    private void agregarEmpleadoLista(ActionEvent event) {
        String nombre= tbNombre.getText();
        String direccion= tbDireccion.getText();
        String edad= tbEdad.getText();
        String codigo= tbCodigo.getText();
        String depto= tbDepto.getText();
        
        Empleado objE= new Empleado(codigo, depto, nombre, direccion, edad);
        listaEmpleados.add(objE);
        
        tbNombre.setText("");
        tbDireccion.setText("");
        tbEdad.setText("");
        tbCodigo.setText("");
        tbDepto.setText("");
        
        JOptionPane.showMessageDialog(null, "Se agregó un empleado");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       listaEmpleados= new LinkedList<>();
    }    
    
}
