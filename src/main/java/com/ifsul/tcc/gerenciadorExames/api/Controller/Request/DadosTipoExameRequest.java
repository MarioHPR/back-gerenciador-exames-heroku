package com.ifsul.tcc.gerenciadorExames.api.Controller.Request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DadosTipoExameRequest {

    private String nomeExame;
    private Long idArquivo;
    private LocalDate dataExame;
    private Integer idInstituicao;

    private List<String> campo;
    private List<String> valor;

    public DadosTipoExameRequest() {}

    public DadosTipoExameRequest(String nomeExame, Long idArquivo, LocalDate dataExame, Integer idInstituicao, List<String> campo, List<String> valor) {
        this.nomeExame = nomeExame;
        this.idArquivo = idArquivo;
        this.dataExame = dataExame;
        this.idInstituicao = idInstituicao;
        this.campo = campo;
        this.valor = valor;
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

    public Integer getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(Integer idInstituicao) {
        this.idInstituicao = idInstituicao;
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
}
