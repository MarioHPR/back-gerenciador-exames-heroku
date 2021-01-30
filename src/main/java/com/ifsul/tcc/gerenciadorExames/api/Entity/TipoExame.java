package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ifsul.tcc.gerenciadorExames.api.DTO.TipoExameDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance( strategy = InheritanceType.JOINED)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TipoExame {

    @Id
    @SequenceGenerator(name = "TIPO_EXAME_SEQ", sequenceName = "TIPO_EXAME_SEQ")
    @GeneratedValue(generator = "TIPO_EXAME_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String nomeExame;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "tipoExame", cascade = CascadeType.ALL)
    private List<Exame> exames;

    @OneToMany(mappedBy = "tipoExame", cascade = CascadeType.ALL)
    private List<ItemCampoExame> itemCampoExames;

    public TipoExame() {}

    public TipoExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public TipoExame(Integer id, String nomeExame) {
        this.id = id;
        this.nomeExame = nomeExame;
    }

    public TipoExame(TipoExameDTO tipoExameDTO) {
        this.nomeExame = tipoExameDTO.getNomeExame();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public List<ItemCampoExame> getItemCampoExames() {
        return itemCampoExames;
    }

    public void setItemCampoExames(List<ItemCampoExame> itemCampoExames) {
        this.itemCampoExames = itemCampoExames;
    }
}
