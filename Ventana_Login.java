import javax.swing.*;
import java.awt.event.*;

public class Ventana_Login extends JFrame implements ActionListener {

    private JFrame mainFrame;
    private JTextField txtNombre;
    private JTextField txtPasswd;

    public Ventana_Login(){
        Iniciar_Ventana();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void Iniciar_Ventana(){

        mainFrame = new JFrame();
        
        JLabel lblNombre = new JLabel("Usuario");
        lblNombre.setBounds(25, 25, 100, 30);
        txtNombre = new JTextField();
        txtNombre.setBounds(50, 50, 250, 30);

        JLabel lblPasswd = new JLabel("Passwd");
        lblPasswd.setBounds(25, 100, 100, 30);
        txtPasswd = new JPasswordField();
        txtPasswd.setBounds(50, 125, 250, 30);

        JButton btnListo = new JButton("Listo");
        btnListo.setBounds(100, 175, 150, 45);

        btnListo.addActionListener(this);

        mainFrame.setLayout(null);

        mainFrame.add(lblNombre);
        mainFrame.add(lblPasswd);
        mainFrame.add(txtNombre);
        mainFrame.add(txtPasswd);
        mainFrame.add(btnListo);

        mainFrame.setSize(400, 300);
        mainFrame.setTitle("El Stim - Inicio");
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Listo"){
            String Name = txtNombre.getText();
            String Pass = txtPasswd.getText();

            if (Nucleo.TestConnection(Name, Pass)){
                mainFrame.dispose();
                Nucleo.Carga_Datos();
                Nucleo.Gen_Window();
            } else {
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contrasenha incorrectos");
            }
        }

    }

}