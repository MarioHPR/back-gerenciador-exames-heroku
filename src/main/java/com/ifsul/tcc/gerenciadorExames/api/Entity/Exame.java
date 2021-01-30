package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosExameRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.ExameResponse;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ExameDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance( strategy = InheritanceType.JOINED)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Exame {

    @Id
    @SequenceGenerator(name = "EXAME_SEQ", sequenceName = "EXAME_SEQ")
    @GeneratedValue(generator = "EXAME_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String linkImage;

    private Boolean flgDeleted;

    {
        this.flgDeleted = false;
    }

    @Column(nullable = false)
    private LocalDate dataExame;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Instituicao instituicao;

    @ManyToOne
    private TipoExame tipoExame;

    @OneToMany(mappedBy = "exame", cascade = CascadeType.ALL)
    private List<ItemCampoExame> itemCampoExames;

    @OneToMany(mappedBy = "exame", cascade = CascadeType.ALL)
    private List<ItemValorExame> itemValorExames;

    public Exame() {}

    public Exame(String linkImage, LocalDate dataExame) {
        this.linkImage = linkImage;
        this.dataExame = dataExame;
    }

    public Exame(ExameResponse exameResponse) {
        this.id = exameResponse.getId();
        this.linkImage = exameResponse.getLinkImage();
        this.dataExame = exameResponse.getDataExame();
    }

    public Exame(ExameDTO exameDTO) {
        this.id = exameDTO.getId();
        this.linkImage = exameDTO.getLinkImage();
        this.dataExame = exameDTO.getDataExame();
    }

    public Exame(DadosExameRequest dadosExameRequest) {
        this.linkImage = dadosExameRequest.getLinkImage();
        this.dataExame = dadosExameRequest.getDataExame();
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

    public LocalDate getDataExame() {
        return dataExame;
    }

    public void setDataExame(LocalDate dataExame) {
        this.dataExame = dataExame;
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

    public TipoExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoExame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public Boolean getFlgDeleted() {
        return flgDeleted;
    }

    public void setFlgDeleted(Boolean flgDeleted) {
        this.flgDeleted = flgDeleted;
    }
}
