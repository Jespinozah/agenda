package agenda.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class Client {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
	@SequenceGenerator(name="client_generator", sequenceName = "client_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private String ruc;
	private String descripcionSocial;
	private String direccion;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion = new Date();
	
	@OneToMany(mappedBy = "client",	cascade = CascadeType.REMOVE)
	private List<Contact> contacts = new ArrayList<>();
	
	@OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
	private List<Product> products = new ArrayList<>();
	
	public Client() {
	}

	public Client(int id) {
		this.id = id;
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
	

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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
	
}
