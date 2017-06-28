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
@Table(name = "LOCACAO")
public class Locacao implements Serializable {
    @Id 
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LOCACAO")
    @SequenceGenerator(name = "SEQ_LOCACAO", sequenceName = "SEQ_LOCACAO", allocationSize = 1)
    private Long id;

    @Basic(optional = false)
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO",
            foreignKey = @ForeignKey(name = "FK_LOCACAO_FUNCIONARIO"))
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE",
            foreignKey = @ForeignKey(name = "FK_LOCACAO_CLIENTE"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_VIDEO",
            foreignKey = @ForeignKey(name = "FK_LOCACAO_VIDEO"))
    private Video video;

    @Basic(optional = false)
    @Column(name = "DATA_DEVOLUCAO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDevolucao;

    public Locacao() {
    }

    public Locacao(BigDecimal valorTotal, Funcionario funcionario, Cliente cliente, Video video, Date dataDevolucao) {
        this.valorTotal = valorTotal;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.video = video;
        this.dataDevolucao = dataDevolucao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    
}