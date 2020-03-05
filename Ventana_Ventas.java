import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_Ventas extends JFrame implements ActionListener{
    //Pido nombre del cliente, del articulo y cantidad de articulos
    //Calculo precio e importe
    //Recojo fecha
    //Asigno id a la venta

    private JFrame mainFrame;

    private JTextField txtCliente;
    private JTextField txtArticulo;
    private JTextField txtCantidad;

    public Ventana_Ventas(){
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Iniciar_Ventana();
    }

    private void Iniciar_Ventana(){

        mainFrame = new JFrame();

        JLabel lblCliente = new JLabel("Inserte el nombre del cliente");
        txtCliente = new JTextField();

        JLabel lblArticulo = new JLabel("Inserte los articulos que se van a vender");
        txtArticulo = new JTextField();

        JLabel lblCantidad = new JLabel("Inserte la cantidad de articulos que se van a vender");
        txtCantidad = new JTextField();

        JButton btnListo = new JButton("Listo");
        btnListo.addActionListener(this);

        mainFrame.add(lblCliente);
        mainFrame.add(txtCliente);
        mainFrame.add(lblArticulo);
        mainFrame.add(txtArticulo);
        mainFrame.add(lblCantidad);
        mainFrame.add(txtCantidad);
        mainFrame.add(btnListo);

        mainFrame.setLayout(new GridLayout(4, 2));

        mainFrame.setSize(500, 275);
        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cliente = txtCliente.getText();
        String articulo = txtArticulo.getText();
        String cantidad = txtCantidad.getText();
        //JOptionPane.showMessageDialog(this, "Hola " + nombre + ".");
    }

}
