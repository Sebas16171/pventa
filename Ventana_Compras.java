import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_Compras extends JFrame implements ActionListener {
    // Pido nombre del cliente, del articulo y cantidad de articulos
    // Calculo precio e importe
    // Recojo fecha
    // Asigno id a la venta

    private JFrame mainFrame;

    private JComboBox cmbProveedor;
    private JComboBox cmbArticulo;

    private JTextField txtCantidad;

    public Ventana_Compras() {
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Iniciar_Ventana();
    }

    private void Iniciar_Ventana() {

        mainFrame = new JFrame();

        String name_Array[] = new String[Nucleo.lst_Proveedores.size()];
        for (int i = 0; i < Nucleo.lst_Proveedores.size(); i++) {
            name_Array[i] = Nucleo.lst_Proveedores.get(i).nombre;
        }

        JLabel lblProveedor = new JLabel("Proveedor");
        cmbProveedor = new JComboBox(name_Array);
        lblProveedor.setBounds(25, 25, 100, 30);
        cmbProveedor.setBounds(50, 50, 250, 30);
        
        String game_Array[] = new String[Nucleo.lst_Articulos.size()];
        for (int i = 0; i < Nucleo.lst_Articulos.size(); i++) {
            game_Array[i] = Nucleo.lst_Articulos.get(i).descripcion;
        }
        
        JLabel lblArticulo = new JLabel("Articulo");
        //txtArticulo = new JTextField();
        cmbArticulo = new JComboBox(game_Array);
        lblArticulo.setBounds(25, 100, 100, 30);
        cmbArticulo.setBounds(50, 125, 209, 30);
        JButton btnAgregar = new JButton("+");
        btnAgregar.setBounds(259, 125, 41, 30);

        JLabel lblCantidad = new JLabel("Cantidad");
        txtCantidad = new JTextField();
        lblCantidad.setBounds(25, 175, 100, 30);
        txtCantidad.setBounds(50, 200, 250, 30);

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnListo = new JButton("Listo");
        btnListo.setBounds(100, 250, 150, 45);
        btnCancelar.setBounds(100, 300, 150, 45);

        mainFrame.add(lblProveedor);
        mainFrame.add(cmbProveedor);
        mainFrame.add(cmbArticulo);
        mainFrame.add(lblArticulo);
        mainFrame.add(btnAgregar);
        mainFrame.add(lblCantidad);
        mainFrame.add(txtCantidad);
        mainFrame.add(btnListo);
        mainFrame.add(btnCancelar);

        mainFrame.setLayout(null);

        mainFrame.setSize(375, 400);
        mainFrame.setTitle("Compras");
        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //String cliente = combo.getText();
        //String articulo = txtArticulo.getText();
        //String cantidad = txtCantidad.getText();
        // JOptionPane.showMessageDialog(this, "Hola " + nombre + ".");
    }

}
