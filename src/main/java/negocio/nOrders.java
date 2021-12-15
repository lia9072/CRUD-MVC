package negocio;

import modelado.mOrders;

import java.util.ArrayList;

import clases.Orders;
public class nOrders {
	
mOrders ObjDC;
	
	public nOrders(){
		ObjDC = new mOrders();
	}
	
	public ArrayList<Orders>Listar(){
		return ObjDC.Listar();
	}

	public Orders Buscar(int Id){
		return ObjDC.Buscar(Id);
	}
	
	public void Insertar(Orders ObjP){
		ObjDC.Insertar(ObjP);
	}
	
	public void Modificar(Orders ObjP){
		ObjDC.Modificar(ObjP);
	}
	
	public void Suprimir(int Id){
		ObjDC.Suprimir(Id);
	}
	
	

}
