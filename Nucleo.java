import java.util.*;
import java.sql.*;


class Nucleo{
    
    public static List<Proveedor> lst_Proveedores = new ArrayList<Proveedor>();
    private static Connection con = null;
    
    private static void Conecta_BD(String usuario, String clave){
        //String url1 = "jdbc:mysql://localhost:3306/pventa?user=" + usuario + "&pasword=" + clave;
        try {
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/pventa";
            Class.forName(myDriver);
            con = DriverManager.getConnection(myUrl, "root", "");
            //con = DriverManager.getConnection(url1);
            if (con != null) {
                System.out.println("Conexión 1: Conexión a mibase satisfacoria");
            }
        } catch (Exception e) {
            System.out.println("Sin conexion");
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            // create a java mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/pventa";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            // your prepstatements goes here...
            
            conn.close();
            System.err.println("Conectado");
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        Ventana_Principal V = new Ventana_Principal();
    }

    public void reg_proveedor(int i_id, String i_nombre, String i_rfc, String i_telefono, String i_correo, boolean i_activo){

    }

    public void Guarda_Proveedor(Proveedor temp_prov){

    }
}