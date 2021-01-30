package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;

import java.time.LocalDate;

public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String senha;

    public UsuarioDTO() {}

    public UsuarioDTO(Usuario usuario) {
        this.id    = usuario.getId();
        this.nome  = usuario.getNome();
        this.cpf   = usuario.getCpf();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.dataNascimento = usuario.getDataNascimento();
    }

    public UsuarioDTO(String nome, String cpf, LocalDate dataNascimento, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
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
}
