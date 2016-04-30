package com.example;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@RestController
class DenunciaControlador {
	// URLs

	@Autowired // instancia a classe anonima (interface)
	private DenunciaRepositorio repositorio;

	@RequestMapping("/denuncias")
	public List<Denuncia> buscaTodas() {
		return repositorio.findAll();
	}

	@RequestMapping(name = "/denuncias", method = RequestMethod.POST)
	public void cadastra(Denuncia denuncia) {
		repositorio.save(denuncia);
	}

	@RequestMapping(name = "/denuncias", method = RequestMethod.PUT)
	public void atualiza(Denuncia denuncia) {
		repositorio.save(denuncia);
	}

	@RequestMapping(name = "/denuncias", method = RequestMethod.DELETE)
	public void remove(Denuncia denuncia) {
		repositorio.delete(denuncia);
	}
}

interface DenunciaRepositorio extends JpaRepository<Denuncia, Long> {

}

@Entity
class Denuncia implements Serializable {
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
	private String geo;
	private String data;
	private String total;
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

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Denuncia [endereco=" + estado + cidade + estado + logradouro + numero + cep + data + total + geo +"]";

	}

}