package com.app.anwesh.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
//import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;

	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
	private String username;
	@NotBlank(message = "Password is required")
	private String password;
	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;
	@NotBlank(message = "Gender number is required")
	private String gender;
	@NotBlank(message = "Address number is required")
	private String address;
	@NotBlank(message = "Phone number is required")
	@Size(min = 10, message = "Valid Phone number should be 10 digits")
	private String phoneno;
	private String image;
}
