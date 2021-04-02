package com.ifsul.tcc.gerenciadorExames.api.Controller.Request;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ContatoDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.EnderecoDTO;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class DadosUsuarioRequest {
    private Integer id;
    @NotNull(message = "Nome é obrigatório!")
    private String nome;
    @NotNull(message = "Cpf é obrigatório!")
    private String cpf;
    @NotNull(message = "Data nascimento é obrigatório!")
    private LocalDate dataNascimento;
    @NotNull(message = "Email é obrigatório!")
    private String email;
    @NotNull(message = "Senha é obrigatório!")
    private String senha;
    @NotNull(message = "Contato principal é obrigatório!")
    private String contatoUm;
    @NotNull(message = "Contato secundario é obrigatório!")
    private String contatoDois;
    @NotNull(message = "Cidade é obrigatório!")
    private String cidade;
    @NotNull(message = "Cep é obrigatório!")
    private String cep;
    @NotNull(message = "Bairro é obrigatório!")
    private String bairro;
    @NotNull(message = "Rua é obrigatório!")
    private String rua;
    @NotNull(message = "Número é obrigatório!")
    private int numero;

    public DadosUsuarioRequest() {}

    public DadosUsuarioRequest(String nome, String cpf, LocalDate dataNascimento, String email, String senha, String contatoUm, String contatoDois, String cidade, String cep, String bairro, String rua, int numero) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.contatoUm = contatoUm;
        this.contatoDois = contatoDois;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
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
