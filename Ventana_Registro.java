import javax.swing.*;

import java.awt.event.*;


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
        mainFrame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                Nucleo.Gen_Window();
            }
        });
    }

    private void Iniciar_Ventana(){

        mainFrame = new JFrame();
        
        JLabel lblNombre = new JLabel("Nombre");
        txtNombre = new JTextField();
        lblNombre.setBounds(25, 25, 100, 30);
        txtNombre.setBounds(50, 50, 250, 30);

        JLabel lblRFC = new JLabel("RFC");
        txtRFC = new JTextField();
        lblRFC.setBounds(25, 100, 100, 30);
        txtRFC.setBounds(50, 125, 250, 30);

        JLabel lblCorreo = new JLabel("Correo");
        txtCorreo = new JTextField();
        lblCorreo.setBounds(25, 175, 100, 30);
        txtCorreo.setBounds(50, 200, 250, 30);

        JLabel lblTelefono = new JLabel("Telefono");
        txtTelefono = new JTextField();
        lblTelefono.setBounds(25, 250, 100, 30);
        txtTelefono.setBounds(50, 275, 250, 30);

        rdCliente = new JRadioButton("Cliente", true);
        rdCliente.setBounds(400, 50, 100, 30);
        rdProveedor = new JRadioButton("Proveedor", false);
        rdProveedor.setBounds(400, 75, 100, 30);

        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(rdCliente);
        grupo1.add(rdProveedor);

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnListo = new JButton("Listo");
        btnListo.setBounds(375, 200, 150, 45);
        btnCancelar.setBounds(375, 250, 150, 45);

        btnCancelar.addActionListener(this);
        btnListo.addActionListener(this);
        
        mainFrame.setLayout(null);

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

        mainFrame.setSize(600, 400);
        mainFrame.setTitle("Registrar");
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Listo"){

            String nombre = txtNombre.getText();
            String rfc = txtRFC.getText();
            String correo = txtCorreo.getText();
            String telefono = txtTelefono.getText();

            if (txtNombre.getText().isEmpty() || txtRFC.getText().isEmpty()  || txtCorreo.getText().isEmpty()  || txtTelefono.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null, "No se puede dejar ningun campo vacio.", "Error", 
                        JOptionPane.ERROR_MESSAGE);
            } else if (rdProveedor.isSelected() == true){
                try {
                    //                                      ID  Nombre  RFC Telefono    Correo  Activo
                    Proveedor temp_proveedor = new Proveedor(0, nombre, rfc, telefono, correo, true);
                    temp_proveedor.Guarda_SQL();
                    Nucleo.lst_Proveedores.add(temp_proveedor);    
                    JOptionPane.showMessageDialog(null, nombre + " fue registrado exitosamente.");
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Error en el registro.");
                }
                
                
            }else if (rdCliente.isSelected() == true){
                try {
                    Cliente temp_cliente = new Cliente(0, nombre, rfc, telefono, correo, true);
                    temp_cliente.Guarda_SQL();
                    Nucleo.lst_Clientes.add(temp_cliente);
                    JOptionPane.showMessageDialog(null, nombre + " fue registrado exitosamente.");
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Error en el registro.");
                }
            }

        } else if (e.getActionCommand() == "Cancelar"){
                    mainFrame.dispose();
                    Nucleo.Gen_Window();
            }
    }

}