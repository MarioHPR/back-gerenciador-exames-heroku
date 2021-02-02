package com.ifsul.tcc.gerenciadorExames.api.Controller.Request;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ItemValorExameDTO;

import java.time.LocalDate;
import java.util.List;

public class DadosExameEditRequest {

    private String tipoExame;
    private LocalDate dataExame;
    private Long idArquivo;
    private DadosInstituicaoRequest dadosInstituicao;
    private List<ItemValorExameDTO> parametros;

    public DadosExameEditRequest() {}

    public DadosExameEditRequest(String tipoExame, LocalDate dataExame, Long idArquivo, DadosInstituicaoRequest dadosInstituicao, List<ItemValorExameDTO> parametros) {
        this.tipoExame = tipoExame;
        this.dataExame = dataExame;
        this.idArquivo = idArquivo;
        this.dadosInstituicao = dadosInstituicao;
        this.parametros = parametros;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public LocalDate getDataExame() {
        return dataExame;
    }

    public void setDataExame(LocalDate dataExame) {
        this.dataExame = dataExame;
    }

    public Long getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(Long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public DadosInstituicaoRequest getDadosInstituicao() {
        return dadosInstituicao;
    }

    public void setDadosInstituicao(DadosInstituicaoRequest dadosInstituicao) {
        this.dadosInstituicao = dadosInstituicao;
    }

    public List<ItemValorExameDTO> getParametros() {
        return parametros;
    }

    public void setParametros(List<ItemValorExameDTO> parametros) {
        this.parametros = parametros;
    }
}
