package model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.IdGeneratorStrategy; 
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable; 
import javax.jdo.annotations.Persistent; 
import javax.jdo.annotations.PrimaryKey; 
@PersistenceCapable(identityType = IdentityType.APPLICATION) 
public class Courses {
	 @PrimaryKey    
	//--------------------------------------------------------
	 @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	 //--------------------------------------------------------
	 @Persistent private String courseName;  
	 @Persistent private String rugro;
	 @Persistent private String duracion; 
	 @Persistent private String description;  
	 @Persistent private String dateInicio;
	 @Persistent private String dateFinal;
	 @Persistent private String banner; 
	 @Persistent private ArrayList<String> actividades=new ArrayList<String>();	
	//--------------------------------------------------------
	 @Persistent private boolean status;
	//--------------------------------------------------------
	 
	 public Courses (String courseName,String rugro,String description,String dateInicio,String duracion,boolean status,String banner) {
		this.courseName=courseName;
		this.description=description;
		this.rugro=rugro;
		this.dateInicio=dateInicio;
		this.duracion=duracion;
		this.status=status;
		this.banner = banner;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRugro() {
		return rugro;
	}

	public void setRugro(String rugro) {
		this.rugro = rugro;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateInicio() {
		return dateInicio;
	}

	public void setDateInicio(String dateInicio) {
		this.dateInicio = dateInicio;
	}

	public String getDateFinal() {
		return dateFinal;
	}

	public void setDateFinal(String dateFinal) {
		this.dateFinal = dateFinal;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public ArrayList<String> getActividades() {
		return this.actividades;
	}	
}