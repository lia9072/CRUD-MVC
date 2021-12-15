package clases;

public class Orders {
	
	  int id;
	    String cliente ;
	    String estado;
	    String fecha;
		public Orders() {
			super();
		}
		public Orders(int id, String cliente, String estado, String fecha) {
			super();
			this.id = id;
			this.cliente = cliente;
			this.estado = estado;
			this.fecha = fecha;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCliente() {
			return cliente;
		}
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
	    
	    

}
