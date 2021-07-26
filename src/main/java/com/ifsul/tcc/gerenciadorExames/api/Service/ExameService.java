package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosExameEditRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosExameRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.ResumoExameRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.ExameResponse;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ContatoDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.EnderecoDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.InstituicaoDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.*;
import com.ifsul.tcc.gerenciadorExames.api.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExameService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private TipoExameRepository tipoExameRepository;

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ItemCampoExameRepository itemCampoExameRepository;

    @Autowired
    private ItemValorExameRepository itemValorExameRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private InstituicaoService instituicaoService;

    @Transactional( rollbackFor = Exception.class )
    public ExameDTO salvar(DadosExameRequest dadosExameRequest) throws Exception {
        String  email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        Optional<Instituicao> instituicao = instituicaoRepository.findById( dadosExameRequest.getIdInstituicao() );
        Optional<TipoExame> tipoExame = tipoExameRepository.findById(dadosExameRequest.getIdTipoExame());
        if( usuario.isPresent() && instituicao.isPresent() && tipoExame.isPresent() ){
            Exame exame = new Exame(dadosExameRequest);
            exame.setUsuario( usuario.get() );
            exame.setInstituicao(instituicao.get());
            exame.setTipoExame(tipoExame.get());
            Exame examePersistida = exameRepository.save( exame );
            if( dadosExameRequest.getCampo().size() > 0) {
                int tamanho = dadosExameRequest.getCampo().size();
                for( int i = 0 ; i < tamanho ; i++ ) {
                    String campo = dadosExameRequest.getCampo().get(i);
                    String valor = dadosExameRequest.getValor().get(i);

                    Optional<ItemCampoExame> item = itemCampoExameRepository.findByCampoAndTipoExame(campo, exame.getTipoExame());
                    ItemCampoExame itemEntity;
                    if(item.isPresent()) {
                        itemEntity = item.get();
                    } else {
                        ItemCampoExame newItem = new ItemCampoExame(campo);
                        newItem.setExame(exame);
                        newItem.setTipoExame(tipoExame.get());
                        itemEntity = itemCampoExameRepository.save(newItem);
                    }

                    ItemValorExame itemValorExame = new ItemValorExame(valor);
                    itemValorExame.setExame(exame);
                    itemValorExame.setItemCampoExame(itemEntity);
                    itemValorExameRepository.save(itemValorExame);
                }
            }
            return new ExameDTO(examePersistida);
        }
        throw new Exception();
    }

    public List<ExameResponse> buscarTodosExamesDoUsuario() throws Exception {
        String  email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            List<ExameResponse> listaDeExames = exameRepository.findAllByUsuarioAndFlgDeletedFalseOrderByDataExameDesc( usuario.get() );

            listaDeExames.forEach( exame -> {
                Exame exameEntity = new Exame(exame);
                exame.setParametros( itemValorExameRepository.findAllByExame(exameEntity) );
                //exame.setValor();
            });
            return listaDeExames;
        }
        throw new Exception();
    }

    public ExameResponse buscarExameEspecificadoUsuarioPorId(Integer idExame) throws Exception {
        String  email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            Optional<ExameResponse> exame = exameRepository.findByIdAndUsuario( idExame, usuario.get() );
            if( exame.isPresent() && !exame.get().getFlgDeleted() ) {
                Exame exameEntity = new Exame(exame.get());
                ExameResponse dadosExameResponse = exame.get();
                dadosExameResponse.setParametros(itemValorExameRepository.findAllByExame(exameEntity));
                return dadosExameResponse;
            }
            throw new Exception("Exame inesistente!");
        }
        throw new Exception("Não há dados para este usuário!");
    }

