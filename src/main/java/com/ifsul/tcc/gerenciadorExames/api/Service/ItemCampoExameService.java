package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ItemCampoExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.ItemCampoExame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoExame;
import com.ifsul.tcc.gerenciadorExames.api.Repository.ExameRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.ItemCampoExameRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.TipoExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCampoExameService {

    @Autowired
    private ItemCampoExameRepository itemCampoExameRepository;

    @Autowired
    private TipoExameRepository tipoExameRepository;

    @Autowired
    private ExameRepository exameRepository;

    @Transactional( rollbackFor = Exception.class )
    public ItemCampoExame salvar( ItemCampoExameDTO itemCampoExameDTO, Integer id ) throws Exception {
        Optional<Exame> exame = exameRepository.findById( id );

        if( exame.isPresent() ){
            ItemCampoExame newItem = new ItemCampoExame(itemCampoExameDTO);
            ItemCampoExame itemPersistida = itemCampoExameRepository.save( newItem );
            return  itemPersistida;
        }
        throw new Exception();
    }

    public ItemCampoExameDTO buscarItemCampoPorId( Integer id ) throws Exception {
        Optional<ItemCampoExame> item = itemCampoExameRepository.findById( id );
        if(item.isPresent()){
            ItemCampoExameDTO itemCampoExameDTO = new ItemCampoExameDTO(item.get());
            return itemCampoExameDTO;
        }
        throw new Exception("Nenhum item encontrado!");
    }

    public List<ItemCampoExameDTO> buscarTodosItemCampoDoExame( Integer idTipoExame ) throws Exception {
        Optional<TipoExame> tipoExame = tipoExameRepository.findById(idTipoExame);
        if(tipoExame.isPresent()){
            return itemCampoExameRepository.findAllByTipoExame(tipoExame.get());
        }
        throw new Exception("Nenhum item encontrado!");
    }

    @Transactional( rollbackFor = Exception.class )
    public ItemCampoExameDTO editarItemCampo( ItemCampoExameDTO itemCampoExameDTO, Integer id) throws Exception {
        Optional<ItemCampoExame> item = itemCampoExameRepository.findById( id );
        if(item.isPresent()) {
            ItemCampoExame novosParametros = new ItemCampoExame(itemCampoExameDTO);
            novosParametros.setId(id);
            return new ItemCampoExameDTO(itemCampoExameRepository.save(novosParametros));
        }
        throw new Exception();
    }

    @Transactional( rollbackFor = Exception.class )
    public String removerItemCampo(Integer idItem) throws Exception {

        Optional<ItemCampoExame> item = itemCampoExameRepository.findById( idItem );
        if (item.isPresent()) {
            itemCampoExameRepository.deleteById(idItem);
            return " Item selecionado foi deletado!";
        }
        throw new Exception();
    }
}
