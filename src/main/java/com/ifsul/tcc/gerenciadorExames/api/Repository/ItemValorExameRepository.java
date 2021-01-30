package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ItemCampoExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ItemValorExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.ItemCampoExame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.ItemValorExame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemValorExameRepository extends CrudRepository<ItemValorExame,Integer> {
    List<ItemValorExameDTO> findAllByItemCampoExameOrderByValorDesc(ItemCampoExame itemCampoExame);

    List<ItemValorExameDTO> findAllByExame(Exame exame);

    Optional<ItemValorExame> findById(Integer id);
    Optional<ItemValorExameDTO> findByExameAndItemCampoExame(Exame exame, ItemCampoExame itemCampoExame);// mudar para pegar id e exame

    Optional<ItemValorExame> findByIdAndItemCampoExame(Integer id, ItemCampoExame itemCampoExame);
}
