package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy; 
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable; 
import javax.jdo.annotations.Persistent; 
import javax.jdo.annotations.PrimaryKey; 
@PersistenceCapable(identityType = IdentityType.APPLICATION) 
public class Module {
	 @PrimaryKey    
	//--------------------------------------------------------
	 @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	 //--------------------------------------------------------
	 @Persistent private String name;  
	 @Persistent private double precio;
	 @Persistent private int stock;
	 @Persistent private String description;  
	 @Persistent private String banner; 
	 @Persistent private String fecha;
	//--------------------------------------------------------
	 @Persistent private boolean status;
	//--------------------------------------------------------
	 
	 public Module (String name,Double precio,int stock,String description,boolean status,String banner,String fecha) {
		this.name=name;
		this.precio=precio;
		this.stock=stock;
		this.description=description;
		this.banner = banner;
		this.status=status;
		this.fecha=fecha;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	 
	
}