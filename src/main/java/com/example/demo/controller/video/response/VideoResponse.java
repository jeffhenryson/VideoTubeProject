package com.example.demo.controller.video.response;

import com.example.demo.controller.conta.response.ContaResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoResponse {

	private Long id;

	private ContaResponse conta;

	private String descrição;

	private String link;

	private String nome;

	
}