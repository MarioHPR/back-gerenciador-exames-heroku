package com.ifsul.tcc.gerenciadorExames.api.Controller.Response;

import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoExame;

public class TipoExameResponse {
    private Integer id;
    private String nomeExame;
    private Integer quantidade;


    public TipoExameResponse() {}

    public TipoExameResponse(Integer id, String nomeExame, Integer quantidade) {
        this.id = id;
        this.nomeExame = nomeExame;
        this.quantidade = quantidade;
    }

    public TipoExameResponse(TipoExame tipoExame) {
        this.id = tipoExame.getId();
        this.nomeExame = tipoExame.getNomeExame();
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
