package principal.bolsa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class usuario {

	@Id                  //jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	private String nombre;
	private String apellido;
	private int edad;
	private String correo;
	private String password;
	
	public usuario() {
	
	}
	
	public usuario(long id, String nombre, String apellido, int edad, String correo, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.correo = correo;
		this.password = password;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", correo="
				+ correo + ", password=" + password + "]";
	}
	
	
	
	
}
