package br.com.fiap.ejb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="chamado")
public class Chamado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descricao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
	@PrePersist
	public void preInsert(){
		System.out.println("Inserindo chamando no banco da dados!");
	}
	
}