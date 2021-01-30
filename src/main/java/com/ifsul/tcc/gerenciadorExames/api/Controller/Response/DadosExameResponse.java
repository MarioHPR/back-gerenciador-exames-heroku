package com.ifsul.tcc.gerenciadorExames.api.Controller.Response;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ItemValorExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;

import java.util.List;

public class DadosExameResponse {
    private ExameDTO exameDTO;
    private List<ItemValorExameDTO> itemValorExameDTO;

    public DadosExameResponse(){}

    public DadosExameResponse( ExameDTO exameDTO, List<ItemValorExameDTO> itemValorExameDTO) {
        this.exameDTO = exameDTO;
        this.itemValorExameDTO = itemValorExameDTO;
    }

    public DadosExameResponse(Exame exame, List<ItemValorExameDTO> valores) {
        this.exameDTO = new ExameDTO(exame);
        this.itemValorExameDTO = valores;
    }

    public ExameDTO getExameDTO() {
        return exameDTO;
    }

    public void setExameDTO(ExameDTO exameDTO) {
        this.exameDTO = exameDTO;
    }

    public List<ItemValorExameDTO> getItemValorExameDTO() {
        return itemValorExameDTO;
    }

    public void setItemValorExameDTO(List<ItemValorExameDTO> itemValorExameDTO) {
        this.itemValorExameDTO = itemValorExameDTO;
    }
}
