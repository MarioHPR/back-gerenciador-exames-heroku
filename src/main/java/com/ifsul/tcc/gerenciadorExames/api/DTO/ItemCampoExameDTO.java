package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.ItemCampoExame;

public class ItemCampoExameDTO {

    private Integer id;
    private String campo;
    private Integer idTipoExame;

    public ItemCampoExameDTO() {}

    public ItemCampoExameDTO(Integer id, String campo) {
        this.id = id;
        this.campo = campo;
    }

    public ItemCampoExameDTO(ItemCampoExame itemCampoExame) {
        this.id = itemCampoExame.getId();
        this.campo = itemCampoExame.getCampo();
        this.idTipoExame = itemCampoExame.getTipoExame().getId();
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

    public Integer getIdTipoExame() {
        return idTipoExame;
    }

    public void setIdTipoExame(Integer idTipoExame) {
        this.idTipoExame = idTipoExame;
    }

}