//    @Transactional( rollbackFor = Exception.class )
//    public ExameResponse editarExame(DadosExameEditRequest request, Integer id) throws Exception {
//        Optional<Exame> exame = exameRepository.findById(id);
//        if( !exame.isPresent() )
//            throw new Exception("Exame não encontrado!");
//        String  email = getEmail();
//        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
//        Optional<Instituicao> instituicaoOptional = instituicaoRepository.findById( request.getDadosInstituicao().getId() );
//        Optional<TipoExame> tipoExame = tipoExameRepository.findByUsuarioAndNomeExame(usuario.get(), request.getTipoExame());
//        Instituicao instituicao;
//
//        if( usuario.isPresent() && tipoExame.isPresent() ) {
//            if(instituicaoOptional.isPresent()) {
//                instituicao = instituicaoOptional.get();
//            } else {
//                instituicao = instituicaoService.adicionarInstituicao(request.getDadosInstituicao(), usuario.get());
//            }
//            exame.get().setDataExame(request.getDataExame());
//            exame.get().setTipoExame(tipoExame.get());
//            exame.get().setInstituicao(instituicao);
//            exame.get().setIdArquivo(request.getIdArquivo());
//            for (int i = 0 ; i < request.getParametros().size() ; i++ ) {
//                if(request.getParametros().get(i).getCampo() != "") {
//                    Integer idCampo = request.getParametros().get(i).getIdItemCampoExame();
//                    String campo = request.getParametros().get(i).getCampo();
//                    Optional<ItemCampoExame> itemCampo = itemCampoExameRepository.findById(idCampo);
//
//                    ItemCampoExame itemEntity;
//                    if (itemCampo.isPresent()) {
//                        itemEntity = itemCampo.get();
//                        itemEntity.setCampo(campo);
//                        itemCampoExameRepository.save(itemEntity);
//                    } else {
//                        ItemCampoExame newItem = new ItemCampoExame(campo);
//                        newItem.setExame(exame.get());
//                        newItem.setTipoExame(tipoExame.get());
//                        itemEntity = itemCampoExameRepository.save(newItem);
//                    }
//
//                    Integer idValor = request.getParametros().get(i).getIdItemValorExame();
//                    String valor = request.getParametros().get(i).getValor();
//                    Optional<ItemValorExame> item = itemValorExameRepository.findById(idValor);
//                    if (item.isPresent() && valor != item.get().getValor()) {
//                        item.get().setValor(valor);
//                        itemValorExameRepository.save(item.get());
//                    } else {
//                        ItemValorExame itemValorExame = new ItemValorExame(valor);
//                        itemValorExame.setExame(exame.get());
//                        itemValorExame.setItemCampoExame(itemEntity);
//                        itemValorExameRepository.save(itemValorExame);
//                    }
//                }
//            }
//            return new ExameResponse(exameRepository.save(exame.get()));
//        }
//        throw new Exception("Houve algum problema, instituição ou tipo de exame não encontrado!");
//    }
@Transactional( rollbackFor = Exception.class )
public ExameResponse editarExame(ResumoExameRequest request, Integer id) throws Exception {
    Optional<Exame> exame = exameRepository.findById(id);
    if( !exame.isPresent() )
        throw new Exception("Exame não encontrado!");
    String  email = getEmail();
    Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
    Optional<Instituicao> instituicaoOptional = instituicaoRepository.findById( request.getIdInstituicao() );
    Optional<TipoExame> tipoExame = tipoExameRepository.findByUsuarioAndNomeExame(usuario.get(), request.getNomeExame());
    Instituicao instituicao;

    if( usuario.isPresent() && tipoExame.isPresent() ) {
        if(instituicaoOptional.isPresent()) {
            instituicao = instituicaoOptional.get();
        } else {
            instituicao = instituicaoService.adicionarInstituicao(request.buscarDadosInstituicao(), usuario.get());
        }
        exame.get().setDataExame(request.getDataExame());
        exame.get().setTipoExame(tipoExame.get());
        exame.get().setInstituicao(instituicao);
        exame.get().setIdArquivo(request.getIdArquivo());
        for (int i = 0 ; i < request.getParametros().size() ; i++ ) {
            if(request.getParametros().get(i).getCampo() != "") {
                Integer idCampo = request.getParametros().get(i).getIdItemCampoExame();
                String campo = request.getParametros().get(i).getCampo();
                Optional<ItemCampoExame> itemCampo = itemCampoExameRepository.findById(idCampo);

                ItemCampoExame itemEntity;
                if (itemCampo.isPresent()) {
                    itemEntity = itemCampo.get();
                    itemEntity.setCampo(campo);
                    itemCampoExameRepository.save(itemEntity);
                } else {
                    ItemCampoExame newItem = new ItemCampoExame(campo);
                    newItem.setExame(exame.get());
                    newItem.setTipoExame(tipoExame.get());
                    itemEntity = itemCampoExameRepository.save(newItem);
                }

                Integer idValor = request.getParametros().get(i).getIdItemValorExame();
                String valor = request.getParametros().get(i).getValor();
                Optional<ItemValorExame> item = itemValorExameRepository.findById(idValor);
                if (item.isPresent() && valor != item.get().getValor()) {
                    item.get().setValor(valor);
                    itemValorExameRepository.save(item.get());
                } else {
                    ItemValorExame itemValorExame = new ItemValorExame(valor);
                    itemValorExame.setExame(exame.get());
                    itemValorExame.setItemCampoExame(itemEntity);
                    itemValorExameRepository.save(itemValorExame);
                }
            }
        }
        return new ExameResponse(exameRepository.save(exame.get()));
    }
    throw new Exception("Houve algum problema, instituição ou tipo de exame não encontrado!");
}

    @Transactional( rollbackFor = Exception.class )
    public String removerExame(int idExame) throws Exception {
        String  email = getEmail();
        Optional<Exame> exame = exameRepository.findById(idExame);
        if (exame.isPresent()) {
            exame.get().setFlgDeleted(Boolean.TRUE);
            exameRepository.save(exame.get());
            return " Exame selecionado " + " deletado com sucesso!";
        }
        throw new Exception();
    }

    public String getEmail() {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal().toString();
    }
}
