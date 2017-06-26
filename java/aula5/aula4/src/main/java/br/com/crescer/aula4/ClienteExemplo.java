package br.com.crescer.aula4;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author carloshenrique
 */
@Entity
public class ClienteExemplo {

    @Id // Identifica a PK
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NM_CLIENTE")
    private String nome;

    public ClienteExemplo() {
    }

    public ClienteExemplo(Long id, String nome) {
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
