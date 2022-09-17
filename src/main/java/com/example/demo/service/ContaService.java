package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.conta.request.ContaRequest;
import com.example.demo.controller.conta.response.ContaResponse;
import com.example.demo.repository.ContaRepository;
import com.example.demo.utils.ContaBuilder;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;

	@Autowired
	ContaBuilder contaBuilder;

	public ContaResponse salvar(ContaRequest contaRequest) {

		return contaBuilder.buildContaResponse(contaRepository.save(contaBuilder.buildConta(contaRequest)));
	}

	public List<ContaResponse> buscar() {

		return contaBuilder.buildContaResponse(contaRepository.findAll());
	}

}