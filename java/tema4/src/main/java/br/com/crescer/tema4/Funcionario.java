package br.com.crescer.tema4;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
/**
 *
 * @author Taís
 */

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario implements Serializable {
    @Id 
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FUNCIONARIO")
    @SequenceGenerator(name = "SEQ_FUNCIONARIO", sequenceName = "SEQ_FUNCIONARIO", allocationSize = 1)
    private Long id;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    @Basic(optional = false)
    @Column(name = "BAIRRO")
    private String bairro;

    @Basic(optional = false)
    @Column(name = "CIDADE")
    private String cidade;

    @Basic(optional = false)
    @Column(name = "NUMERO_CASA")
    private String numeroCasa;

    @Basic(optional = false)
    @Column(name = "RUA")
    private String rua;

    @Basic(optional = false)
    @Column(name = "RG")
    private String rg;

    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;

    @Basic(optional = false)
    @Column(name = "TELEFONE")
    private String telefone; 

    @Basic(optional = false)
    @Column(name = "CELULAR")
    private String celular;

    @Basic(optional = false)
    @Column(name = "SALARIO")
    private BigDecimal salario;

    @Basic(optional = false)
    @Column(name = "FUNCAO")
    private String funcao;

    @Basic(optional = false)
    @Column(name = "CPF")
    private String cpf;

    @Basic(optional = false)
    @Column(name = "NASCIMENTO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;

    public Funcionario(String nome, String bairro, String cidade, String numeroCasa, String rua, String rg, String email, String telefone, String celular, BigDecimal salario, String funcao, String cpf, Date nascimento) {
        this.nome = nome;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numeroCasa = numeroCasa;
        this.rua = rua;
        this.rg = rg;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.salario = salario;
        this.funcao = funcao;
        this.cpf = cpf;
        this.nascimento = nascimento;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    
}