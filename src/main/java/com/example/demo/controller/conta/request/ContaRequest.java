package com.example.demo.controller.conta.request;


import com.example.demo.controller.usuario.request.UsuarioRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ContaRequest {

	private UsuarioRequest usuario;
	
}

