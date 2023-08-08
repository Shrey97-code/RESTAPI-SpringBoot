package com.example.API.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {

//To make the ID column as primary key
	@Id
//Auto incrementing id column value
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
//To change the column name and setting other values as length
	@Column(name="username",nullable=false,length=100)
	private String name;
	private String email;
	private String password;
	private String about;
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
