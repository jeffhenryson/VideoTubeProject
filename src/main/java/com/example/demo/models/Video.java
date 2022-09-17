package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "video_seq")
	@SequenceGenerator(name = "video_seq", sequenceName = "video_seq", allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne
	@JoinColumn(name = "conta_id", referencedColumnName = "id", nullable = false)
	private Conta conta;

	private String descrição;

	private String link;

	private String nome;}