package com.ifsul.tcc.gerenciadorExames.api.Controller.Response;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ContatoDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.EnderecoDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;

import java.time.LocalDate;

public class DadosUsuarioResponse {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private String contatoUm;
    private String contatoDois;
    private String cidade;
    private String cep;
    private String bairro;
    private String rua;
    private int numero;

    public DadosUsuarioResponse() {}

    public DadosUsuarioResponse(Usuario usuario, EnderecoDTO endereco, ContatoDTO contatoDTO) {
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.contatoUm = contatoDTO.getContatoUm();
        this.contatoDois = contatoDTO.getContatoDois();
        this.cidade = endereco.getCidade();
        this.cep = endereco.getCep();
        this.bairro = endereco.getBairro();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public ContatoDTO retornarContatoDTO() {
        return new ContatoDTO(this.contatoUm, this.contatoDois);
    }

    public EnderecoDTO retornarEnderecoDTO() {
        return new EnderecoDTO(this.cidade, this.cep, this.bairro, this.rua, this.numero);
    }
}
