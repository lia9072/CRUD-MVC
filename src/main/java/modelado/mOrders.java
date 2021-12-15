package modelado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Orders;
import clases.Products;
import config.Conectando;

public class mOrders {
	private Conectando mysql = new Conectando();
	private Connection cn = mysql.conectar();
	private ArrayList<Orders>miLista;
	
	//METODO LISTAR CLIENTE
	public ArrayList<Orders> Listar(){
		String SQL = "call ListarOrders()";
		ResultSet Rs;
		Statement Cmd;
		miLista = new ArrayList<Orders>();
		try {
			Cmd = cn.createStatement();
			Rs = Cmd.executeQuery(SQL);
			while(Rs.next()) {
			miLista.add(new Orders(Rs.getInt("ID"),
				Rs.getString("Consumer"),
				Rs.getString("Statuss"),
				Rs.getString("fecha")	)	
				);
			}
			Rs.close();							
			System.out.println("puede listar");
		} catch (Exception e) {
			System.out.println("ERROR LISTAR Orders:" + e.getMessage());
		}
		return miLista;
	}
	

		
	//METODO BUSCAR CLIENTE
	public Orders Buscar(int id){
		String SQL = "call BuscarOrders(?)";
		CallableStatement Stmt;
		ResultSet Rs;
		Orders ObjC = null;
		try {
			Stmt = cn.prepareCall(SQL);
			Stmt.setInt(id, 1);
			Rs = Stmt.executeQuery();
				if(Rs.next()) {
				ObjC = new Orders(Rs.getInt("ID"),
						Rs.getString("cliente"),
						Rs.getString("estado"),
						Rs.getString("fecha")	);
		}
			Rs.close();
			System.out.println("ya busque");
		} catch (Exception e) {
			System.out.println("ERROR BUSCAR Orders:" + e.getLocalizedMessage());
		}
		return ObjC;
	}	
	
	//METODO INSERTAR CLIENTE
	public void Insertar(Orders ObjC){
		String SQL = "call InsertarOrders(?,?,?,?)";
		CallableStatement Stmt;
		try {
			Stmt = cn.prepareCall(SQL);
			Stmt.setInt(1, ObjC.getId());
			Stmt.setString(2, ObjC.getCliente());
			Stmt.setString(3, ObjC.getEstado());
			Stmt.setString(4, ObjC.getFecha());
		
		
			Stmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ERROR INSERTAR Orders:" + e.getMessage());
		}
	}
	
	//METODO MODIFICAR CLIENTE
	public void Modificar(Orders ObjC){
		String SQL = "call ModificaOrders(?,?,?,?)";
		CallableStatement Stmt;
		try {
			Stmt = cn.prepareCall(SQL);
			Stmt.setInt(1, ObjC.getId());
			Stmt.setString(2, ObjC.getCliente());
			Stmt.setString(3, ObjC.getEstado());
			Stmt.setString(4, ObjC.getFecha());
			Stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR MODIFICAR Orders:" + e.getMessage());
		}	
	}
	
	//METODO SUPRIMIR CLIENTE
	public void Suprimir(int id){
		String SQL = "call ModificaOrders(?)";
		CallableStatement Stmt;
		try {
			Stmt = cn.prepareCall(SQL);
			Stmt.setInt(1, id);
			Stmt.executeUpdate();						
		} catch (Exception e) {
			System.out.println("ERROR SUPRIMIR Producto:" + e.getMessage());
		}
	}
	
	
}
