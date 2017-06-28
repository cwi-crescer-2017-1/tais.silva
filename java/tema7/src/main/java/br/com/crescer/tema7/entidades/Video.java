package br.com.crescer.tema7.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Taís
 */
@Entity
@Table(name = "VIDEO")
public class Video implements Serializable {
    @Id 
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO", allocationSize = 1)
    private Long id;

    @Basic(optional = false)
    @Column(name = "VALOR")
    private BigDecimal valor;

    @Basic(optional = false)
    @Column(name = "DURACAO")
    private String duracao;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    @Basic(optional = false)
    @Column(name = "QUANTIDADE_ESTOQUE")
    private Long quantidadeEstoque;

    @Basic(optional = false)
    @Column(name = "DATA_LANCAMENTO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataLancamento;

    @ManyToOne
    @JoinColumn(name = "ID_GENERO",
            foreignKey = @ForeignKey(name = "FK_LOCACAO_GENERO"))
    private Genero genero;

    public Video() {
    }

    public Video(BigDecimal valor, String duracao, String nome, Long quantidadeEstoque, Date dataLancamento, Genero genero) {
        this.valor = valor;
        this.duracao = duracao;
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataLancamento = dataLancamento;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Long quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    
}