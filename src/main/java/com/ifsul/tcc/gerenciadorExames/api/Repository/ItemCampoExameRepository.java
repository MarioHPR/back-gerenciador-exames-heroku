package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ItemCampoExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.ItemCampoExame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoExame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemCampoExameRepository extends CrudRepository<ItemCampoExame,Integer> {
    Optional<ItemCampoExame> findById(Integer id);
    Optional<ItemCampoExame> findByCampoAndTipoExame(String campo, TipoExame exame);// mudar para pegar id e exame
    List<ItemCampoExameDTO> findAllByTipoExame(TipoExame tipoExame);
    List<ItemCampoExameDTO> findAllByExame(Exame exame);
}
