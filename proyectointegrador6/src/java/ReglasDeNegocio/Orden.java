/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReglasDeNegocio;

import AccesoADatos.Comando;
import AccesoADatos.Conexion;
import AccesoADatos.Global;
import AccesoADatos.Parametro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Orden {
    private int ordenid;
    private Proveedor proveedor;
    private Producto producto;
    private int cantidad;
    private double preciounitario;
    private String numeroorden;   
    private boolean entregada;
    private Timestamp fechaentrega;


    public Orden() {
    }

    public Orden(int ordenid, Proveedor proveedor, Producto producto, int cantidad, double preciounitario, String numeroorden, boolean entregada, Timestamp fechaentrega) {
        this.ordenid = ordenid;
        this.proveedor = proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
        this.numeroorden = numeroorden;
        this.entregada = entregada;
        this.fechaentrega = fechaentrega;
    }   
           
    /**
     * @return the ordenid
     */
    public int getOrdenid() {
        return ordenid;
    }

    /**
     * @param ordenid the ordenid to set
     */
    public void setOrdenid(int ordenid) {
        this.ordenid = ordenid;
    }

    /**
     * @return the proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the preciounitario
     */
    public double getPreciounitario() {
        return preciounitario;
    }

    /**
     * @param preciounitario the preciounitario to set
     */
    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    /**
     * @return the numeroorden
     */
    public String getNumeroorden() {
        return numeroorden;
    }

    /**
     * @param numeroorden the numeroorden to set
     */
    public void setNumeroorden(String numeroorden) {
        this.numeroorden = numeroorden;
    }

    /**
     * @return the entregada
     */
    public boolean isEntregada() {
        return entregada;
    }

    /**
     * @param entregada the entregada to set
     */
    public void setEntregada(boolean entregada) {
        this.entregada = entregada;
    }

    /**
     * @return the fechaentrega
     */
    public Timestamp getFechaentrega() {
        return fechaentrega;
    }

    /**
     * @param fechaentrega the fechaentrega to set
     */
    public void setFechaentrega(Timestamp fechaentrega) {
        this.fechaentrega = fechaentrega;
    }  
        
    public static ArrayList<Orden> orden_buscartodos() throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
        ArrayList<Orden> lista= new ArrayList<Orden>();
          Orden obj= new Orden();
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
              obj = new Orden();
              obj.setOrdenid(rs.getInt("pordenid"));
              Proveedor proveedor= new Proveedor();
              Proveedor proveedores = proveedor.proveedor_buscarporid(rs.getInt("pproveedorid"));
              obj.setProveedor(proveedores);
              Producto producto= new Producto();
              Producto productos = producto.producto_buscarporid(rs.getInt("pproductoid"));
              obj.setProducto(productos);
              obj.setCantidad(rs.getInt("pcantidad"));
              obj.setPreciounitario(rs.getDouble("ppreciounitario"));
              obj.setNumeroorden(rs.getString("pnumeroorden"));
              obj.setEntregada(rs.getBoolean("pentregada"));
              obj.setFechaentrega(rs.getTimestamp("pfechaentrega"));
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
    
    public static Orden orden_buscarporid(int pscactbevidenid) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
        ArrayList<Orden> lista= new ArrayList<Orden>();
          Orden obj= new Orden();
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
              obj = new Orden();
              obj.setOrdenid(rs.getInt("pordenid"));
              Proveedor proveedor= new Proveedor();
              Proveedor proveedores = proveedor.proveedor_buscarporid(rs.getInt("pproveedorid"));
              obj.setProveedor(proveedores);
              Producto producto= new Producto();
              Producto productos = producto.producto_buscarporid(rs.getInt("pproductoid"));
              obj.setProducto(productos);
              obj.setCantidad(rs.getInt("pcantidad"));
              obj.setPreciounitario(rs.getDouble("ppreciounitario"));
              obj.setNumeroorden(rs.getString("pnumeroorden"));
              obj.setEntregada(rs.getBoolean("pentregada"));
              obj.setFechaentrega(rs.getTimestamp("pfechaentrega"));
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
    
    
     public static boolean orden_insertar(Orden orden) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.orden_insertar(?,?,?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, orden.getProveedor().getProveedorid()));
          parametros.add(new Parametro(2, orden.getProducto().getProductoid()));
          parametros.add(new Parametro(3, orden.getCantidad()));
          parametros.add(new Parametro(4, orden.getPreciounitario()));
          parametros.add(new Parametro(5, orden.getNumeroorden()));
          parametros.add(new Parametro(6, orden.isEntregada()));
          parametros.add(new Parametro(7, orden.getFechaentrega()));        
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
    
     public static boolean orden_editar(Orden orden) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.orden_editar(?,?,?,?,?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros

          parametros.add(new Parametro(1, orden.getOrdenid()));
          parametros.add(new Parametro(2, orden.getProveedor().getProveedorid()));
          parametros.add(new Parametro(3, orden.getProducto().getProductoid()));
          parametros.add(new Parametro(4, orden.getCantidad()));
          parametros.add(new Parametro(5, orden.getPreciounitario()));
          parametros.add(new Parametro(6, orden.getNumeroorden()));
          parametros.add(new Parametro(7, orden.isEntregada()));
          parametros.add(new Parametro(8, orden.getFechaentrega()));
        
          
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
     
      public static boolean orden_eliminar(int pscactbevidenid) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.orden_eliminar(?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, pscactbevidenid));
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

    