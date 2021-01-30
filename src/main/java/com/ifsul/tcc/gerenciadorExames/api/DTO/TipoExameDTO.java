package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoExame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;

public class TipoExameDTO {
    private Integer id;
    private String nomeExame;

    public TipoExameDTO() {}

    public TipoExameDTO(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public TipoExameDTO(TipoExame tipoExame) {
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
}
