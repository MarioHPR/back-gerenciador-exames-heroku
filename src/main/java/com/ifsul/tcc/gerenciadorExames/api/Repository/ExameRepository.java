package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.ExameResponse;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoExame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExameRepository extends CrudRepository<Exame,Integer> {
   List<ExameResponse> findAllByUsuarioAndFlgDeletedFalseOrderByDataExameDesc(Usuario usuario);
    Optional<Exame> findById(Integer id);
    Optional<ExameResponse> findByIdAndUsuario(Integer id, Usuario usuario);
    Integer countByTipoExameAndUsuarioAndFlgDeletedIsFalse(TipoExame tipExame, Usuario usuario);
}
