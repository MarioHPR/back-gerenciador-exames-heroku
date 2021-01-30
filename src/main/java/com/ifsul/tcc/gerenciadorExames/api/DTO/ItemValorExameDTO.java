package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.ItemValorExame;

public class ItemValorExameDTO {

    private Integer id;
    private String campo;
    private String valor;
    private Integer idItemCampoExame;
    private Integer idItemValorExame;

    public ItemValorExameDTO() {}

    public ItemValorExameDTO(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public ItemValorExameDTO(ItemValorExame itemValorExame) {
        this.id = itemValorExame.getId();
        this.valor = itemValorExame.getValor();
        this.idItemValorExame = itemValorExame.getId();
        this.campo = itemValorExame.getItemCampoExame().getCampo();
        this.idItemCampoExame = itemValorExame.getItemCampoExame().getId();
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

    public Integer getIdItemCampoExame() {
        return idItemCampoExame;
    }

    public void setIdItemCampoExame(Integer idItemCampoExame) {
        this.idItemCampoExame = idItemCampoExame;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Integer getIdItemValorExame() {
        return idItemValorExame;
    }

    public void setIdItemValorExame(Integer idItemValorExame) {
        this.idItemValorExame = idItemValorExame;
    }
}
