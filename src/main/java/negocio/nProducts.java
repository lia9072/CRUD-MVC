package negocio;

import java.util.ArrayList;

import modelado.mProducts;

import clases.Products;
public class nProducts {
mProducts ObjDC;
	
	public nProducts(){
		ObjDC = new mProducts();
	}
	
	public ArrayList<Products>Listar(){
		return ObjDC.Listar();
	}

	public Products Buscar(int Id){
		return ObjDC.Buscar(Id);
	}
	
	public void Insertar(Products ObjP){
		ObjDC.Insertar(ObjP);
	}
	
	public void Modificar(Products ObjP){
		ObjDC.Modificar(ObjP);
	}
	
	public void Suprimir(int Id){
		ObjDC.Suprimir(Id);
	}
	

}
