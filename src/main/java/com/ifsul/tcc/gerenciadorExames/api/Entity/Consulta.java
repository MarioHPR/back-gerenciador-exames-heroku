package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosConsultaRequest;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ConsultaDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance( strategy = InheritanceType.JOINED)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Consulta {

    @Id
    @SequenceGenerator(name = "CONSULTA_SEQ", sequenceName = "CONSULTA_SEQ")
    @GeneratedValue(generator = "CONSULTA_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String diagnostico;

    @Column(nullable = false)
    private String prescricao;

    @Column(nullable = false)
    private String nomeMedico;

    private Long idArquivo;

    @Column(nullable = false)
    private LocalDate dataConsulta;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Instituicao instituicao;

    public Consulta() {}

    public Consulta(String diagnostico, String prescricao, String nomeMedico, Long idArquivo, LocalDate dataConsulta) {
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.nomeMedico = nomeMedico;
        this.idArquivo = idArquivo;
        this.dataConsulta = dataConsulta;
    }

    public Consulta( ConsultaDTO consultaDTO ) {
        this.diagnostico = consultaDTO.getDiagnostico();
        this.prescricao = consultaDTO.getPrescricao();
        this.nomeMedico = consultaDTO.getNomeMedico();
        this.idArquivo = consultaDTO.getIdArquivo();
        this.dataConsulta = consultaDTO.getDataConsulta();
    }

    public Consulta(DadosConsultaRequest dados) {
        this.diagnostico = dados.getDiagnostico();
        this.prescricao = dados.getPrescricao();
        this.nomeMedico = dados.getNomeMedico();
        this.idArquivo = dados.getIdArquivo();
        this.dataConsulta = dados.getDataConsulta();
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
