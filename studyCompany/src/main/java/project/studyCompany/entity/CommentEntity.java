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
public class CommentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComentario;
	
	@Column(nullable = false)
	private String conteudoComentario;
	@Column(nullable = false)
	private String statusComentario;
	
	
	private LocalDateTime dataCriacaoContaUsuario = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	@JsonBackReference
	private UserEntity usuario;
	
	
	@ManyToOne
	@JoinColumn(name = "idAnotacao")
	@JsonBackReference
	private UserEntity anotacao;


}
