import javax.swing.*;

import java.awt.event.*;
import java.text.*;
import java.util.*;

public class Ventana_Consultas {

    private JFrame mainFrame;

    private JTable Tabla;

    private JScrollPane Scroll;

    public Ventana_Consultas(List<Cliente> Datos){
        mainFrame = new JFrame();

        mainFrame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                Nucleo.Gen_Window();
            }
        });

        String[] Encabezado = {"ID", "Nombre", "RFC", "Correo", "Telefono", "Activo"};
        String [][] datos = new String[Datos.size()][10];

        for (int i = 0 ; i < Datos.size() ; i++ ){
            datos[i][0] = String.valueOf(Datos.get(i).id_cliente);
            datos[i][1] = Datos.get(i).nombre;
            datos[i][2] = Datos.get(i).rfc;
            datos[i][3] = Datos.get(i).correo;
            datos[i][4] = Datos.get(i).telefono;
            datos[i][5] = String.valueOf(Datos.get(i).activo);
        }

        Tabla = new JTable(datos, Encabezado);
        Scroll = new JScrollPane(Tabla);
        Scroll.setBounds(25, 25, 500, 400);

        mainFrame.add(Scroll);

        mainFrame.setLayout(null);
        mainFrame.setSize(700, 500);
        mainFrame.setTitle("Consultas");
        mainFrame.setVisible(true);
    }
    
    public Ventana_Consultas(List<Proveedor> Datos, boolean X ){
        mainFrame = new JFrame();

        mainFrame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                Nucleo.Gen_Window();
            }
        });

        String[] Encabezado = {"ID", "Nombre", "RFC", "Correo", "Telefono", "Activo"};
        String [][] datos = new String[Datos.size()][10];

        for (int i = 0 ; i < Datos.size() ; i++ ){
            datos[i][0] = String.valueOf(Datos.get(i).id_proveedor);
            datos[i][1] = Datos.get(i).nombre;
            datos[i][2] = Datos.get(i).rfc;
            datos[i][3] = Datos.get(i).correo;
            datos[i][4] = Datos.get(i).telefono;
            datos[i][5] = String.valueOf(Datos.get(i).activo);
        }

        Tabla = new JTable(datos, Encabezado);
        Scroll = new JScrollPane(Tabla);
        Scroll.setBounds(25, 25, 500, 400);

        mainFrame.add(Scroll);

        mainFrame.setLayout(null);
        mainFrame.setSize(700, 500);
        mainFrame.setTitle("Consultas");
        mainFrame.setVisible(true);
    }

}