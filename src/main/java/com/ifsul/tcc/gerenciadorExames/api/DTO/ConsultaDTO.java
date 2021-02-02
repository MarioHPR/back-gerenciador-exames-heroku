package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Consulta;

import java.time.LocalDate;

public class ConsultaDTO {

    private Integer id;
    private String diagnostico;
    private String prescricao;
    private String nomeMedico;
    private Long idArquivo;
    private Integer idInstituicao;
    private LocalDate dataConsulta;

    public ConsultaDTO() {}

    public ConsultaDTO(Integer id, String diagnostico, String prescricao, String nomeMedico, Long idArquivo, LocalDate dataConsulta, Integer idInstituicao) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.nomeMedico = nomeMedico;
        this.idArquivo = idArquivo;
        this.dataConsulta = dataConsulta;
        this.idInstituicao = idInstituicao;
    }

    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.diagnostico = consulta.getDiagnostico();
        this.prescricao = consulta.getPrescricao();
        this.nomeMedico = consulta.getNomeMedico();
        this.idArquivo = consulta.getIdArquivo();
        this.dataConsulta = consulta.getDataConsulta();
        this.idInstituicao = consulta.getInstituicao().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public Long getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(Long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Integer getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(Integer idInstituicao) {
        this.idInstituicao = idInstituicao;
    }
}
