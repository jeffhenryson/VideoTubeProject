package com.example.demo.controller.video.request;

import com.example.demo.controller.conta.request.ContaRequestID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VideoRequest {
	
	private ContaRequestID conta;
 
	private String descrição;

	private String link;

	private String nome;

}

