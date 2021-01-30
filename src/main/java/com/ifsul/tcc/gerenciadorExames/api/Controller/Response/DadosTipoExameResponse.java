package com.ifsul.tcc.gerenciadorExames.api.Controller.Response;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ItemCampoExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoExame;

import java.util.List;

public class DadosTipoExameResponse {
    private Integer id;
    private String nomeExame;
    private List<ItemCampoExameDTO> itensCampo;

    public DadosTipoExameResponse() {}

    public DadosTipoExameResponse(TipoExame tipoExame, List<ItemCampoExameDTO> itensCampo) {
        this.id = tipoExame.getId();
        this.nomeExame = tipoExame.getNomeExame();
        this.itensCampo = itensCampo;
    }

    public DadosTipoExameResponse(Integer id, String nomeExame) {
        this.id = id;
        this.nomeExame = nomeExame;
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

    public List<ItemCampoExameDTO> getItensCampo() {
        return itensCampo;
    }

    public void setItensCampo(List<ItemCampoExameDTO> itensCampo) {
        this.itensCampo = itensCampo;
    }
}
