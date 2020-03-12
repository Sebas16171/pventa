public class Cliente{
    int id_cliente;
    String nombre, rfc, correo, telefono;
    boolean activo;

    public Cliente(int i_id, String i_nombre, String i_rfc, String i_telefono, String i_correo, boolean i_activo){
        id_cliente = i_id;
        nombre = i_nombre;
        rfc = i_rfc;
        telefono = i_telefono;
        correo = i_correo; 
        activo = i_activo;
    }

    public void Guarda_SQL() {

        String SQL_Bool = "";

        if (activo == true) {
            SQL_Bool = "1";
        } else {
            SQL_Bool = "0";
        }

        String sql = String.format("INSERT INTO `cliente` (`nombre`, `rfc`, `telefono`, `correo`, `activo`)"
                + " VALUES ('%s', '%s', '%s', '%s', '%s')", nombre, rfc, telefono, correo, SQL_Bool);

        System.out.println(sql);

        Nucleo.Execute_Query(sql);

    }

}