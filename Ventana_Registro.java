import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ventana_Registro extends JFrame implements ActionListener{

    private JFrame mainFrame;

    private JTextField txtNombre;
    private JTextField txtRFC;
    private JTextField txtCorreo;
    private JTextField txtTelefono;

    private JRadioButton rdCliente;
    private JRadioButton rdProveedor;

    public Ventana_Registro(){
        Iniciar_Ventana();
    }

    private void Iniciar_Ventana(){

        mainFrame = new JFrame();
        
        JLabel lblNombre = new JLabel("Nombre");
        txtNombre = new JTextField();

        JLabel lblRFC = new JLabel("RFC");
        txtRFC = new JTextField();

        JLabel lblCorreo = new JLabel("Correo");
        txtCorreo = new JTextField();

        JLabel lblTelefono = new JLabel("Telefono");
        txtTelefono = new JTextField();

        rdCliente = new JRadioButton("Cliente", true);
        rdProveedor = new JRadioButton("Proveedor", false);

        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(rdCliente);
        grupo1.add(rdProveedor);

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnListo = new JButton("Listo");

        btnCancelar.addActionListener(this);
        btnListo.addActionListener(this);

        mainFrame.add(lblNombre);
        mainFrame.add(txtNombre);
        mainFrame.add(lblRFC);
        mainFrame.add(txtRFC);
        mainFrame.add(lblCorreo);
        mainFrame.add(txtCorreo);
        mainFrame.add(lblTelefono);
        mainFrame.add(txtTelefono);
        mainFrame.add(rdCliente);
        mainFrame.add(rdProveedor);
        mainFrame.add(btnListo);
        mainFrame.add(btnCancelar);

        mainFrame.setLayout(new GridLayout(3, 4));

        mainFrame.setSize(500, 275);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Listo"){
            String nombre = txtNombre.getText();
            String rfc = txtRFC.getText();
            String correo = txtCorreo.getText();
            String telefono = txtTelefono.getText();

            boolean Proveedor;
            if (rdProveedor.isSelected() == true){
                Proveedor temp_proveedor = new Proveedor(0, nombre, rfc, telefono, correo, true);
                
                
            }else if (rdCliente.isSelected() == true){
                Proveedor = false;
            }

        } else if (e.getActionCommand() == "Cancelar"){}
    }

}