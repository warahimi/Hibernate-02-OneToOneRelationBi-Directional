package com.etity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//1 - Annotate the class as an entity and map it the the dabase table
@Entity
@Table(name = "instructor")
public class Instructor {
	//Steps:
	//1 - Annotate the class as an entity and map it the the dabase table
	//2 - Define the fields and mapp them to columns
	// *** Set up the mapping between the instructor and the instructor detail, NOTE: we do this mapping in the entity with PK
	//3 - Create constructors
	//4 - Generate Getters and Setters methods
	//5-  Genterate the toString() method to help us print the object
	
	
	//1 - Annotate the class as an entity and map it the the dabase table	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	// *** Set up the mapping between the instructor and the instructor detail
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id") // name of the FK in the instructor table // this FK references the the PK id column of InstuctorDetail table
	// this the column to hock up / join the one to one mapping
	InstructorDetail instructorDetail; // make an instance/variable of Instuctor daital / to relate them
	
	
	public Instructor() {
		
	}


	public Instructor(String firstName, String lastName, String email) {  // we will manually pass the InstructorDetail object to it./ we can pass and set the instructorDetail object as well if we want
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}


	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}


	@Override
	public String toString() {
		return "Instructor  [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	
	
	
	
	
}
