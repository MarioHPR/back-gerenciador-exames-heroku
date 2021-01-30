package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Endereco;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {
    List<Endereco> findByCidade( String cidade );
    Optional<Endereco> findByUsuario(Usuario usuario);
    Optional<Endereco> findByIdAndUsuario(Integer id, Usuario usuario);
}
