package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ContatoDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Contato;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends CrudRepository<Contato,Integer> {
    List<ContatoDTO> findAllByUsuario(Usuario usuario);
    Optional<ContatoDTO> findByIdAndUsuario(Integer id, Usuario usuario);
}
