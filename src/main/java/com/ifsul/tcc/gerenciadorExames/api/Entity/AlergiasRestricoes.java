package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.AlergiaRestricaoRequest;

import javax.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.JOINED)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class AlergiasRestricoes {

    @Id
    @SequenceGenerator(name = "ALERGIARESTRICAO_SEQ", sequenceName = "ALERGIARESTRICAO_SEQ")
    @GeneratedValue(generator = "ALERGIARESTRICAO_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public AlergiasRestricoes() {}

    public AlergiasRestricoes(String descricao) {
        this.descricao = descricao;
    }

    public AlergiasRestricoes(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public AlergiasRestricoes(AlergiaRestricaoRequest alergiaOuRestricao) {
        this.tipo = alergiaOuRestricao.getTipo();
        this.descricao = alergiaOuRestricao.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
