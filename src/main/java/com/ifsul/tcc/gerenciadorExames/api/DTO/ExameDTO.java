package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;

import java.time.LocalDate;

public class ExameDTO {

    private Integer id;
    private String linkImage;
    private LocalDate dataExame;
    private Integer idTipoExame;
    private Integer idInstituicao;
    private Integer idUsuario;
    private Boolean flgDeleted;

    public ExameDTO() {}

    public ExameDTO(Integer id, String linkImage, Integer idUsuario, Integer idInstituicao, Integer idTipoExame, LocalDate dataExame) {
        this.id = id;
        this.linkImage = linkImage;
        this.idUsuario = idUsuario;
        this.idInstituicao = idInstituicao;
        this.idTipoExame = idTipoExame;
        this.dataExame = dataExame;
    }

    public ExameDTO(Exame exame) {
        this.id = exame.getId();
        this.linkImage = exame.getLinkImage();
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

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
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
