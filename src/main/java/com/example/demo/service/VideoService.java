package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.video.request.VideoRequest;
import com.example.demo.controller.video.response.VideoResponse;
import com.example.demo.models.Conta;
import com.example.demo.repository.ContaRepository;
import com.example.demo.repository.VideoRepository;
import com.example.demo.utils.VideoBuilder;

@Service
public class VideoService {

	@Autowired
	VideoBuilder videoBuilder;

	@Autowired
	VideoRepository videoRepository;

	@Autowired
	ContaRepository contaRepository;
	
	public VideoResponse salvar(VideoRequest videoRequest) throws Exception {
		Optional<Conta> contaOpt = contaRepository.findById(videoRequest.getConta().getId());
		if (contaOpt.isPresent()) {
			return videoBuilder.buildVideoResponse(
					videoRepository.save(videoBuilder.buildVideo(videoRequest, contaOpt.get())));
		}
		throw new Exception("Conta não existente!");
	}

	public List<VideoResponse> buscar(){
		
		return videoBuilder.buildVideoResponse(videoRepository.findAll());
		
	}
	
}
