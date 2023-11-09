package principal.bolsa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Oferta {
	 
	//variables de la clase oferta
	
	@Id                  //jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String descripcion;
	private String horario;
	private String puesto;
	private String jornada;
	private String fecha;

    //Relacion many to one	
	@ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
	
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
	
	public void setEmpresa(Empresa empresa) {
	    this.empresa = empresa;
	}

 
	@Override
	public String toString() {
		return "oferta [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", horario=" + horario
				+ ", puesto=" + puesto + ", jornada=" + jornada + ", fecha=" + fecha + "]";
	}


	public Empresa getEmpresa() {
		// TODO Auto-generated method stub
		return null;
	}
	



	
	
	

}