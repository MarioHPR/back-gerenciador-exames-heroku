package com.ifsul.tcc.gerenciadorExames.api.Controller.Response;

import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosInstituicaoRequest;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ItemValorExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;

import java.time.LocalDate;
import java.util.List;

public class ExameResponse {

    private Integer id;
    private String nomeExame;
    private Long idArquivo;
    private LocalDate dataExame;
    private DadosInstituicaoRequest dadosInstituicao;
    private List<ItemValorExameDTO> parametros;
    private Boolean flgDeleted;

    public ExameResponse() {}

    public ExameResponse(Integer id, String nomeExame, Long idArquivo, LocalDate dataExame, DadosInstituicaoRequest dadosInstituicao, List<ItemValorExameDTO> parametros) {
        this.id = id;
        this.nomeExame = nomeExame;
        this.idArquivo = idArquivo;
        this.dataExame = dataExame;
        this.dadosInstituicao = dadosInstituicao;
        this.parametros = parametros;
    }

    public ExameResponse(Exame exame) {
        this.id = exame.getId();
        this.nomeExame = exame.getTipoExame().getNomeExame();
        this.idArquivo = exame.getIdArquivo();
        this.dataExame = exame.getDataExame();
        this.dadosInstituicao = new DadosInstituicaoRequest(exame.getInstituicao());
        this.flgDeleted = exame.getFlgDeleted();
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

    public Long getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(Long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public LocalDate getDataExame() {
        return dataExame;
    }

    public void setDataExame(LocalDate dataExame) {
        this.dataExame = dataExame;
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

    public Boolean getFlgDeleted() {
        return flgDeleted;
    }

    public void setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
    }
}
