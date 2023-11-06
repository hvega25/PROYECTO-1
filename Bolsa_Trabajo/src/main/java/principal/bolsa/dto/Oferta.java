package principal.bolsa.dto;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="oferta")
public class Oferta {
	 
	//variables de la clase oferta
	
	@Id                  
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oferta_id")
	private long id;
	
//	@Column(name = "nombre")
	private String nombre;
//	@Column(name = "descripcion")
	private String descripcion;
//	@Column(name = "horario")
	private String horario;
//	@Column(name = "puesto")
	private String puesto;
//	@Column(name = "jornada")
	private String jornada;
//	@Column(name = "fecha")
	private String fecha;

	//constructores
	public Oferta() {
		
	}

	
	public Oferta(long id, String nombre, String descripcion, String horario, String puesto, String jornada,
			String fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horario = horario;
		this.puesto = puesto;
		this.jornada = jornada;
		this.fecha = fecha;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
 
	@Override
	public String toString() {
		return "oferta [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", horario=" + horario
				+ ", puesto=" + puesto + ", jornada=" + jornada + ", fecha=" + fecha + "]";
	}
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "empresa", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Empresa empresa;
	



	
	
	

}
