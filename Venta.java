import java.sql.*;

public class Venta{
    private int id_venta, id_cliente, id_articulo, cantidad;
    double precio, importe;
    private String fecha;

    public Venta(int i_id_venta, int i_id_cliente, int i_id_articulo, int i_cantidad, double i_precio, String i_fecha){
        id_venta = i_id_venta;
        id_cliente = i_id_cliente;
        id_articulo = i_id_articulo;
        cantidad = i_cantidad;
        precio = i_precio;
        importe = i_precio * i_cantidad;
        fecha = i_fecha;
    }

    public void GuardaSQL(){
        String sql = String.format(
            "INSERT INTO `venta` (`fecha`, `id_cliente`, `id_articulo`, `cantidad`, `precio`, `importe`) VALUES ('%s', '%d', '%d', '%d', '%.2f', '%.2f')",
            fecha, id_cliente, id_articulo, cantidad, precio, importe);

            System.out.println(sql);
    }
}
