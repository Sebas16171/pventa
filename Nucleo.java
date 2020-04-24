import java.util.*;
import java.sql.*;

class Nucleo {

    //Listas con los datos de la BD
    public static List<Proveedor> lst_Proveedores = new ArrayList<Proveedor>();
    public static List<Cliente> lst_Clientes = new ArrayList<Cliente>();
    public static List<Articulo> lst_Articulos = new ArrayList<Articulo>();
    public static List<Compra> lst_Compras = new ArrayList<Compra>();
    public static List<Venta> lst_Ventas = new ArrayList<Venta>();

    public static String Usuario, Clave;

    //Conexion
    private static Connection con = null;

    public static boolean TestConnection(String name, String passwd){
        try {
            String myDriver = "org.gjt.mm.mysql.Driver"; // Driver
            String myUrl = "jdbc:mysql://localhost/pventa"; // Ubicacion de los datos
            Class.forName(myDriver); // Asigno el driver

            con = DriverManager.getConnection(myUrl, name, passwd);

            Usuario = name;
            Clave = passwd;
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    public static ResultSet Execute_Query(String query) {

        try {
            //Lleno los datos necesarior para la conexion
            String myDriver = "org.gjt.mm.mysql.Driver";    //Driver
            String myUrl = "jdbc:mysql://localhost/pventa"; //Ubicacion de los datos
            Class.forName(myDriver);    //Asigno el driver

            //Inicio la conexion
            con = DriverManager.getConnection(myUrl, Usuario, Clave);

            

            //Si la consulta no esta vacia
            if (query != "") {
                Statement st = con.createStatement();

                //Identifico si la consulta retornara datos o no
                if (query.matches("INSERT INTO.*") || query.matches("UPDATE.*")) {
                    //Insert y Update no retornan datos, por lo que solo debo ejecutar la consulta
                    st.executeUpdate(query);
                    return null;
                } else if (query.matches("SELECT.*")) {
                    //Select me retornara datos de la base, por lo que debo crear una variable de
                    //almacenamiento para esos datos (ResultSet)
                    ResultSet rs = st.executeQuery(query);

                    return rs;  //Retorno los datos que dio la consulta
                }
            }
            //Cierro la conexion
            con.close();
        } catch (Exception e) {
            //En caso de que exista un error, detengo la funcion
            return null;
        }
        return null;
    }

    public static void Carga_Datos(){
        //Ejecuto la consulta para recuperar los registros de proveedores y creo un proveedor temporal
        ResultSet Datos_Consulta = Execute_Query("SELECT * FROM `proveedor`");
        Proveedor temp_Proveedor = null;
        
        try {
            while (Datos_Consulta.next()) { //Mientras haya datos en Datos_Consulta

                //Guardo cada dato del proveedor en una variable 
                int id = Datos_Consulta.getInt("id_proveedor");
                String nombre = Datos_Consulta.getString("nombre");
                String rfc = Datos_Consulta.getString("rfc");
                String telefono = Datos_Consulta.getString("telefono");
                String correo = Datos_Consulta.getString("correo");
                boolean activo = Datos_Consulta.getBoolean("activo");
                
                //Paso todas las variables al proveedor temporal y lo agrego a la lista dentro del programa
                temp_Proveedor = new Proveedor(id, nombre, rfc, telefono, correo, activo);
                lst_Proveedores.add(temp_Proveedor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //Repito el procedimiento de proveedores con los clientes
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
 
                temp_Cliente = new Cliente(id, nombre, rfc, telefono, correo, activo);
                lst_Clientes.add(temp_Cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Datos_Consulta = Execute_Query("SELECT * FROM `articulo`");
        Articulo temp_Articulo = null;

        try {
            while (Datos_Consulta.next()) {
                int id = Datos_Consulta.getInt("id_articulo");
                String descripcion = Datos_Consulta.getString("descripcion");
                double precio = Datos_Consulta.getDouble("precio");
                int existencia = Datos_Consulta.getInt("existencia");

                temp_Articulo = new Articulo(id, descripcion, precio, existencia);
                lst_Articulos.add(temp_Articulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Datos_Consulta = Execute_Query("SELECT * FROM `compra`");
        Compra temp_Compra = null;

        try {
            while(Datos_Consulta.next()){
                int id = Datos_Consulta.getInt("id_venta");
                String fecha = Datos_Consulta.getString("fecha");
                int id_proveedor = Datos_Consulta.getInt("id_proveedor");
                int id_articulo = Datos_Consulta.getInt("id_articulo");
                int cantidad = Datos_Consulta.getInt("cantidad");
                
                temp_Compra = new Compra(id, id_proveedor, id_articulo, cantidad, fecha);
                lst_Compras.add(temp_Compra);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void Gen_Window(){
        Ventana_Principal V = new Ventana_Principal();
    }

    public static void main(String[] args) {
        Ventana_Login VL = new Ventana_Login();
        //Carga_Datos();
        //Gen_Window();
    }

}