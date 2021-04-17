package com.ifsul.tcc.gerenciadorExames.api.Controller.Request;

public class AlergiaRestricaoRequest {

    private String descricao;
    private String tipo;

    public AlergiaRestricaoRequest() {}

    public AlergiaRestricaoRequest(String descricao, String tipo) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
