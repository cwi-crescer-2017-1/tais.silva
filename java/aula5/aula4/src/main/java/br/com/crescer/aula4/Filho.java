package br.com.crescer.aula4;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author carloshenrique
 */
@Entity
public class Filho {

    @Id // Identifica a PK
    @Basic(optional = false)
    @Column(name = "ID_FILHO")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NM_FILHO")
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;

    public Filho() {
    }

    public Filho(Long id, String nome) {
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
