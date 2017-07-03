/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tais.silva
 */
@Entity
@Table(name = "AMIZADE")
@NamedQueries({
    @NamedQuery(name = "Amizade.findAll", query = "SELECT a FROM Amizade a")})
public class Amizade implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_AMIZADE")
    @SequenceGenerator(name = "SEQ_AMIZADE", sequenceName = "SEQ_AMIZADE", allocationSize = 1)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_ATUAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SITUACAO")
    private Character situacao;
    @JoinColumn(name = "SOLICITANTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario solicitante;
    @JoinColumn(name = "SOLICITADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario solicitado;

    public Amizade() {
    }

    public Amizade(Long id) {
        this.id = id;
    }

    public Amizade(Long id, Date dataAtual, Character situacao) {
        this.id = id;
        this.dataAtual = dataAtual;
        this.situacao = situacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public Usuario getSolicitado() {
        return solicitado;
    }

    public void setSolicitado(Usuario solicitado) {
        this.solicitado = solicitado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amizade)) {
            return false;
        }
        Amizade other = (Amizade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entidade.Amizade[ id=" + id + " ]";
    }
    
}
