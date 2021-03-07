package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosInstituicaoRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.DadosInstituicaoResponse;
import com.ifsul.tcc.gerenciadorExames.api.DTO.EnderecoDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.InstituicaoDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Contato;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Endereco;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Instituicao;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import com.ifsul.tcc.gerenciadorExames.api.Repository.ContatoRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.EnderecoRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.InstituicaoRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional( rollbackFor = Exception.class )
    public InstituicaoDTO adicionarInstituicao(DadosInstituicaoRequest dadosInstituicao) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if(usuario.isPresent()){

            Contato newContato = new Contato(contatoService.salvar(dadosInstituicao.getContatoDTO(), email));
            Endereco newEndereco = new Endereco(enderecoService.salvar(dadosInstituicao.getEnderecoDTO(), email));

            Instituicao instituicao = new Instituicao(dadosInstituicao.getNome() );
            instituicao.setUsuario( usuario.get() );
            instituicao.setEndereco( newEndereco );
            instituicao.setContato( newContato );
            Instituicao instituicaoPersistido = instituicaoRepository.save( instituicao );
            return  new InstituicaoDTO( instituicaoPersistido );
        }
        throw new Exception();
    }

    @Transactional( rollbackFor = Exception.class )
    public Instituicao salvar(InstituicaoDTO instituicaoDTO) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if(usuario.isPresent()){
            Contato contato = contatoRepository.findById(instituicaoDTO.getIdContato()).get();
            Endereco endereco = enderecoRepository.findById(instituicaoDTO.getIdLocalidade()).get();

            Instituicao instituicao = new Instituicao( instituicaoDTO );
            instituicao.setUsuario( usuario.get() );
            instituicao.setEndereco( endereco );
            instituicao.setContato( contato );

            Instituicao instituicaoPersistido = instituicaoRepository.save( instituicao );
            System.out.println(objectMapper.writeValueAsString(instituicaoPersistido));
            return instituicaoPersistido;
        }
        throw new Exception();
    }

    public List<DadosInstituicaoResponse> buscarInstituicao() throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            return instituicaoRepository.findAllByUsuario( usuario.get() );
        }
        throw new Exception();
    }

    public InstituicaoDTO buscarInstituicaoPorId( Integer id) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            InstituicaoDTO newInstituicao = instituicaoRepository.findByIdAndUsuario( id, usuario.get() ).get();
            return newInstituicao;
        }
        throw new Exception();
    }

    public String getEmail() {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal().toString();
    }

    @Transactional( rollbackFor = Exception.class )
    public Void editarInstituicao(Integer id, DadosInstituicaoRequest dadosInstituicao) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        Optional<InstituicaoDTO> instituicaoOptional = instituicaoRepository.findByIdAndUsuario( id, usuario.get() );

        if(instituicaoOptional.isPresent()) {
            Contato newContato = contatoService.editarContato(instituicaoOptional.get().getIdContato(), usuario.get(), dadosInstituicao.getContatoDTO());
            Endereco newEndereco = enderecoService.editarEndereco(instituicaoOptional.get().getIdLocalidade(), usuario.get(), dadosInstituicao.getEnderecoDTO());
            Instituicao newInstituicao = new Instituicao();
            newInstituicao.setId(instituicaoOptional.get().getId());
            newInstituicao.setNome(dadosInstituicao.getNome());
            newInstituicao.setUsuario(usuario.get());
            newInstituicao.setContato(newContato);
            newInstituicao.setEndereco(newEndereco);

            instituicaoRepository.save( newInstituicao );
        }

        throw new Exception();
    }

    @Transactional( rollbackFor = Exception.class )
    public String removerInstituicao(int id) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        Optional<InstituicaoDTO> instituicao = instituicaoRepository.findByIdAndUsuario( id, usuario.get() );

        if (instituicao.isPresent()) {
            instituicaoRepository.deleteById(id);
            return " Instituição '" + instituicao.get().getNome() + "' foi deletada!";
        }
        throw new Exception();
    }
}
