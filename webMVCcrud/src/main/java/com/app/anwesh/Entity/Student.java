package com.app.anwesh.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="studentdtl")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="studentid")
	public Integer stdid;
	@Column(name="studentname" ,length=50)
	public String stdname;
	@Column(name="studentgender", nullable=false)
	public String stdgen;
	@Column(name="studentsalary")
	public Double stdsal;
	@Column(name="studentdept",length=10,nullable=false)
	public String stddept;
	@Column(name="studentaddr",length=100)
	public String stdaddress;
}
