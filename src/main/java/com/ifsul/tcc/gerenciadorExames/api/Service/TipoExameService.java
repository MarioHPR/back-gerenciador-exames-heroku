package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosTipoExameRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.DadosTipoExameResponse;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.TipoExameResponse;
import com.ifsul.tcc.gerenciadorExames.api.DTO.*;
import com.ifsul.tcc.gerenciadorExames.api.Entity.*;
import com.ifsul.tcc.gerenciadorExames.api.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoExameService {

    @Autowired
    private InstituicaoService instituicaoService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private TipoExameRepository tipoExameRepository;

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private ItemCampoExameRepository itemCampoExameRepository;

    @Autowired
    private ItemValorExameRepository itemValorExameRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Optional<Instituicao> encontrarinstituicao( Integer id ) {
        return instituicaoRepository.findById( id );
    }

    @Transactional( rollbackFor = Exception.class )
    public TipoExameDTO salvar(DadosTipoExameRequest dadosTipoExameRequest) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );

        if(!usuario.isPresent()) {
            throw new Exception();
        }

        Optional<Instituicao> instituicaoOptional = encontrarinstituicao(dadosTipoExameRequest.getDadosInstituicao().getId());
        Instituicao instituicao;

        if(instituicaoOptional.isPresent()) {
           instituicao = instituicaoOptional.get();
        } else {
            instituicao = instituicaoService.adicionarInstituicao(dadosTipoExameRequest.getDadosInstituicao());
        }

        Optional<TipoExame> tipoExameOptional = tipoExameRepository.findByUsuarioAndNomeExame(usuario.get(), dadosTipoExameRequest.getNomeExame());
        TipoExame tipoExamePersistida;
        if(tipoExameOptional.isPresent()){
            tipoExamePersistida = tipoExameOptional.get();
        } else {
            TipoExame tipoExame;
            tipoExame = new TipoExame(dadosTipoExameRequest.getNomeExame());
            tipoExame.setUsuario( usuario.get() );
            tipoExamePersistida = tipoExameRepository.save( tipoExame );
        }

        Exame exame = objectMapper.convertValue(dadosTipoExameRequest, Exame.class);
        exame.setUsuario( usuario.get() );
        exame.setInstituicao(instituicao);
        exame.setTipoExame(tipoExamePersistida);
        exameRepository.save( exame );
        if( dadosTipoExameRequest.getCampo().size() > 0) {
            int tamanho = dadosTipoExameRequest.getCampo().size();
            for( int i = 0 ; i < tamanho ; i++ ) {
                String campo = dadosTipoExameRequest.getCampo().get(i);
                String valor = dadosTipoExameRequest.getValor().get(i);

                Optional<ItemCampoExame> item = itemCampoExameRepository.findByCampoAndTipoExame(campo, exame.getTipoExame());
                ItemCampoExame itemEntity;
                if(item.isPresent()) {
                    itemEntity = item.get();
                } else {
                    ItemCampoExame newItem = new ItemCampoExame(campo);
                    newItem.setExame(exame);
                    newItem.setTipoExame(tipoExamePersistida);
                    itemEntity = itemCampoExameRepository.save(newItem);
                }

                ItemValorExame itemValorExame = new ItemValorExame(valor);
                itemValorExame.setExame(exame);
                itemValorExame.setItemCampoExame(itemEntity);
                itemValorExameRepository.save(itemValorExame);
            }
        }
        return  new TipoExameDTO(tipoExamePersistida);
    }

    public List<TipoExameResponse> buscarTodosOsTipoExamesDoUsuario() throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()) {
            return tipoExameRepository.findAllByUsuarioOrderByNomeExame(usuario.get())
                    .stream().map( it -> {
                        TipoExameResponse t = new TipoExameResponse(it);
                        t.setQuantidade(exameRepository.countByTipoExameAndUsuarioAndFlgDeletedIsFalse(it, usuario.get()));
                        return t;
                    })
                    .collect(Collectors.toList());
        }
        throw new Exception();
    }

    public List<DadosTipoExameResponse> buscarTipoExamesDoUsuario() throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            List<DadosTipoExameResponse> dadosTipoExameResponses = new ArrayList<>();
            List<TipoExame> listaTipoExame = tipoExameRepository.findAllByUsuarioOrderByNomeExame( usuario.get() );
            listaTipoExame.forEach( tipo -> {
                List<ItemCampoExameDTO> itens = itemCampoExameRepository.findAllByTipoExame(tipo);
                dadosTipoExameResponses.add(new DadosTipoExameResponse(tipo, itens));
            });
            return dadosTipoExameResponses;
        }
        throw new Exception();
    }

    @Transactional( rollbackFor = Exception.class )
    public TipoExameDTO editarTipoExame(TipoExameDTO tipoExameDTO, Integer id) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()) {
            TipoExame tipoExame = new TipoExame(tipoExameDTO);
            tipoExame.setUsuario( usuario.get() );
            tipoExame.setId(id);
            return new TipoExameDTO(tipoExameRepository.save(tipoExame));
        }
        throw new Exception();
    }

    @Transactional( rollbackFor = Exception.class )
    public String removerTipoExame(int idtipoExame) throws Exception {
        String email = getEmail();
        Optional<TipoExame> tipoExame = tipoExameRepository.findById(idtipoExame);
        if (tipoExame.isPresent()) {
            tipoExameRepository.deleteById(idtipoExame);
            return " Todos os " + tipoExame.get().getNomeExame() + "s foram deletados!";
        }
        throw new Exception();
    }

    public String getEmail() {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal().toString();
    }
}
