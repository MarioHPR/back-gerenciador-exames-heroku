package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosConsultaRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.NewDadosConsultaRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.DadosConsultaResponse;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ConsultaDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Consulta;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Instituicao;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import com.ifsul.tcc.gerenciadorExames.api.Repository.ConsultaRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.InstituicaoRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.UsuarioRepository;
import com.ifsul.tcc.gerenciadorExames.api.Service.mapper.ConsultaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private InstituicaoService instituicaoService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ContatoService contatoService;

//    @Transactional( rollbackFor = Exception.class )
//    public DadosConsultaRequest salvar(DadosConsultaRequest dadosConsulta) throws Exception {
//        String email = getEmail();
//        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
//        Optional<Instituicao> instituicaoOptional = instituicaoRepository.findById(dadosConsulta.getDadosInstituicao().getId());
//        Instituicao instituicao;
//
//        if(instituicaoOptional.isPresent()) {
//            instituicao = instituicaoOptional.get();
//        } else {
//            instituicao = instituicaoService.adicionarInstituicao(dadosConsulta.getDadosInstituicao());
//        }
//
//        if( usuario.isPresent() ){
//            Consulta consulta = new Consulta(dadosConsulta);
//            consulta.setInstituicao( instituicao );
//            consulta.setUsuario( usuario.get() );
//            Consulta consultaPersistida = consultaRepository.save( consulta );
//            return  new DadosConsultaRequest(consultaPersistida);
//        }
//        throw new Exception();
//    }

    @Transactional( rollbackFor = Exception.class )
    public DadosConsultaRequest salvar(NewDadosConsultaRequest dadosConsulta) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        Optional<Instituicao> instituicaoOptional = instituicaoRepository.findById(dadosConsulta.getIdInstituicao());
        Instituicao instituicao;
        if( usuario.isPresent() ){
            if(instituicaoOptional.isPresent()) {
                instituicao = instituicaoOptional.get();
            } else {
                instituicao = instituicaoService.adicionarInstituicao(dadosConsulta.buscarDadosInstituicao(), usuario.get());
            }
            Consulta consulta = ConsultaMapper.createEntity(dadosConsulta, instituicao, usuario.get());
            Consulta consultaPersistida = consultaRepository.save( consulta );
            return  new DadosConsultaRequest(consultaPersistida);
        }
        throw new Exception();
    }

    public List<ConsultaDTO> buscarConsultasDoUsuario() throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            return consultaRepository.findAllByUsuarioOrderByDataConsultaDesc( usuario.get() );
        }
        throw new Exception();
    }

    public DadosConsultaResponse buscarConsultaEspecificadoUsuarioPorId(Integer id) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            return consultaRepository.findByIdAndUsuario( id, usuario.get() );
        }
        throw new Exception();
    }

//    @Transactional( rollbackFor = Exception.class )
//    public DadosConsultaResponse editarConsulta( DadosConsultaRequest dadosConsulta, Integer id) throws Exception {
//        String email = getEmail();
//        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
//        Optional<Instituicao> instituicaoOptional = instituicaoRepository.findById( dadosConsulta.getDadosInstituicao().getId() );
//
//        Instituicao instituicao;
//
//        if(usuario.isPresent()) {
//            if(instituicaoOptional.isPresent()) {
//                instituicao = instituicaoOptional.get();
//            } else {
//                instituicao = instituicaoService.adicionarInstituicao(dadosConsulta.getDadosInstituicao(), usuario.get());
//            }
//            Consulta consulta = new Consulta(dadosConsulta);
//            consulta.setUsuario( usuario.get() );
//            consulta.setInstituicao( instituicao );
//            consulta.setId(id);
//            return new DadosConsultaResponse(consultaRepository.save(consulta));
//        }
//        throw new Exception();
//    }
    @Transactional( rollbackFor = Exception.class )
    public DadosConsultaResponse editarConsulta( NewDadosConsultaRequest dadosConsulta, Integer id) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        Optional<Instituicao> instituicaoOptional = instituicaoRepository.findById(dadosConsulta.getIdInstituicao());

        Instituicao instituicao;

        if(usuario.isPresent()) {
            if(instituicaoOptional.isPresent()) {
                instituicao = instituicaoOptional.get();
            } else {
                instituicao = instituicaoService.adicionarInstituicao(dadosConsulta.buscarDadosInstituicao(), usuario.get());
            }
            Consulta consulta = ConsultaMapper.createEntity(dadosConsulta, instituicao, usuario.get());
            consulta.setId(id);
            return new DadosConsultaResponse(consultaRepository.save(consulta));
        }
        throw new Exception();
    }

    @Transactional( rollbackFor = Exception.class )
    public String removerConsulta(int idConsulta) throws Exception {
        Optional<Consulta> consulta = consultaRepository.findById(idConsulta);
        if (consulta.isPresent()) {
            consultaRepository.deleteById(idConsulta);
            return " Consulta data = " + consulta.get().getDataConsulta() + " foi deletada!";
        }
        throw new Exception();
    }

    public String getEmail() {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal().toString();
    }
}
