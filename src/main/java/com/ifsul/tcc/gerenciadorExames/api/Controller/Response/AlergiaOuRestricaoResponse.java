package com.ifsul.tcc.gerenciadorExames.api.Controller.Response;

import com.ifsul.tcc.gerenciadorExames.api.Entity.AlergiasRestricoes;

public class AlergiaOuRestricaoResponse {
    private Integer id;
    private String tipo;
    private String descricao;

    public AlergiaOuRestricaoResponse(){}

    public AlergiaOuRestricaoResponse(Integer id, String tipo, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public AlergiaOuRestricaoResponse(AlergiasRestricoes restricao) {
        this.id = restricao.getId();
        this.tipo = restricao.getTipo();
        this.descricao = restricao.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
