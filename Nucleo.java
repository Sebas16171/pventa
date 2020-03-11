import java.util.*;
import java.sql.*;

class Nucleo{

    public static List<Proveedor> lst_Proveedores = new ArrayList<Proveedor>();
    private static Connection conexion1 = null;

    private static void Conecta_BD(String usuario, String clave){
        String url1 = "jdbc:mysql://localhost:3306/pventa?user=" + usuario + "&pasword=" + clave;

        conexion1 = DriverManager.getConnection(url1);
        if (conexion1 != null) {
            System.out.println("Conexión 1: Conexión a mibase satisfacoria");
        }
    }

    public static void main(String[] args) {
        Conecta_BD("Sebas", "1234");
        Ventana_Principal V = new Ventana_Principal();
    }

    public void reg_proveedor(int i_id, String i_nombre, String i_rfc, String i_telefono, String i_correo, boolean i_activo){

    }

    public void Guarda_Proveedor(Proveedor temp_prov){

    }
}