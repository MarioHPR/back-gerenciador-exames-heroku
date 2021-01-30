package com.ifsul.tcc.gerenciadorExames.api.Controller.Response;

import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosInstituicaoRequest;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Consulta;

import java.time.LocalDate;

public class DadosConsultaResponse {

    private String nomeMedico;
    private LocalDate dataConsulta;
    private String diagnostico;
    private String prescricao;
    private String linkImage;
    private DadosInstituicaoRequest dadosInstituicao;

    public DadosConsultaResponse() {}

    public DadosConsultaResponse(String nomeMedico, LocalDate dataConsulta, String diagnostico, String prescricao, String linkImage, DadosInstituicaoRequest dadosInstituicao) {
        this.nomeMedico = nomeMedico;
        this.dataConsulta = dataConsulta;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.linkImage = linkImage;
        this.dadosInstituicao = dadosInstituicao;
    }

    public DadosConsultaResponse(Consulta consulta) {
        this.nomeMedico = consulta.getNomeMedico();
        this.dataConsulta = consulta.getDataConsulta();
        this.diagnostico = consulta.getDiagnostico();
        this.prescricao = consulta.getPrescricao();
        this.linkImage = consulta.getLinkImage();
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

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public DadosInstituicaoRequest getDadosInstituicao() {
        return dadosInstituicao;
    }

    public void setDadosInstituicao(DadosInstituicaoRequest dadosInstituicao) {
        this.dadosInstituicao = dadosInstituicao;
    }
}
