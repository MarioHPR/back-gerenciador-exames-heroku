package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ContatoDTO;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Contato {
    @Id
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "CONTATO_SEQ")
    @GeneratedValue(generator = "CONTATO_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String contatoUm;

    @Column(nullable = false)
    private String contatoDois;

    @ManyToOne
    private Usuario usuario;

    public Contato(){}

    public Contato(String contatoUm, String contatoDois) {
        this.contatoUm = contatoUm;
        this.contatoDois = contatoDois;
    }

    public Contato(ContatoDTO contatoDTO) {
        this.contatoUm = contatoDTO.getContatoUm();
        this.contatoDois = contatoDTO.getContatoDois();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
