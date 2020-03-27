import javax.swing.*;

import java.awt.event.*;
import java.text.*;
import java.util.*;

public class Ventana_Compras extends JFrame implements ActionListener,KeyListener {
    // Pido nombre del cliente, del articulo y cantidad de articulos
    // Calculo precio e importe
    // Recojo fecha
    // Asigno id a la venta

    private boolean Nuevo_Dato = false;

    private JFrame mainFrame;

    private JComboBox cmbProveedor;
    private JComboBox cmbArticulo;

    private JTextField txtCantidad;
    private JTextField txtPrecio;

    private JLabel lblPrecio;

    private String game_Array[] = new String[Nucleo.lst_Articulos.size()];
    private String name_Array[] = new String[Nucleo.lst_Proveedores.size()];
    
    private int ID_game_Array[] = new int[Nucleo.lst_Articulos.size()];
    private int ID_name_Array[] = new int[Nucleo.lst_Proveedores.size()];
    
    public Ventana_Compras() {
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Iniciar_Ventana();
    }

    private void Iniciar_Ventana() {

        mainFrame = new JFrame();

        for (int i = 0; i < Nucleo.lst_Proveedores.size(); i++) {
            name_Array[i] = Nucleo.lst_Proveedores.get(i).nombre;
            ID_name_Array[i] = Nucleo.lst_Proveedores.get(i).id_proveedor;
        }

        JLabel lblProveedor = new JLabel("Proveedor");
        cmbProveedor = new JComboBox(name_Array);
        lblProveedor.setBounds(25, 25, 100, 30);
        cmbProveedor.setBounds(50, 50, 250, 30);
        
        for (int i = 0; i < Nucleo.lst_Articulos.size(); i++) {
            game_Array[i] = Nucleo.lst_Articulos.get(i).descripcion;
            ID_game_Array[i] = Nucleo.lst_Articulos.get(i).id_articulo;
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

        //txtCantidad.addKeyListener(this);
        
        lblPrecio = new JLabel("Precio");
        txtPrecio = new JTextField();
        lblPrecio.setBounds(25, 250, 100, 30);
        txtPrecio.setBounds(50, 275, 250, 30);

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnListo = new JButton("Listo");
        btnListo.setBounds(100, 350, 150, 45);
        btnCancelar.setBounds(100, 400, 150, 45);

        mainFrame.add(lblProveedor);
        mainFrame.add(cmbProveedor);
        mainFrame.add(cmbArticulo);
        mainFrame.add(lblArticulo);
        mainFrame.add(btnAgregar);
        mainFrame.add(lblCantidad);
        mainFrame.add(txtCantidad);
        mainFrame.add(lblPrecio);
        mainFrame.add(txtPrecio);
        mainFrame.add(btnListo);
        mainFrame.add(btnCancelar);

        txtPrecio.setVisible(false);
        lblPrecio.setVisible(false);
        
        mainFrame.setLayout(null);
        
        btnAgregar.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnListo.addActionListener(this);
        
        mainFrame.setSize(375, 500);
        mainFrame.setTitle("Compras");
        mainFrame.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "+") {
            String response = JOptionPane.showInputDialog(null, "Nuevo titulo a adquirir:", "Comprar juego nuevo",
            JOptionPane.QUESTION_MESSAGE);
            //System.out.println("Recibo \"" + response + '\"');
            boolean Repite = false;
            for (int i = 0 ; i < cmbArticulo.getItemCount() ; i++){
                
                //System.out.println("comparo \"" + response + "\" con \"" + cmbArticulo.getItemAt(i) + "\"");
                if (response.equals(cmbArticulo.getItemAt(i))) {
                    
                    //System.out.println("Encontrado");
                    Repite = true;
                    JOptionPane.showMessageDialog(null, response + " ya habia sido registrado.");
                    break;
                }
            }

            if (!Repite) {
                cmbArticulo.addItem(response);
                cmbArticulo.setSelectedItem(response);
                cmbArticulo.disable();
                Nuevo_Dato = true;
                txtPrecio.setVisible(true);
                lblPrecio.setVisible(true);
            }
            
        } else if (e.getActionCommand() == "Listo"){
            String sql = "";

            String Descripcion = (String)cmbArticulo.getSelectedItem();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double Precio = 0.00;
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();

            String fecha = dateFormat.format(date);
            int ID_Prov = ID_name_Array[cmbProveedor.getSelectedIndex()];
            if(!txtPrecio.getText().equals("")){
                Precio = Double.parseDouble(txtPrecio.getText());
            }
            
            if (Nuevo_Dato){
                sql = String.format(
                        "INSERT INTO `articulo` (`descripcion`, `precio`, `existencia`) VALUES ('%s', '%.2f', '%d')",
                        Descripcion, Precio, cantidad);

                System.out.println(sql);

                sql = String.format(
                        "INSERT INTO `compra` (`fecha`, `id_proveedor`, `id_articulo`, `cantidad`) VALUES ('%s', '%d', '%d', '%d')",
                        fecha, ID_Prov);
                    } else{

                        int i = 0;

                        for(i = 0; i < Nucleo.lst_Articulos.size() ; i++){
                            if(Nucleo.lst_Articulos.get(i).descripcion.equals(Descripcion)){
                                Nucleo.lst_Articulos.get(i).Surtir(cantidad);
                                break;
                            }
                        }

                        Compra temp_compra = new Compra(Nucleo.lst_Compras.size()
                                + 1, ID_Prov, Nucleo.lst_Articulos.get(i).id_articulo, cantidad, fecha);

                        temp_compra.Guarda_SQL();
                        Nucleo.lst_Compras.add(temp_compra);

                        JOptionPane.showMessageDialog(null, Descripcion + " fue abastecido exitosamente.");

                    }
                }
            }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println(e.getKeyChar());
        //System.out.println(e.getKeyCode());

        
        if (e.getKeyChar() != '.' && e.getKeyChar() < '0' || e.getKeyChar() > '9') {
            // System.out.println("No Nonber");
            txtCantidad.setText(txtCantidad.getText());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {  
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
