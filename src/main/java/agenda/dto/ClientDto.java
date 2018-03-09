package agenda.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import agenda.model.Contact;
import agenda.model.Product;

public class ClientDto {
	
	private int id;
	private String ruc;
	private String descripcionSocial;
	private String direccion;
	private Date fechaCreacion;
	
	private List<Contact> contacts = new ArrayList<>();
	private List<Product> products = new ArrayList<>();
	
	public ClientDto() {
		
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

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	

}
