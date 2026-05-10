package project.studyCompany.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class AnnotationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnotacao;
	
	@Column(nullable = false)
	private String tituloAnotacao;
	@Column(nullable = false)
	private String conteudoAnotacao;
	@Column(nullable = false)
	private String statusAnotacao;
	private LocalDateTime dataCriacaoAnotacao = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	@JsonBackReference
	private UserEntity usuario;
	
}
