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

    public static void main(String[] args) {
        Execute_Query("");

        ResultSet Proveedores = Execute_Query("SELECT * FROM `proveedor`");

        try {
            while (Proveedores.next()) {
                int id = Proveedores.getInt("id_proveedor");
                String nombre = Proveedores.getString("nombre");
                String rfc = Proveedores.getString("rfc");
                String telefono = Proveedores.getString("telefono");
                String correo = Proveedores.getString("correo");
                boolean activo = Proveedores.getBoolean("activo");

                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", id, nombre, rfc, telefono, correo, activo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Ventana_Principal V = new Ventana_Principal();
    }

    public void reg_proveedor(int i_id, String i_nombre, String i_rfc, String i_telefono, String i_correo, boolean i_activo){

    }

    public void Guarda_Proveedor(Proveedor temp_prov){

    }
}