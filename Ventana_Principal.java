import javax.swing.*;
import java.awt.event.*;

public class Ventana_Principal extends JFrame implements ActionListener {
    // Pido nombre del cliente, del articulo y cantidad de articulos
    // Calculo precio e importe
    // Recojo fecha
    // Asigno id a la venta

    private JFrame mainFrame;

    public Ventana_Principal() {
        Iniciar_Ventana();
        mainFrame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                Nucleo.Gen_Window();
            }
        });
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

        String name_Array[] = new String[Nucleo.lst_Proveedores.size()];
        for (int i = 0 ; i < Nucleo.lst_Proveedores.size() ; i++){
            name_Array[i] = Nucleo.lst_Proveedores.get(i).nombre;
        }

        JList lstProveedores = new JList(name_Array);
        lstProveedores.setBounds(300, 45, 120, 220);

        lstProveedores.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    Ventana_Consultas V_Con = new Ventana_Consultas(Nucleo.lst_Proveedores, false);
                    mainFrame.dispose();
                }
            }
        });

        String Nombres_Clientes[] = new String[Nucleo.lst_Clientes.size()];
        for (int i = 0 ; i < Nucleo.lst_Clientes.size() ; i++){
            Nombres_Clientes[i] = Nucleo.lst_Clientes.get(i).nombre;
        }

        String Ventas[] = new String[Nucleo.lst_Ventas.size()];
        for (int i = 0 ; i < Nucleo.lst_Ventas.size() ; i++){
            //Ventas[i] = Nucleo.lst_Ventas.get(i)
        }

        JList lstClientes = new JList(Nombres_Clientes);
        lstClientes.setBounds(430, 45, 120, 220);

        lstClientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    Ventana_Consultas V_Con = new Ventana_Consultas(Nucleo.lst_Clientes);
                    mainFrame.dispose();
                }
            }
        });

        JLabel lblProveedores = new JLabel("Proveedores");
        JLabel lblClientes = new JLabel("Clientes");

        lblProveedores.setBounds(300, 25, 100, 20);
        lblClientes.setBounds(430, 25, 100, 20);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnComprar.addActionListener(this);
        btnVender.addActionListener(this);
        btnRegistrar.addActionListener(this);

        mainFrame.add(btnComprar);
        mainFrame.add(btnVender);
        mainFrame.add(btnRegistrar);
        mainFrame.add(lstProveedores);
        mainFrame.add(lstClientes);
        mainFrame.add(lblProveedores);
        mainFrame.add(lblClientes);

        mainFrame.setLayout(null);

        mainFrame.setSize(600, 325);
        mainFrame.setTitle("El Stim");
        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.print(e.getActionCommand());
        if (e.getActionCommand() == "Comprar") {
            Ventana_Compras VC = new Ventana_Compras();
            mainFrame.dispose();
        } else if (e.getActionCommand() == "Vender"){
            Ventana_Ventas VV = new Ventana_Ventas();
            mainFrame.dispose();
        } else if (e.getActionCommand() == "Registrar"){
           Ventana_Registro VR = new Ventana_Registro();
           mainFrame.dispose();
        }
    }
    
}
