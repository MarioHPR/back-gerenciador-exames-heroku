package com.ifsul.tcc.gerenciadorExames.api.Controller.Request;

public class ParametrosExameRequest {

    private String campo;
    private String valor;
    private Integer idItemCampoExame;
    private Integer idItemValorExame;

    public ParametrosExameRequest() {}

    public ParametrosExameRequest(String campo, String valor) {
        this.campo = campo;
        this.valor = valor;
    }

    public ParametrosExameRequest(String campo, String valor, Integer idItemCampoExame, Integer idItemValorExame) {
        this.campo = campo;
        this.valor = valor;
        this.idItemCampoExame = idItemCampoExame;
        this.idItemValorExame = idItemValorExame;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
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

    public Integer getIdItemValorExame() {
        return idItemValorExame;
    }

    public void setIdItemValorExame(Integer idItemValorExame) {
        this.idItemValorExame = idItemValorExame;
    }
}
