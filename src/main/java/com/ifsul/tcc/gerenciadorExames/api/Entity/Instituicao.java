package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ifsul.tcc.gerenciadorExames.api.DTO.InstituicaoDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Instituicao {

    @Id
    @SequenceGenerator(name = "INSTITUICAO_SEQ", sequenceName = "INSTITUICAO_SEQ")
    @GeneratedValue(generator = "INSTITUICAO_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;

    @OneToMany(mappedBy = "instituicao")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "instituicao", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Exame> exames;

    @ManyToOne
    private Usuario usuario;

    public Instituicao() {}

    public Instituicao(String nome) {
        this.nome = nome;
    }

    public Instituicao(InstituicaoDTO instituicaoDTO) {
        this.nome = instituicaoDTO.getNome();
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }
}
