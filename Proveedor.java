public class Proveedor{
    int id_proveedor;
    String nombre, rfc, telefono, correo;
    boolean activo;

    public Proveedor(int i_id, String i_nombre, String i_rfc, String i_telefono, String i_correo, boolean i_activo){
        id_proveedor = i_id;
        nombre = i_nombre;
        rfc = i_rfc;
        telefono = i_telefono;
        correo = i_correo; 
        activo = i_activo;
    }

    public void Guarda_SQL(){
        String sql = "INSERT INTO `proveedor` (`nombre`, `rfc`, `telefono`, `correo`, `activo`)"+
        " VALUES ('%s', '%s', '%s', '%2d', '%sS')", nombre, rfc, telefono, correo, activo;

        System.out.println(sql);
        
    }

}