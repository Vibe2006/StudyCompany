package project.studyCompany.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(nullable = false)
	private String nomeUsuario;
	@Column(nullable = false)
	private String cpfUsuario;
	
	@Column(nullable = false)
	private LocalDate dataNascUsuario;

	private LocalDateTime dataCriacaoContaUsuario = LocalDateTime.now();
	
	@Column(nullable = false)
	private String emailUsuario;
	@Column(nullable = false)
	private String senhaUsuario;
	@Column(nullable = false)
	private String userUsuario;
	@Column(nullable = false)
	private String statusUsuario; //se o usuário está ativo, inativo ou bloqueado
	@Column(nullable = false)
	private String tipoUsuario; //se o usuário eh normal ou adm
	
	
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<UserPhoneNumberEntity> telefones;
	
}
