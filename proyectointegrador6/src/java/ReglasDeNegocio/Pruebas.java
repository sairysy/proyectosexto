/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReglasDeNegocio;

import java.util.ArrayList;
import AccesoADatos.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Cristian
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       Sg_usuario obj=new Sg_usuario();
    obj=Sg_usuario.sg_usuarios_buscar_credenciales("Secre", "123456");
    
    System.out.print(obj.getUsuarioid());
//    
    
//            Cliente obj=new Cliente();
//    obj=Cliente.cliente_buscarporid(13);
//    
//    System.out.print(obj.getApellidos());
//    
        // TODO code application logic here
        
//        //BUSCARPOR ID CLIENTE
//         ArrayList<Cliente> lista= new ArrayList<Cliente>();
//         lista=Cliente.cliente_buscarporid(4);
//         if (lista.size()!=0)
//          {
//               for(Cliente rec: lista)
//                {
//
//                         System.out.println(rec.getNombre());
//                }
//             }
//            else
//                {
//                System.out.println("No hay registro");
//                }
//             }
//    
////        //  INSERTAR CLIENTE
//       Venta obj=new Venta();
//       obj.setCantidad(44);
//       obj.setPreciounitarioventa(12.0);
//       obj.setNumerofactura("0983779610");
//               
//      Venta.venta_insertar(obj);
//      }
    
        //  INSERTAR
//    Producto obj=new Producto();
//     obj.setNombreproducto("fibra");
//
//    Producto.producto_insertar(obj);
//    
       // buscar por od producto
//         ArrayList<Producto> lista= new ArrayList<Producto>();
//         lista=Producto.producto_buscarporid(2);
//         if (lista.size()!=0)
//          {
//               for(Producto rec: lista)
//                {
//
//                         System.out.println(rec.getNombreproducto());
//                }
//             }
//            else
//                {
//                System.out.println("No hay registro");
//                }
//             }
//    
        // buscartos todos producto  
//    ArrayList<Venta> lista= new ArrayList<Venta>();
//         lista=Venta.venta_buscartodos();
//         if (lista.size()!=0)
//          {
//               for(Venta rec: lista)
//                {
//                         System.out.println(rec.getVentaid());
//                         System.out.println(rec.getClienteid());
//                         System.out.println(rec.getProductoid());
//                         System.out.println(rec.getCantidad());
//                         System.out.println(rec.getFechatransaccion());
//                         System.out.println(rec.getNumerofactura());
//                         System.out.println(rec.getPreciounitarioventa());
//                }
//             }
//            else
//                {
//                System.out.println("No hay registro");
//                }
//          }
//     }
             
//    eliminar producto
    
  
//    Producto.producto_eliminar(6);
//
////    EDITAR
//Categoria obj=new Categoria();
//obj.setNombrecategoria("Cable UTP");
//obj.setCategoriaid(2);
//    Producto.producto_editar(obj);
//    }
   // eliminar cliente
  
//    Cliente.cliente_eliminar(1);

    
    //    EDITAR cliente
//Cliente obj=new Cliente();
//obj.setNombre("Katerine");
//obj.setApellido("Bsantes");
//obj.setTelefono("123456789");
//obj.setEmail("juan123@haua");
//obj.setClienteid(5);
//    Cliente.clientes_editar(obj);
//    


    
    }
}

