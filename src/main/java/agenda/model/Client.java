package agenda.model;

public class Client {

	private int id;
	private String ruc;
	private String descripcionSocial;
	private String direccion;
	
	public Client( ) {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDescripcionSocial() {
		return descripcionSocial;
	}

	public void setDescripcionSocial(String descripcionSocial) {
		this.descripcionSocial = descripcionSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
