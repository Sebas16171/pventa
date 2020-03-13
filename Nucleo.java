import java.util.*;
import java.sql.*;

class Nucleo {

    public static List<Proveedor> lst_Proveedores = new ArrayList<Proveedor>();
    public static List<Cliente> lst_Clientes = new ArrayList<Cliente>();

    private static Connection con = null;

    public static ResultSet Execute_Query(String query) {
        try {
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/pventa";
            Class.forName(myDriver);
            con = DriverManager.getConnection(myUrl, "root", "");

            if (query != "") {
                Statement st = con.createStatement();

                if (query.matches("INSERT INTO.*")) {
                    st.executeUpdate(query);
                    return null;
                } else if (query.matches("SELECT.*")) {
                    ResultSet rs = st.executeQuery(query);
                    return rs;
                }
            }
            con.close();
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public static void Carga_Datos(){
        ResultSet Datos_Consulta = Execute_Query("SELECT * FROM `proveedor`");
        Proveedor temp_Proveedor = null;
        
        try {
            while (Datos_Consulta.next()) {
                int id = Datos_Consulta.getInt("id_proveedor");
                String nombre = Datos_Consulta.getString("nombre");
                String rfc = Datos_Consulta.getString("rfc");
                String telefono = Datos_Consulta.getString("telefono");
                String correo = Datos_Consulta.getString("correo");
                boolean activo = Datos_Consulta.getBoolean("activo");
                
                // print the results
                temp_Proveedor = new Proveedor(id, nombre, rfc, telefono, correo, activo);
                lst_Proveedores.add(temp_Proveedor);
                //System.out.format("%s, %s, %s, %s, %s, %s\n", id, nombre, rfc, telefono, correo, activo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        Datos_Consulta = Execute_Query("SELECT * FROM `cliente`");
        Cliente temp_Cliente = null;
        
        try {
            while (Datos_Consulta.next()) {
                int id = Datos_Consulta.getInt("id_cliente");
                String nombre = Datos_Consulta.getString("nombre");
                String rfc = Datos_Consulta.getString("rfc");
                String correo = Datos_Consulta.getString("correo");
                String telefono = Datos_Consulta.getString("telefono");
                boolean activo = Datos_Consulta.getBoolean("activo");
                
                // print the results
                temp_Cliente = new Cliente(id, nombre, rfc, telefono, correo, activo);
                lst_Clientes.add(temp_Cliente);
                
                //System.out.format("%s, %s, %s, %s, %s, %s\n", id, nombre, rfc, telefono, correo, activo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Carga_Datos();
        Execute_Query("");
        Ventana_Principal V = new Ventana_Principal();
    }

}