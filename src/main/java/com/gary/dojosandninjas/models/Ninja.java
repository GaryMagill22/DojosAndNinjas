package com.gary.dojosandninjas.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


// id, Name, Vendor, Amount, Description


@Entity
@Table(name="ninjas")
public class Ninja {
	// Private attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@Size(min = 3, message="Name must be atleast 3 characters!")
	private String first_name;
	
	
	
	@NotNull
	@Size(min = 3, message="Name must be atleast 3 characters!")
	private String last_name;
	
	@NotNull
	@Min(value=1, message="Name must be atleast 3 characters!")
	private Integer age;
	
	
	// Adding One to Many Relationship
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id")
	private Dojo owner;
	
	
	

    public Ninja() {
    	
    }
    public Ninja(String first_name, String last_name, int age) {
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.age = age;
   }
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Dojo getOwner() {
		return owner;
	}
	public void setOwner(Dojo owner) {
		this.owner = owner;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}




	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	

    
	
    
    
 	@PrePersist
     protected void onCreate(){
         this.createdAt = new Date();
     }
     @PreUpdate
     protected void onUpdate(){
         this.updatedAt = new Date();
     }
     
}	
    	
    	