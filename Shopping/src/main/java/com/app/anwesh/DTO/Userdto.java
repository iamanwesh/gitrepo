package com.app.anwesh.DTO;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userdto {
	private String username;
	private String password;
	private String email;
	private String gender;
	private String address;
	private String phoneno;
	private MultipartFile image;
}
