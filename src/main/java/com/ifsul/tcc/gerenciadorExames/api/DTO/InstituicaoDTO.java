package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Instituicao;

public class InstituicaoDTO {

    private Integer id;
    private String nome;
    private String email;
    private Integer idLocalidade;
    private Integer idContato;

    public InstituicaoDTO(){}

    public InstituicaoDTO(String nome) {
        this.nome = nome;
    }

    public InstituicaoDTO(String nome, String email, Integer idLocalidade, Integer idContato) {
        this.nome = nome;
        this.email = email;
        this.idLocalidade = idLocalidade;
        this.idContato = idContato;
    }

    public InstituicaoDTO(Instituicao instituicao) {
        this.id = instituicao.getId();
        this.nome = instituicao.getNome();
        this.email = instituicao.getUsuario().getEmail();
        this.idLocalidade = instituicao.getEndereco().getId();
        this.idContato = instituicao.getContato().getId();
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Integer idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }
}
