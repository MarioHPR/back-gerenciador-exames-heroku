package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Endereco;

public class EnderecoDTO {

    private Integer id;
    private String cidade;
    private String cep;
    private String bairro;
    private String rua;
    private int numero;
    private Boolean flgEnderecoDoUsuario;

    public EnderecoDTO() {}

    public EnderecoDTO(String cidade, String cep, String bairro, String rua, int numero) {
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public EnderecoDTO(String cidade, String cep, String bairro, String rua, int numero, Boolean flgEnderecoDoUsuario) {
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.flgEnderecoDoUsuario = flgEnderecoDoUsuario;
    }

    public EnderecoDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.cidade = endereco.getCidade();
        this.cep = endereco.getCep();
        this.bairro = endereco.getBairro();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.flgEnderecoDoUsuario = endereco.getFlgEnderecoDoUsuario();
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

    public Boolean getFlgEnderecoDoUsuario() {
        return flgEnderecoDoUsuario;
    }

    public void setFlgEnderecoDoUsuario(Boolean flgEnderecoDoUsuario) {
        this.flgEnderecoDoUsuario = flgEnderecoDoUsuario;
    }
}
