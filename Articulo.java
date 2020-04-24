public class Articulo{
    int id_articulo, existencia;
    double precio;
    String descripcion;

    public Articulo(int i_id, String i_descripcion, double i_precio, int i_existencia){
        id_articulo = i_id;
        descripcion = i_descripcion;
        precio = i_precio;
        existencia = i_existencia;

    }

    public void GuardaNuevo(){
        String sql = String.format("INSERT INTO `articulo` (`descripcion`, `precio`, `existencia`) VALUES ('%s', '%.2f', '%d')", descripcion, precio, existencia);

        System.out.println(sql);
        Nucleo.Execute_Query(sql);
    }

    public void Surtir(int Cantidad){
        existencia = existencia + Cantidad;

        String sql = String.format("UPDATE `articulo` SET `existencia` = '%d' WHERE `articulo`.`id_articulo` = %d",
                existencia, id_articulo);

        System.out.println(sql);
        Nucleo.Execute_Query(sql);
    }

    public void Vender(int Cantidad) {
        existencia = existencia - Cantidad;

        String sql = String.format("UPDATE `articulo` SET `existencia` = '%d' WHERE `articulo`.`id_articulo` = %d",
                existencia, id_articulo);

        //System.out.println(sql);
        Nucleo.Execute_Query(sql);
    }

}