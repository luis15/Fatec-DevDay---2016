package com.example;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@RestController
class DenunciaControlador{
	//URLs
	
	@Autowired     // instancia a classe anonima (interface)
	private DenunciaRepositorio repositorio;
	
	@RequestMapping("/denuncias")
	public List<Denuncia> buscaTodas(){
		
		return repositorio.findAll();
	}
	
	
}

interface DenunciaRepositorio extends JpaRepository<Denuncia, Long>{
	
	
	
}


@Entity
class Denuncia {
	@Id
	@GeneratedValue
	private Long id;
	private String endereco;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Denuncia [endereco=" + endereco + "]";
	}

}