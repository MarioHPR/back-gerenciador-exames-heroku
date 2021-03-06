package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.ifsul.tcc.gerenciadorExames.api.DTO.EnderecoDTO;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @SequenceGenerator(name = "LOCALIDADE_SEQ", sequenceName = "LOCALIDADE_SEQ")
    @GeneratedValue(generator = "LOCALIDADE_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private int numero;

    private Boolean flgEnderecoDoUsuario = Boolean.FALSE;

    // chaves estrangeiras
    @OneToOne
    private Usuario usuario;

    public Endereco() {}

    public Endereco(String cidade, String cep, String bairro, String rua, int numero) {
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public Endereco(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.getId();
        this.cidade = enderecoDTO.getCidade();
        this.cep = enderecoDTO.getCep();
        this.bairro = enderecoDTO.getBairro();
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
        this.flgEnderecoDoUsuario = enderecoDTO.getFlgEnderecoDoUsuario();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getFlgEnderecoDoUsuario() {
        return flgEnderecoDoUsuario;
    }

    public void setFlgEnderecoDoUsuario(Boolean flgEnderecoDoUsuario) {
        this.flgEnderecoDoUsuario = flgEnderecoDoUsuario;
    }
}
