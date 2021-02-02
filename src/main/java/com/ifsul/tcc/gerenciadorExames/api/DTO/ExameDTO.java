package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;

import java.time.LocalDate;

public class ExameDTO {

    private Integer id;
    private Long idArquivo;
    private LocalDate dataExame;
    private Integer idTipoExame;
    private Integer idInstituicao;
    private Integer idUsuario;
    private Boolean flgDeleted;

    public ExameDTO() {}

    public ExameDTO(Integer id, Long idArquivo, Integer idUsuario, Integer idInstituicao, Integer idTipoExame, LocalDate dataExame) {
        this.id = id;
        this.idArquivo = idArquivo;
        this.idUsuario = idUsuario;
        this.idInstituicao = idInstituicao;
        this.idTipoExame = idTipoExame;
        this.dataExame = dataExame;
    }

    public ExameDTO(Exame exame) {
        this.id = exame.getId();
        this.idArquivo = exame.getIdArquivo();
        this.idUsuario = exame.getUsuario().getId();
        this.idInstituicao = exame.getInstituicao().getId();
        this.idTipoExame = exame.getTipoExame().getId();
        this.dataExame = exame.getDataExame();
        this.flgDeleted = exame.getFlgDeleted();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getDataExame() {
        return dataExame;
    }

    public void setDataExame(LocalDate dataExame) {
        this.dataExame = dataExame;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTipoExame() {
        return idTipoExame;
    }

    public void setIdTipoExame(Integer idTipoExame) {
        this.idTipoExame = idTipoExame;
    }

    public Boolean getFlgDeleted() {
        return flgDeleted;
    }

    public void setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
    }
}
