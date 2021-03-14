package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.DTO.TipoExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoExame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoExameRepository extends CrudRepository<TipoExame,Integer> {
    List<TipoExame> findAllByUsuarioOrderByNomeExame(Usuario usuario);
    Optional<TipoExame> findById(Integer id);
    TipoExameDTO findByIdAndUsuario(Integer id, Usuario usuario);
    Optional<TipoExame> findByUsuarioAndNomeExame(Usuario usuario, String nomeExame);
}
