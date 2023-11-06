package principal.bolsa.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empresa")
public class Empresa {

	@Id                  
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_id")
	private long id;
	
//	@Column(name = "nombre")
	private String nombre;
//	@Column(name = "direccion")
	private String direccion; 
//	@Column(name = "telefono")
	private String telefono;
//	@Column(name = "correo")
	private String correo;
	
	
	public Empresa() {
		
	}
	
	public Empresa(long id, String nombre, String direccion, String telefono, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo; 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "empresa [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", correo=" + correo + "]";
	}
	
	
	
	
}
