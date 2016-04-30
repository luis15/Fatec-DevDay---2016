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
	private Long idDenuncia;
	private String idCaso;
	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;
	private String numero;
	private String cep;
	private String geoPosicao;
	private String data;
	private String totalDenuncia;
	private String nome;

	

	public Long getIdDenuncia() {
		return idDenuncia;
	}



	public void setIdDenuncia(Long idDenuncia) {
		this.idDenuncia = idDenuncia;
	}



	public String getIdCaso() {
		return idCaso;
	}



	public void setIdCaso(String idCaso) {
		this.idCaso = idCaso;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getGeoPosicao() {
		return geoPosicao;
	}



	public void setGeoPosicao(String geoPosicao) {
		this.geoPosicao = geoPosicao;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public String getTotalDenuncia() {
		return totalDenuncia;
	}



	public void setTotalDenuncia(String totalDenuncia) {
		this.totalDenuncia = totalDenuncia;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	@Override
	public String toString() {
		return "Denuncia [endereco=" + endereco + "]";
		
	}

}