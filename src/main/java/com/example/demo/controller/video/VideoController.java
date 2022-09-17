package com.example.demo.controller.video;

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

import com.example.demo.controller.video.request.VideoRequest;
import com.example.demo.controller.video.response.VideoResponse;
import com.example.demo.service.VideoService;

@RestController
@RequestMapping("/Video")
public class VideoController {

	@Autowired
	VideoService videoService;

	@PostMapping("")
	public ResponseEntity<VideoResponse> salvarVideo(@Validated @RequestBody VideoRequest videoRequest,
			UriComponentsBuilder uriComponents) throws Exception{

		VideoResponse video = videoService.salvar(videoRequest);
		
		URI uri = uriComponents.path("/livro/{id}").buildAndExpand(video.getId()).toUri();
		return ResponseEntity.created(uri).body(video);
	}
	
	@GetMapping("")
	public List<VideoResponse> listar() {
		return videoService.buscar();
	}

}