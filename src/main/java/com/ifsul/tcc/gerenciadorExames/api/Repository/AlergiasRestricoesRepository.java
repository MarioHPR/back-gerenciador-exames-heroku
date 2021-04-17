package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.AlergiaOuRestricaoResponse;
import com.ifsul.tcc.gerenciadorExames.api.Entity.AlergiasRestricoes;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlergiasRestricoesRepository extends CrudRepository<AlergiasRestricoes,Integer> {
    List<AlergiaOuRestricaoResponse> findAllByUsuarioOrderByTipo(Usuario usuario);
}
