package com.app.anwesh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carshowroom {
	@Id
private String CarModel;
private String CarName;
private Double Carcost;
}
