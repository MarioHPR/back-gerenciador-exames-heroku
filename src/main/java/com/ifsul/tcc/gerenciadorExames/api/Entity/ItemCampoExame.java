package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ItemCampoExameDTO;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ItemCampoExame {

    @Id
    @SequenceGenerator(name = "ITEM_CAMPO_EXAME_SEQ", sequenceName = "ITEM_CAMPO_EXAME_SEQ")
    @GeneratedValue(generator = "ITEM_CAMPO_EXAME_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String campo;

    @ManyToOne
    private TipoExame tipoExame;

    @ManyToOne(cascade = CascadeType.ALL)
    private Exame exame;

    public ItemCampoExame() {}

    public ItemCampoExame(String campo) {
        this.campo = campo;
    }

    public ItemCampoExame(Integer id, String campo) {
        this.id = id;
        this.campo = campo;
    }

    public ItemCampoExame(ItemCampoExameDTO itemCampoExameDTO) {
        this.id = itemCampoExameDTO.getId();
        this.campo = itemCampoExameDTO.getCampo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public TipoExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoExame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }
}
