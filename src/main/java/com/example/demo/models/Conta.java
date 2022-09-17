package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_seq")
	@SequenceGenerator(name = "conta_seq", sequenceName = "conta_seq", allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Usuario_Id", referencedColumnName = "id")
	private Usuario usuario;
}

