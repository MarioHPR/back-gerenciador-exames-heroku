package com.ifsul.tcc.gerenciadorExames.api.Controller.Request;

public class NewDadosInstituicaoRequest {

    private Integer id;
    private String nome;
    private String contatoUm;
    private String contatoDois;
    private Boolean flgContatoUsuario;
    private String cidade;
    private String cep;
    private String bairro;
    private String rua;
    private int numero;
    private Boolean flgEnderecoDoUsuario;

    public NewDadosInstituicaoRequest() {}

    public NewDadosInstituicaoRequest(Integer id) {
        this.id = id;
    }

    public NewDadosInstituicaoRequest(Integer id, String nome, String contatoUm, String contatoDois, Boolean flgContatoUsuario, String cidade, String cep, String bairro, String rua, int numero, Boolean flgEnderecoDoUsuario) {
        this.id = id;
        this.nome = nome;
        this.contatoUm = contatoUm;
        this.contatoDois = contatoDois;
        this.flgContatoUsuario = flgContatoUsuario;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.flgEnderecoDoUsuario = flgEnderecoDoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContatoUm() {
        return contatoUm;
    }

    public void setContatoUm(String contatoUm) {
        this.contatoUm = contatoUm;
    }

    public String getContatoDois() {
        return contatoDois;
    }

    public void setContatoDois(String contatoDois) {
        this.contatoDois = contatoDois;
    }

    public Boolean getFlgContatoUsuario() {
        return flgContatoUsuario;
    }

    public void setFlgContatoUsuario(Boolean flgContatoUsuario) {
        this.flgContatoUsuario = flgContatoUsuario;
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
