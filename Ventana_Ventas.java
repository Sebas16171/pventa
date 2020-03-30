import javax.swing.*;

import java.awt.event.*;
import java.text.*;
import java.util.*;

public class Ventana_Ventas extends JFrame implements ActionListener,KeyListener{
    //Pido nombre del cliente, del articulo y cantidad de articulos
    //Calculo precio e importe
    //Recojo fecha
    //Asigno id a la venta

    private JFrame mainFrame;

    private String name_Array[] = new String[Nucleo.lst_Proveedores.size()];
    private String game_Array[] = new String[Nucleo.lst_Articulos.size()];

    private JComboBox cmbCliente;
    private JComboBox cmbArticulo;

    private JTextField txtCantidad;

    public Ventana_Ventas(){
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Iniciar_Ventana();
    }

    private void Iniciar_Ventana(){

        mainFrame = new JFrame();

        for (int i = 0; i < Nucleo.lst_Clientes.size(); i++) {
            name_Array[i] = Nucleo.lst_Clientes.get(i).nombre;
        }

        JLabel lblCliente = new JLabel("Cliente");
        cmbCliente = new JComboBox(name_Array);
        lblCliente.setBounds(25, 25, 100, 30);
        cmbCliente.setBounds(50, 50, 250, 30);

        for (int i = 0; i < Nucleo.lst_Articulos.size(); i++) {
            game_Array[i] = Nucleo.lst_Articulos.get(i).descripcion;
        }

        JLabel lblArticulo = new JLabel("Articulo");
        cmbArticulo = new JComboBox(game_Array);
        lblArticulo.setBounds(25, 100, 100, 30);
        cmbArticulo.setBounds(50, 125, 250, 30);

        JLabel lblCantidad = new JLabel("Cantidad");
        txtCantidad = new JTextField();
        lblCantidad.setBounds(25, 175, 100, 30);
        txtCantidad.setBounds(50, 200, 250, 30);

        txtCantidad.addKeyListener(this);

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnListo = new JButton("Listo");
        btnListo.setBounds(100, 250, 150, 45);
        btnCancelar.setBounds(100, 300, 150, 45);
        
        btnCancelar.addActionListener(this);
        btnListo.addActionListener(this);

        mainFrame.add(lblCliente);
        mainFrame.add(cmbCliente);
        mainFrame.add(lblArticulo);
        mainFrame.add(cmbArticulo);
        mainFrame.add(lblCantidad);
        mainFrame.add(txtCantidad);
        mainFrame.add(btnListo);
        mainFrame.add(btnCancelar);

        mainFrame.setLayout(null);

        mainFrame.setSize(375, 400);
        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Listo"){

            int ID_Venta = Nucleo.lst_Ventas.size() + 1;
            int ID_Cliente = cmbCliente.getSelectedIndex() + 1;
            int ID_Articulo = cmbArticulo.getSelectedIndex() + 1;
            int Cantidad = Integer.parseInt(txtCantidad.getText());
            double Precio = Nucleo.lst_Articulos.get(cmbArticulo.getSelectedIndex()).precio;

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String Fecha = dateFormat.format(date);

            Venta temp_venta = new Venta(ID_Venta, ID_Cliente, ID_Articulo, Cantidad, Precio, Fecha);
            temp_venta.GuardaSQL();

        }else if (e.getActionCommand() == "Cancelar"){
            mainFrame.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() < '0' || e.getKeyChar() > '9') {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
