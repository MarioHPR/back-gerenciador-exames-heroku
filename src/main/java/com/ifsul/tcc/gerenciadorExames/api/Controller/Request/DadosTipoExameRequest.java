package com.ifsul.tcc.gerenciadorExames.api.Controller.Request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DadosTipoExameRequest {

    private String nomeExame;
    private Long idArquivo;
    private LocalDate dataExame;

    private List<String> campo;
    private List<String> valor;

    private DadosInstituicaoRequest dadosInstituicao;

    public DadosTipoExameRequest() {}

    public DadosTipoExameRequest(String nomeExame, Long idArquivo, LocalDate dataExame, List<String> campo, List<String> valor, DadosInstituicaoRequest dadosInstituicao) {
        this.nomeExame = nomeExame;
        this.idArquivo = idArquivo;
        this.dataExame = dataExame;
        this.campo = campo;
        this.valor = valor;
        this.dadosInstituicao = dadosInstituicao;
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

    public List<String> getCampo() {
        return campo;
    }

    public void setCampo(List<String> campo) {
        this.campo = campo;
    }

    public List<String> getValor() {
        return valor;
    }

    public void setValor(List<String> valor) {
        this.valor = valor;
    }

    public DadosInstituicaoRequest getDadosInstituicao() {
        return dadosInstituicao;
    }

    public void setDadosInstituicao(DadosInstituicaoRequest dadosInstituicao) {
        this.dadosInstituicao = dadosInstituicao;
    }
}
