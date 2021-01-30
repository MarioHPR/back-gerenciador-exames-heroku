package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Contato;

public class ContatoDTO {
    private Integer id;
    private String contatoUm;
    private String contatoDois;

    public ContatoDTO(){}

    public ContatoDTO(String contatoUm, String contatoDois) {
        this.contatoUm = contatoUm;
        this.contatoDois = contatoDois;
    }

    public ContatoDTO(Contato contato) {
        this.id = contato.getId();
        this.contatoUm = contato.getContatoUm();
        this.contatoDois = contato.getContatoDois();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContatoUm() {
        return contatoUm;
    }

    public void setContatoUm(String contatoUm) {
        this.contatoUm = contatoUm;
    }

    public String getContatoDois() {
        return contatoDois;
    }

    public void setContatoDois(String contatoDois) {
        this.contatoDois = contatoDois;
    }
}
