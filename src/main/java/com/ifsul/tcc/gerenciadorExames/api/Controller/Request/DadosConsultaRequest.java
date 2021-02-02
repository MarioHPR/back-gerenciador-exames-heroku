package com.ifsul.tcc.gerenciadorExames.api.Controller.Request;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Consulta;

import java.time.LocalDate;

public class DadosConsultaRequest {

    private String nomeMedico;
    private LocalDate dataConsulta;
    private String diagnostico;
    private String prescricao;
    private Long idArquivo;
    private DadosInstituicaoRequest dadosInstituicao;

    public DadosConsultaRequest() {}

    public DadosConsultaRequest(String nomeMedico, LocalDate dataConsulta, String diagnostico, String prescricao, Long idArquivo, DadosInstituicaoRequest dadosInstituicao) {
        this.nomeMedico = nomeMedico;
        this.dataConsulta = dataConsulta;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.idArquivo = idArquivo;
        this.dadosInstituicao = dadosInstituicao;
    }

    public DadosConsultaRequest(Consulta consulta) {
        this.nomeMedico = consulta.getNomeMedico();
        this.dataConsulta = consulta.getDataConsulta();
        this.diagnostico = consulta.getDiagnostico();
        this.prescricao = consulta.getPrescricao();
        this.idArquivo = consulta.getIdArquivo();
        this.dadosInstituicao = new DadosInstituicaoRequest(consulta.getInstituicao());
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
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
}
