package br.com.crescer.aula4;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author carloshenrique
 */
@Entity
public class Pessoa {

    @Id // Identifica a PK
    @Basic(optional = false)
    private Long id;

    @Basic(optional = false)
    private String nome;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
