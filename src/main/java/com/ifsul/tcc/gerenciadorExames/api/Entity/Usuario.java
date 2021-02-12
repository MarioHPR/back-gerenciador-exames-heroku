package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosUsuarioRequest;
import com.ifsul.tcc.gerenciadorExames.api.DTO.UsuarioDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Inheritance( strategy = InheritanceType.JOINED)
public class Usuario implements UserDetails {
    @Id
    @SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ")
    @GeneratedValue(generator = "USUARIO_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column( nullable = false )
    private LocalDate dataNascimento;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;

    // chaves estrangeiras
    @OneToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "usuario")
    private List<Contato> contatos;

    @OneToMany(mappedBy = "usuario")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "usuario")
    private List<TipoExame> TipoExames;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Exame> exames;

    @OneToMany(mappedBy = "usuario")
    private List<Instituicao> instituicoes;

    @ElementCollection
    private List<GrantedAuthority> authorities;

    public Usuario() {}

    public Usuario(Integer id, String nome, String cpf, LocalDate dataNascimento, String email, String senha,  List<GrantedAuthority> authorities) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.authorities = authorities.isEmpty() ? Collections.emptyList() : authorities;
    }

    public Usuario(UsuarioDTO usuarioDTO) {
        this.id = usuarioDTO.getId();
        this.nome = usuarioDTO.getNome();
        this.cpf = usuarioDTO.getCpf();
        this.dataNascimento = usuarioDTO.getDataNascimento();
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
    }

    public Usuario(DadosUsuarioRequest dadosUsuario) {
        this.id = dadosUsuario.getId();
        this.nome = dadosUsuario.getNome();
        this.cpf = dadosUsuario.getCpf();
        this.dataNascimento = dadosUsuario.getDataNascimento();
        this.email = dadosUsuario.getEmail();
        this.senha = dadosUsuario.getSenha();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Instituicao> getInstituicoes() {
        return instituicoes;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {
        this.instituicoes = instituicoes;
    }

    public List<TipoExame> getTipoExames() {
        return TipoExames;
    }

    public void setTipoExames(List<TipoExame> tipoExames) {
        TipoExames = tipoExames;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
