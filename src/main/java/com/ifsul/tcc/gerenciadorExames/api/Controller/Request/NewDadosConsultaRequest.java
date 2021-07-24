package com.ifsul.tcc.gerenciadorExames.api.Controller.Request;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ContatoDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.EnderecoDTO;

import java.time.LocalDate;

public class NewDadosConsultaRequest {

    private String nomeMedico;
    private LocalDate dataConsulta;
    private String diagnostico;
    private String prescricao;
    private Long idArquivo;

    private Integer idInstituicao;
    private String nomeInstituicao;

    private Integer idContatoInstituicao;
    private String contatoUmInstituicao;
    private String contatoDoisInstituicao;

    private Integer idEnderecoInstituicao;
    private String cidade;
    private String cep;
    private String bairro;
    private String rua;
    private int numero;

    public NewDadosConsultaRequest() {}

    public NewDadosConsultaRequest(String nomeMedico, LocalDate dataConsulta, String diagnostico, String prescricao, Long idArquivo, Integer idInstituicao, String nomeInstituicao, Integer idContatoInstituicao, String contatoUmInstituicao, String contatoDoisInstituicao, Integer idEnderecoInstituicao, String cidade, String cep, String bairro, String rua, int numero, DadosInstituicaoRequest dadosInstituicao) {
        this.nomeMedico = nomeMedico;
        this.dataConsulta = dataConsulta;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.idArquivo = idArquivo;
        this.idInstituicao = idInstituicao;
        this.nomeInstituicao = nomeInstituicao;
        this.idContatoInstituicao = idContatoInstituicao;
        this.contatoUmInstituicao = contatoUmInstituicao;
        this.contatoDoisInstituicao = contatoDoisInstituicao;
        this.idEnderecoInstituicao = idEnderecoInstituicao;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
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

    public Integer getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(Integer idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public Integer getIdContatoInstituicao() {
        return idContatoInstituicao;
    }

    public void setIdContatoInstituicao(Integer idContatoInstituicao) {
        this.idContatoInstituicao = idContatoInstituicao;
    }

    public String getContatoUmInstituicao() {
        return contatoUmInstituicao;
    }

    public void setContatoUmInstituicao(String contatoUmInstituicao) {
        this.contatoUmInstituicao = contatoUmInstituicao;
    }

    public String getContatoDoisInstituicao() {
        return contatoDoisInstituicao;
    }

    public void setContatoDoisInstituicao(String contatoDoisInstituicao) {
        this.contatoDoisInstituicao = contatoDoisInstituicao;
    }

    public Integer getIdEnderecoInstituicao() {
        return idEnderecoInstituicao;
    }

    public void setIdEnderecoInstituicao(Integer idEnderecoInstituicao) {
        this.idEnderecoInstituicao = idEnderecoInstituicao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public DadosInstituicaoRequest buscarDadosInstituicao() {
        DadosInstituicaoRequest instituicao = new DadosInstituicaoRequest();
        instituicao.setNome(this.nomeInstituicao);
        instituicao.setId(this.idInstituicao);
        instituicao.setContatoDTO(new ContatoDTO(this.contatoUmInstituicao, this.contatoDoisInstituicao));
        instituicao.setEnderecoDTO(new EnderecoDTO(this.cidade, this.cep, this.bairro, this.rua, this.numero));
        return  instituicao;
    }
}
