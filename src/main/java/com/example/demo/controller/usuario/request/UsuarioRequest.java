package com.example.demo.controller.usuario.request;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UsuarioRequest {

	private String username;
	
	private String password;
	
}