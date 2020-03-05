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

        JButton btnComprar = new JButton("Comprar productos");
        JButton btnVender = new JButton("Vender productos");
        JButton btnRegistrar = new JButton("Registrar");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnComprar.addActionListener(this);
        btnVender.addActionListener(this);
        btnRegistrar.addActionListener(this);

        mainFrame.add(btnComprar);
        mainFrame.add(btnVender);
        mainFrame.add(btnRegistrar);

        mainFrame.setLayout(new GridLayout(3,1));

        mainFrame.setSize(500, 275);
        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.print(e.getActionCommand());
        if (e.getActionCommand() == "Comprar productos") {
            Ventana_Ventas VC = new Ventana_Ventas();
        } else if (e.getActionCommand() == "Vender productos"){
            Ventana_Ventas VV = new Ventana_Ventas();
        } else if (e.getActionCommand() == "Registrar"){
           Ventana_Registro VR = new Ventana_Registro();
        }
    }
    
}
