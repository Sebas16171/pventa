import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_Principal extends JFrame implements ActionListener {
    // Pido nombre del cliente, del articulo y cantidad de articulos
    // Calculo precio e importe
    // Recojo fecha
    // Asigno id a la venta

    private JFrame mainFrame;

    public Ventana_Principal() {
        Iniciar_Ventana();
    }

    private void Iniciar_Ventana() {

        mainFrame = new JFrame();

        ImageIcon icoComprar = new ImageIcon("Images/btnComprar.png");
        ImageIcon icoVender = new ImageIcon("Images/btnVender.png");
        ImageIcon icoRegistrar = new ImageIcon("Images/btnRegistrar.png");

        JButton btnComprar = new JButton(icoComprar);
        btnComprar.setBounds(5, 25, 75, 75);
        btnComprar.setActionCommand("Comprar");;
        JButton btnVender = new JButton(icoVender);
        btnVender.setBounds(5, 105, 75, 75);
        btnVender.setActionCommand("Vender");;
        JButton btnRegistrar = new JButton(icoRegistrar);
        btnRegistrar.setBounds(5, 185, 75, 75);
        btnRegistrar.setActionCommand("Registrar");

        Nucleo.Execute_Query("SELECT * FROM proveedor");

        JList lstProveedores = new JList();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnComprar.addActionListener(this);
        btnVender.addActionListener(this);
        btnRegistrar.addActionListener(this);

        mainFrame.add(btnComprar);
        mainFrame.add(btnVender);
        mainFrame.add(btnRegistrar);

        mainFrame.setLayout(null);

        mainFrame.setSize(500, 325);
        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.print(e.getActionCommand());
        if (e.getActionCommand() == "Comprar") {
            Ventana_Ventas VC = new Ventana_Ventas();
        } else if (e.getActionCommand() == "Vender"){
            Ventana_Ventas VV = new Ventana_Ventas();
        } else if (e.getActionCommand() == "Registrar"){
           Ventana_Registro VR = new Ventana_Registro();
        }
    }
    
}
