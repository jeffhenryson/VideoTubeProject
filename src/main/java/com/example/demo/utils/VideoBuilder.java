package com.example.demo.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.controller.video.request.VideoRequest;
import com.example.demo.controller.video.response.VideoResponse;
import com.example.demo.models.Conta;
import com.example.demo.models.Video;


@Component
public class VideoBuilder {

	@Autowired
	ContaBuilder contaBuilder;
	
	public List<VideoResponse> buildVideoResponse(List<Video> video){
		
		return video.stream().map(videos -> buildVideoResponse(videos)).collect(Collectors.toList());} 

	public Video buildVideo(VideoRequest videoRequest, Conta conta) {

		return Video.builder().conta(conta)
				.descrição(videoRequest.getDescrição()).link(videoRequest.getLink()).nome(videoRequest.getNome())
				.build();}

	public VideoResponse buildVideoResponse(Video video) {
		
		return VideoResponse.builder().conta(contaBuilder.buildContaResponse(video.getConta()))
				.descrição(video.getDescrição()).link(video.getLink()).nome(video.getNome())
				.build();}
	
}