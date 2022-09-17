package com.example.demo.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.controller.conta.request.ContaRequest;
import com.example.demo.controller.conta.response.ContaResponse;
import com.example.demo.controller.usuario.request.UsuarioRequest;
import com.example.demo.controller.usuario.response.UsuarioResponse;
import com.example.demo.models.Conta;
import com.example.demo.models.Usuario;



@Component
public class ContaBuilder {

	//Lista 
	
	public List<ContaResponse> buildContaResponse(List<Conta> conta){
		
		return conta.stream().map(contas -> buildContaResponse(contas)).collect(Collectors.toList());
	}
	
	// Response

	public UsuarioResponse buildUsuarioResponse(Usuario usuario) {

		return UsuarioResponse.builder().id(usuario.getId()).username(usuario.getUsername())
				.password(usuario.getPassword()).build();
	}

	public ContaResponse buildContaResponse(Conta conta) {

		return ContaResponse.builder().id(conta.getId()).usuario(buildUsuarioResponse(conta.getUsuario())).build();
	}

	// Request
	public Usuario buildUsuario(UsuarioRequest usuarioRequest) {

		return Usuario.builder().username(usuarioRequest.getUsername()).password(usuarioRequest.getPassword()).build();

	}

	public Conta buildConta(ContaRequest contaRequest) {

		return Conta.builder().usuario(buildUsuario(contaRequest.getUsuario())).build();

	}

}