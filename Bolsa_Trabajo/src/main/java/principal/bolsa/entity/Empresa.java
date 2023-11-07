package principal.bolsa.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Empresa {

	@Id // jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empresa_id;

	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;

	/*
	 * Tiene el	@JsonIgnore ya que el import. sql tiene los datos de oferta
	 */

	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch= FetchType.LAZY) // Carga ansiosa de ofertas
	private List<Oferta> ofertas;

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	// constructor vacio y con datos propios de emprea
	public Empresa() {

	}

	public Empresa(long id, String nombre, String direccion, String telefono, String correo) {
		super();
		this.empresa_id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}

	public long getId() {
		return empresa_id;
	}

	public void setId(long id) {
		this.empresa_id = id;
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
		return "empresa [id=" + empresa_id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", correo=" + correo + "]";
	}

	public void setOfertas(ArrayList arrayList) {
		// TODO Auto-generated method stub

	}

}