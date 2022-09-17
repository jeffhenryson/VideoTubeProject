package com.example.demo.controller.conta;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.controller.conta.request.ContaRequest;
import com.example.demo.controller.conta.response.ContaResponse;
import com.example.demo.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	ContaService contaService;
	
	@PostMapping("")
	public ResponseEntity<ContaResponse> cadastro(@RequestBody @Validated ContaRequest contaRequest,
			UriComponentsBuilder uriBuilder) throws Exception {
		ContaResponse conta = contaService.salvar(contaRequest);
		URI uri = uriBuilder.path("/conta/{id}").buildAndExpand(conta.getId()).toUri();
		return ResponseEntity.created(uri).body(conta);
	}
	
	@GetMapping("")
	public List<ContaResponse> listar() {
		return contaService.buscar();
	}

}