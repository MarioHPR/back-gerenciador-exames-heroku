package com.ifsul.tcc.gerenciadorExames.api.Controller.Response;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ContatoDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.EnderecoDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Instituicao;

public class DadosInstituicaoResponse {

    private Integer id;
    private String nome;

    private ContatoDTO contatoDTO;
    private EnderecoDTO enderecoDTO;

    public DadosInstituicaoResponse() {}

    public DadosInstituicaoResponse(Integer id) {
        this.id = id;
    }

    public DadosInstituicaoResponse(String nome, ContatoDTO contatoDTO, EnderecoDTO enderecoDTO) {
        this.nome = nome;
        this.contatoDTO = contatoDTO;
        this.enderecoDTO = enderecoDTO;
    }

    public DadosInstituicaoResponse(Integer id, String nome, Integer idContato, Integer idEndereco) {
        this.id = id;
        this.nome = nome;
        this.contatoDTO.setId(idContato);
        this.enderecoDTO.setId(idEndereco);
    }

    public DadosInstituicaoResponse(Integer id, String nome, ContatoDTO contatoDTO, EnderecoDTO enderecoDTO) {
        this.id = id;
        this.nome = nome;
        this.contatoDTO = contatoDTO;
        this.enderecoDTO = enderecoDTO;
    }

    public DadosInstituicaoResponse(Instituicao instituicao) {
        this.id = instituicao.getId();
        this.nome = instituicao.getNome();
        this.contatoDTO = new ContatoDTO(instituicao.getContato());
        this.enderecoDTO = new EnderecoDTO(instituicao.getEndereco());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContatoDTO getContatoDTO() {
        return contatoDTO;
    }

    public void setContatoDTO(ContatoDTO contatoDTO) {
        this.contatoDTO = contatoDTO;
    }

    public EnderecoDTO getEnderecoDTO() {
        return enderecoDTO;
    }

    public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
        this.enderecoDTO = enderecoDTO;
    }
}
