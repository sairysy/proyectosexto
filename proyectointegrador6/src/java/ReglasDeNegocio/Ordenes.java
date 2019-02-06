
package ReglasDeNegocio;
import AccesoADatos.*;
import java.sql.*;
import java.util.*;
import java.sql.Time;

public class Ordenes {
  private int ordenid;
  private Proveedores proveedores;
  private Producto producto;
  private int cantidad;
  private double  preciounitario;
  private  String numeroorden;
  private String numerofactura;
  private boolean entregada;
  private Timestamp  fechaentrega;
    public Ordenes() {
    }

    public Ordenes(int ordenid, Proveedores proveedores, Producto producto, int cantidad, double preciounitario, String numeroorden, String numerofactura, boolean entregada, Timestamp fechaentrega) {
        this.ordenid = ordenid;
        this.proveedores = proveedores;
        this.producto = producto;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
        this.numeroorden = numeroorden;
        this.numerofactura = numerofactura;
        this.entregada = entregada;
        this.fechaentrega = fechaentrega;
    }

    public int getOrdenid() {
        return ordenid;
    }

    public void setOrdenid(int ordenid) {
        this.ordenid = ordenid;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public String getNumeroorden() {
        return numeroorden;
    }

    public void setNumeroorden(String numeroorden) {
        this.numeroorden = numeroorden;
    }

    public String getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(String numerofactura) {
        this.numerofactura = numerofactura;
    }

    public boolean getEntregada() {
        return entregada;
    }

    public void setEntregada(boolean entregada) {
        this.entregada = entregada;
    }

    public Timestamp getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Timestamp fechaentrega) {
        this.fechaentrega = fechaentrega;
    }


   
    
    
    public static ArrayList<Ordenes> ordenes_buscartodos() throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
        ArrayList<Ordenes> lista= new ArrayList<Ordenes>();
          Ordenes obj= new Ordenes();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;

      try {
          //declaro mi sql
          String sql= "select * from public.ordenes_buscartodos()";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Ordenes();
              obj.setOrdenid(rs.getInt("pordenid"));
              Proveedores proveedores=new Proveedores();
              Proveedores proveedoress=proveedores.proveedores_buscarporid(rs.getInt("pproveedorid"));
              obj.setProveedores(proveedoress);
              Producto producto=new Producto();
              Producto productos=producto.producto_buscarporid(rs.getInt("pproductoid"));
              obj.setProducto(productos);
              obj.setCantidad(rs.getInt("pcantidad"));
              obj.setPreciounitario(rs.getDouble("ppreciounitario"));
              obj.setNumeroorden(rs.getString("pnumeroorden"));
              obj.setEntregada(rs.getBoolean("pentregada"));
              obj.setFechaentrega(rs.getTimestamp("pFechaentrega"));
              lista.add(obj);
          }
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      finally
      {
          rs.close();
          preStm.close();
          con.desconectar();
      }
            return lista;

    }
    
    public static Ordenes ordenes_buscarporid(int pscactbevidenid) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Ordenes> lista= new ArrayList<Ordenes>();
       Ordenes obj= new Ordenes();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from public.ordenes_buscarporid(?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          preStm.setInt(1, pscactbevidenid);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Ordenes();
              obj.setOrdenid(rs.getInt("pordenid"));
              Proveedores proveedores=new Proveedores();
              Proveedores proveedoress=proveedores.proveedores_buscarporid(rs.getInt("pproveedorid"));
              obj.setProveedores(proveedoress);
              Producto producto=new Producto();
              Producto productos=producto.producto_buscarporid(rs.getInt("pproductoid"));
              obj.setProducto(productos);
              obj.setCantidad(rs.getInt("pcantidad"));
              obj.setPreciounitario(rs.getDouble("ppreciounitario"));
              obj.setNumeroorden(rs.getString("pnumeroorden"));
              obj.setEntregada(rs.getBoolean("pentregada"));
              obj.setFechaentrega(rs.getTimestamp("pFechaentrega"));
              lista.add(obj);
          }
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      finally
      {
          rs.close();
          preStm.close();
          con.desconectar();
      }
            return obj;

    }
    
    
     public static boolean ordenes_insertar(Ordenes ordenes) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÑADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.orden_insertar(?,?,?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, ordenes.getProveedores().getProveedorid()));
          parametros.add(new Parametro(2, ordenes.getProducto().getProductoid()));
          parametros.add(new Parametro(3, ordenes.getCantidad()));
          parametros.add(new Parametro(4, ordenes.getPreciounitario()));
          parametros.add(new Parametro(5, ordenes.getNumeroorden()));
          parametros.add(new Parametro(6, ordenes.getEntregada()));
           parametros.add(new Parametro(7, ordenes.getFechaentrega())); 
      
          //llenar el comando con los parametros
          cmd.setLstParametros(parametros);
          comandos.add(cmd);
          //llamamos al funcion que ejecuta la transaccion en la base de datos
          respuesta= con.ejecutaPreparedTransaccion(comandos);

      } catch (SQLException e) {
          throw  new Exception(e.getMessage());
      }
      finally
      {
          con.desconectar();
      }
      return respuesta;

  }
    
     public static boolean ordenes_editar(Ordenes ordenes) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÑADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.orden_editar(?,?,?,?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, ordenes.getOrdenid()));
          parametros.add(new Parametro(2, ordenes.getProveedores().getProveedorid()));
          parametros.add(new Parametro(3, ordenes.getProducto().getProductoid()));
          parametros.add(new Parametro(4, ordenes.getCantidad()));
          parametros.add(new Parametro(5, ordenes.getPreciounitario()));
          parametros.add(new Parametro(6, ordenes.getNumeroorden()));
          parametros.add(new Parametro(7, ordenes.getEntregada()));
           parametros.add(new Parametro(8, ordenes.getFechaentrega())); 
          
          //llenar el comando con los parametros
          cmd.setLstParametros(parametros);
          comandos.add(cmd);
          //llamamos al funcion que ejecuta la transaccion en la base de datos
          respuesta= con.ejecutaPreparedTransaccion(comandos);

      } catch (SQLException e) {
          throw  new Exception(e.getMessage());
      }
      finally
      {
          con.desconectar();
      }
      return respuesta;

  }
     
      public static boolean ordenes_eliminar(int piordenid) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÑADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.orden_eliminar(?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, piordenid));
          //llenar el comando con los parametros
          cmd.setLstParametros(parametros);
          comandos.add(cmd);
          //llamamos al funcion que ejecuta la transaccion en la base de datos
          respuesta= con.ejecutaPreparedTransaccion(comandos);

      } catch (SQLException e) {
          throw  new Exception(e.getMessage());
      }
            finally
      {
          con.desconectar();
      }
      return respuesta;

  }

}