/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReglasDeNegocio;
import AccesoADatos.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Angel
 */
public class Proveedor {
  private int proveedorid;
  private String nombreproveedor;
  private String direccion;
  private String telefono;

    public Proveedor() {
    }

    public Proveedor(int proveedorid, String nombreproveedor, String direccion, String telefono) {
        this.proveedorid = proveedorid;
        this.nombreproveedor = nombreproveedor;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    /**
     * @return the proveedorid
     */
    public int getProveedorid() {
        return proveedorid;
    }

    /**
     * @param proveedorid the proveedorid to set
     */
    public void setProveedorid(int proveedorid) {
        this.proveedorid = proveedorid;
    }

    /**
     * @return the nombreproveedor
     */
    public String getNombreproveedor() {
        return nombreproveedor;
    }

    /**
     * @param nombreproveedor the nombreproveedor to set
     */
    public void setNombreproveedor(String nombreproveedor) {
        this.nombreproveedor = nombreproveedor;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }   
    
    @Override
    public String toString() {
        return nombreproveedor;
    }
    
    public static ArrayList<Proveedor> proveedor_buscartodos() throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
        ArrayList<Proveedor> lista= new ArrayList<Proveedor>();
          Proveedor obj= new Proveedor();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;

      try {
          //declaro mi sql
          String sql= "select * from public.proveedores_buscartodos()";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Proveedor();
              obj.setProveedorid(rs.getInt("pproveedorid"));
              obj.setNombreproveedor(rs.getString("pnombreproveedor"));
              obj.setDireccion(rs.getString("pdireccion"));
              obj.setTelefono(rs.getString("ptelefono"));
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
    
    public static Proveedor proveedor_buscarporid(int pscactbevidenid) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
        ArrayList<Proveedor> lista= new ArrayList<Proveedor>();
          Proveedor obj= new Proveedor();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from public.proveedores_buscarporid(?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          preStm.setInt(1, pscactbevidenid);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Proveedor();
              obj.setProveedorid(rs.getInt("pproveedorid"));
              obj.setNombreproveedor(rs.getString("pnombreproveedor"));
              obj.setDireccion(rs.getString("pdireccion"));
              obj.setTelefono(rs.getString("ptelefono"));              
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
    
    
     public static boolean proveedor_insertar(Proveedor proveedor) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.proveedor_insertar(?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros
          parametros.add(new Parametro(1, proveedor.getNombreproveedor()));
          parametros.add(new Parametro(2, proveedor.getDireccion()));
          parametros.add(new Parametro(3, proveedor.getTelefono()));
          

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
    
     public static boolean proveedor_editar(Proveedor proveedor) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.proveedor_editar(?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros

          parametros.add(new Parametro(1, proveedor.getProveedorid()));
          parametros.add(new Parametro(2, proveedor.getNombreproveedor()));
          parametros.add(new Parametro(3, proveedor.getDireccion()));
          parametros.add(new Parametro(4, proveedor.getTelefono()));
        
          
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
     
      public static boolean proveedor_eliminar(int pscactbevidenid) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from public.proveedor_eliminar(?)");
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
