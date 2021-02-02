package com.ifsul.tcc.gerenciadorExames.api.Controller.Request;

import java.time.LocalDate;
import java.util.List;

public class DadosExameRequest {

    private Long idArquivo;
    private LocalDate dataExame;
    private Integer idTipoExame;
    private Integer idInstituicao;

    private List<String> campo;
    private List<String> valor;

    public DadosExameRequest() {}

    public DadosExameRequest(Long idArquivo, LocalDate dataExame, Integer idTipoExame, Integer idInstituicao) {
        this.idArquivo = idArquivo;
        this.dataExame = dataExame;
        this.idTipoExame = idTipoExame;
        this.idInstituicao = idInstituicao;
    }
    public DadosExameRequest(Long idArquivo, LocalDate dataExame, Integer idTipoExame, Integer idInstituicao, List<String> campo, List<String> valor) {
        this.idArquivo = idArquivo;
        this.dataExame = dataExame;
        this.idTipoExame = idTipoExame;
        this.idInstituicao = idInstituicao;
        this.campo = campo;
        this.valor = valor;
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

    public Integer getIdTipoExame() {
        return idTipoExame;
    }

    public void setIdTipoExame(Integer idTipoExame) {
        this.idTipoExame = idTipoExame;
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
