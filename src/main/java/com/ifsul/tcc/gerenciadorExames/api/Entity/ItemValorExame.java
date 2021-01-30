package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ItemValorExameDTO;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ItemValorExame {
    @Id
    @SequenceGenerator(name = "ITEM_VALOR_EXAME_SEQ", sequenceName = "ITEM_VALOR_EXAME_SEQ")
    @GeneratedValue(generator = "ITEM_VALOR_EXAME_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String valor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Exame exame;

    @ManyToOne(cascade = CascadeType.ALL)
    private ItemCampoExame itemCampoExame;

    public ItemValorExame() {}

    public ItemValorExame(String valor) {
        this.valor = valor;
    }

    public ItemValorExame(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public ItemValorExame(ItemValorExameDTO itemValorExameDTO) {
        this.id = itemValorExameDTO.getId();
        this.valor = itemValorExameDTO.getValor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ItemCampoExame getItemCampoExame() {
        return itemCampoExame;
    }

    public void setItemCampoExame(ItemCampoExame itemCampoExame) {
        this.itemCampoExame = itemCampoExame;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }


}
