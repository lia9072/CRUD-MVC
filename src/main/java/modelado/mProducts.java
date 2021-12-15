package modelado;
import java.sql.*;
import java.util.ArrayList;

import clases.Products;
import config.Conectando;
public class mProducts {
		
		private Conectando mysql = new Conectando();
		private Connection cn = mysql.conectar();
		private ArrayList<Products>miLista;
		
		//METODO LISTAR CLIENTE
		public ArrayList<Products> Listar(){
			String SQL = "call ListarProductos()";
			ResultSet Rs;
			Statement Cmd;
			miLista = new ArrayList<Products>();
			try {
				Cmd = cn.createStatement();
				Rs = Cmd.executeQuery(SQL);
				while(Rs.next()) {
				miLista.add(new Products(Rs.getInt("ID"),
					Rs.getString("NameProduct"),
					Rs.getString("Category"),
					Rs.getDouble("Price"),
					Rs.getString("statusProduct"))			
					);
				}
				Rs.close();							
				System.out.println("puede listar");
			} catch (Exception e) {
				System.out.println("ERROR LISTAR CLIENTE:" + e.getMessage());
			}
			return miLista;
		}
		

			
		//METODO BUSCAR CLIENTE
		public Products Buscar(int Id){
			String SQL = "call BuscarProducto(?)";
			CallableStatement Stmt;
			ResultSet Rs;
			Products ObjC = null;
			try {
				Stmt = cn.prepareCall(SQL);
				Stmt.setInt(Id, 1);
				Rs = Stmt.executeQuery();
					if(Rs.next()) {
					ObjC = new Products(Rs.getInt("ID"),
							Rs.getString("NameProduct"),
							Rs.getString("Category"),
							Rs.getDouble("Price"),
							Rs.getString("statusProduct"));
			}
				Rs.close();
			} catch (Exception e) {
				System.out.println("ERROR BUSCAR Producto:" + e.getMessage());
			}
			return ObjC;
		}	
		
		//METODO INSERTAR CLIENTE
		public void Insertar(Products ObjC){
			String SQL = "call InsertarProducto(?,?,?,?,?)";
			CallableStatement Stmt;
			try {
				Stmt = cn.prepareCall(SQL);
				Stmt.setInt(1, ObjC.getID());
				Stmt.setString(2, ObjC.getNameProduct());
				Stmt.setString(3, ObjC.getCategory());
				Stmt.setDouble(4, ObjC.getPrice());
				Stmt.setString(5, ObjC.getStatusProduct());
			
				Stmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("ERROR INSERTAR Producto:" + e.getMessage());
			}
		}
		
		//METODO MODIFICAR CLIENTE
		public void Modificar(Products ObjC){
			String SQL = "call ModificaProducto(?,?,?,?,?)";
			CallableStatement Stmt;
			try {
				Stmt = cn.prepareCall(SQL);
				Stmt.setInt(1, ObjC.getID());
				Stmt.setString(2, ObjC.getNameProduct());
				Stmt.setString(3, ObjC.getCategory());
				Stmt.setDouble(4, ObjC.getPrice());
				Stmt.setString(5, ObjC.getStatusProduct());
				Stmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("ERROR MODIFICAR PRODUCTO:" + e.getMessage());
			}	
		}
		
		//METODO SUPRIMIR CLIENTE
		public void Suprimir(int Id){
			String SQL = "call SuprimirProducto(?)";
			CallableStatement Stmt;
			try {
				Stmt = cn.prepareCall(SQL);
				Stmt.setInt(1, Id);
				Stmt.executeUpdate();						
			} catch (Exception e) {
				System.out.println("ERROR SUPRIMIR Producto:" + e.getMessage());
			}
		}
		
		
	}


