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
import java.util.ArrayList;

/**
 *
 * @author DiegoPatricio
 */
public class Sg_usuario {
    
    private int usuarioid;
    private String nombre_usuario;
    private String contrasenia;
    private String identificacion;

    public Sg_usuario() {
    }

    public Sg_usuario(int usuarioid, String nombre_usuario, String contrasenia, String identificacion) {
        this.usuarioid = usuarioid;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.identificacion = identificacion;
    }
  
    /**
     * @return the usuarioid
     */
    public int getUsuarioid() {
        return usuarioid;
    }

    /**
     * @param usuarioid the usuarioid to set
     */
    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    /**
     * @return the nombre_usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * @param nombre_usuario the nombre_usuario to set
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
        
    @Override
    public String toString() {
        return nombre_usuario; //To change body of generated methods, choose Tools | Templates.
    }

    
    public static ArrayList<Sg_usuario> sg_usuarios_buscartodos() throws Exception
   
           {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
        ArrayList<Sg_usuario> lista= new ArrayList<Sg_usuario>();
          Sg_usuario obj= new Sg_usuario();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;

      try {
          //declaro mi sql
          String sql= "select * from sg_usuarios_buscartodos()";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Sg_usuario();
              obj.setUsuarioid(rs.getInt("pusuarioid"));
              obj.setNombre_usuario(rs.getString("pnombre_usuario"));
              obj.setContrasenia(rs.getString("pcontrasenia"));
              obj.setIdentificacion(rs.getString("pidentificacion"));
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
    public static Sg_usuario sg_usuarios_buscarporid(int pscactbevidenid) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
          Sg_usuario obj= new Sg_usuario();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from sg_usuarios_buscarporid(?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          preStm.setInt(1, pscactbevidenid);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Sg_usuario();
              obj.setUsuarioid(rs.getInt("pusuarioid"));
              obj.setNombre_usuario(rs.getString("pnombre_usuario"));
              obj.setContrasenia(rs.getString("pcontrasenia"));
              obj.setIdentificacion(rs.getString("pidentificacion"));
                            
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
    
    
     public static boolean sg_usuario_insertar(Sg_usuario sg_usuarios) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from sg_usuario_insertar(?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros          
          StringEncrypter encriptar = new StringEncrypter("aplicaciones"); 
          String pass = encriptar.encrypt(sg_usuarios.getContrasenia());
          parametros.add(new Parametro(1, sg_usuarios.getNombre_usuario()));
          parametros.add(new Parametro(2, pass));
          parametros.add(new Parametro(3, sg_usuarios.getIdentificacion()));
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
    
     public static boolean sg_usuario_editar(Sg_usuario sg_usuarios) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from sg_usuario_editar(?,?,?,?)");
          //CREAMOS EL ARRALIST DE PARAMETROS PARA ASIGANR A MI PRIMER COMANDO
          ArrayList<Parametro> parametros = new ArrayList<Parametro>();
          //llenamos el arraylist con todos los parametros

          parametros.add(new Parametro(1, sg_usuarios.getUsuarioid()));
          parametros.add(new Parametro(2, sg_usuarios.getNombre_usuario()));
          parametros.add(new Parametro(3, sg_usuarios.getContrasenia()));
          parametros.add(new Parametro(4, sg_usuarios.getIdentificacion()));
                  
          
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
     
      public static boolean sg_usuario_eliminar(int pscactbevidenid) throws Exception
  {
      boolean respuesta=false;
      Conexion con = new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      try {
          //CREAMOS EL ARRAYLIST DE LOS COMANDOS O SENTENCIAS SQL
          ArrayList<Comando> comandos = new ArrayList<Comando>();
          //CREAMOS EL PRIMER COMANDO QUE SERA AÃ‘ADIDO AL ARRAYLIST D COMANDOS
          Comando cmd= new Comando();
          //SETEAMOS LA FUNCION AL COMAND0
          cmd.setSetenciaSql("select * from sg_usuario_eliminar(?)");
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
public static Sg_usuario sg_usuarios_buscar_credenciales(String pinombre_usuario, String picontrasenia) throws Exception
    {
         //CREO LISTA QUE RECIBIRA LOS DATOS DEL RESULSET
       ArrayList<Sg_usuario> lista= new ArrayList<Sg_usuario>();
       Sg_usuario obj= new Sg_usuario();
       ResultSet rs= null;
      //LLAMO LA CONEXION
      Conexion con= new Conexion(Global.driver, Global.url, Global.user, Global.pass);
      //DECLARO UN PREPAREDSTATEMENT QUE EJECUTARA LA SQL
      PreparedStatement preStm= null;
       
      try {
          //declaro mi sql
          String sql= "select * from public.sg_usuarios_buscar_credenciales(?,?)";
          //creo mi preparedstatement
          preStm=con.creaPreparedSmt(sql);
          //ejecuto el prepardestatement y le asigno a mi resulset
          
          StringEncrypter encriptar = new StringEncrypter("aplicaciones"); 
          String pass = encriptar.encrypt(picontrasenia);
          
          preStm.setString(1, pinombre_usuario);
          preStm.setString(2, pass);
          rs= con.ejecutaPrepared(preStm);
          obj=null;
          while (rs.next()) {
              obj= new Sg_usuario();
              obj.setUsuarioid(rs.getInt("pusuarioid"));
              obj.setNombre_usuario(rs.getString("pnombre_usuario"));
              obj.setContrasenia(rs.getString("pcontrasenia"));
              obj.setIdentificacion(rs.getString("pidentificacion"));
              
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
    
    
}

    
