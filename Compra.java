public class Compra{
    int id_compra, id_proveedor, id_articulo, cantidad;
    String fecha;

    public Compra(int i_id_compra, int i_id_proveedor, int i_id_articulo, int i_cantidad, String i_fecha){
        id_compra = i_id_compra;
        id_proveedor = i_id_proveedor;
        id_articulo = i_id_articulo;
        cantidad = i_cantidad;
        fecha = i_fecha;
    }

    public void Guarda_SQL(){
        String sql = String.format(
            "INSERT INTO `compra` (`fecha`, `id_proveedor`, `id_articulo`, `cantidad`) VALUES ('%s', '%d', '%d', '%d')",
            fecha, id_proveedor, id_articulo, cantidad);

        //System.out.println(sql);

        Nucleo.Execute_Query(sql);

    }
}
