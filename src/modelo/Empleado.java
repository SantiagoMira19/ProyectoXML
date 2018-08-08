/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author dacastro
 */
public class Empleado extends Persona {

    private String codigoEmpleado;
    private String departamento;

    public Empleado() {
    }

    public Empleado(String codigoEmpleado, String departamento, String nombre, String direccion, String edad) {
        super(nombre, direccion, edad);
        this.codigoEmpleado = codigoEmpleado;
        this.departamento = departamento;
    }

    /**
     * Get the value of departamento
     *
     * @return the value of departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Set the value of departamento
     *
     * @param departamento new value of departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Get the value of codigoEmpleado
     *
     * @return the value of codigoEmpleado
     */
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    /**
     * Set the value of codigoEmpleado
     *
     * @param codigoEmpleado new value of codigoEmpleado
     */
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    @Override
    public String toString() {
        return  super.toString() + "," + codigoEmpleado + "," + departamento;
    }

    public boolean guardarEmpleados(LinkedList<Empleado> listaEmpleados) {
        boolean g = false;
        
        try 
        {
            String NombreArchivoEstudiantes = "listaEmpleados.txt";
            PrintWriter  salida  =  new  PrintWriter( 
                    new BufferedWriter( new FileWriter( NombreArchivoEstudiantes ) ) ) ;

            System.out.println("Se ingresarán los datos al archivo" );
            String linea;
            
            for (Empleado dato: listaEmpleados)
            {
                linea = dato.getNombre()+"--"+
                        dato.getDireccion()+"--"+
                        dato.getEdad()+"--"+
                        dato.getCodigoEmpleado()+"--"+
                        dato.getDepartamento();
                
                salida.println(linea);
            }
            salida.close();
            System.out.println("\n\n Archivo cerrado" ); 
            g=true;
       } catch(IOException  e ) { 

           e.printStackTrace() ; 

            
        }          
      

        return g;

    }

    public boolean recuperarEmpleados(LinkedList<Empleado> listaEmpleados) {
        
        boolean r=false;
        try 
        {
            String NombreArchivoEstudiantes = "listaEmpleados.txt";
            
            BufferedReader  entrada  =  new  BufferedReader( 
                new  FileReader(NombreArchivoEstudiantes) ) ;
            
            System.out.println("Se leeran los datos del archivo" );
  
            String[] datos;
            String linea;
            String nombre;
            String direccion;
            String edad;
            String codigoEmpleado;
            String departamento;
            
            listaEmpleados.clear();
            
            while( ( linea = entrada.readLine() ) != null )
            {
                
                datos = linea.split("--");
                
                nombre =datos[0];
               direccion= datos[1];
               edad = datos [2];
               codigoEmpleado= datos[3];
               departamento = datos[4];
               
          
                listaEmpleados.add(new Empleado(codigoEmpleado, departamento, nombre, direccion, edad));
            }
            
            entrada.close();
            System.out.println("\n\n Cerrando archivo" );  
            r=true;
       } catch( java.io.IOException  e ) { 
           // Se ´puede personalizar el mensaje de error           
           e.printStackTrace() ; 
       }
        
            return r;

    }

    public boolean crearFileXML(LinkedList<Empleado> listaEmpleados) {
        try{
            Element company= new Element("company");
            Document doc= new Document(company);
            
            for (int i = 0; i < listaEmpleados.size(); i++) {
                Element empleado= new Element ("Empleado");
            empleado.addContent(new Element("Nombre").setText(listaEmpleados.get(i).getNombre()));
            }
            
        }
    }

}
