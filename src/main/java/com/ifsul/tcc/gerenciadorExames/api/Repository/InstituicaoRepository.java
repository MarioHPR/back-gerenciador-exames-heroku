package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.DadosInstituicaoResponse;
import com.ifsul.tcc.gerenciadorExames.api.DTO.InstituicaoDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Instituicao;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituicaoRepository extends CrudRepository<Instituicao, Integer> {
    List<DadosInstituicaoResponse> findAllByUsuario(Usuario usuario);
    Optional<DadosInstituicaoResponse> findByIdAndUsuario(Integer id, Usuario usuario);
}
