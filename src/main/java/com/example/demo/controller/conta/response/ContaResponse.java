package com.example.demo.controller.conta.response;


import com.example.demo.controller.usuario.response.UsuarioResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ContaResponse {
	private Long id;
	private UsuarioResponse usuario;
}
