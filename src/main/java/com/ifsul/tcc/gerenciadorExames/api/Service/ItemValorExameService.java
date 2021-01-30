package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.ifsul.tcc.gerenciadorExames.api.Entity.ItemValorExame;
import com.ifsul.tcc.gerenciadorExames.api.Repository.ExameRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.ItemCampoExameRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.ItemValorExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemValorExameService {

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private ItemCampoExameRepository itemCampoExameRepository;

    @Autowired
    private ItemValorExameRepository itemValorExameRepository;

    @Transactional( rollbackFor = Exception.class )
    public ItemValorExame salvar(ItemValorExame itemValorExame ) throws Exception {
        ItemValorExame consultaPersistida = itemValorExameRepository.save( itemValorExame );
        return  consultaPersistida;
    }

}
