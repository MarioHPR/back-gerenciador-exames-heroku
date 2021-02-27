package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.ifsul.tcc.gerenciadorExames.api.DTO.ContatoDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Contato;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import com.ifsul.tcc.gerenciadorExames.api.Repository.ContatoRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService  {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Transactional( rollbackFor = Exception.class )
    public ContatoDTO salvar(ContatoDTO contatoDTO, String email) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if(usuario.isPresent()){
            Contato contato = new Contato(contatoDTO);
            contato.setUsuario( usuario.get() );
            Contato contatoPersistido = contatoRepository.save( contato );

            return  new ContatoDTO(contatoPersistido);
        }
        throw new Exception();
    }

    public List<ContatoDTO> buscarContatos() throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            return contatoRepository.findAllByUsuario( usuario.get() );
        }
        throw new Exception();
    }

    public ContatoDTO buscarContatoPorId( Integer id) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            return contatoRepository.findByIdAndUsuario( id, usuario.get() ).get();
        }
        throw new Exception();
    }

    public ContatoDTO buscarContatoDoUsuario(Usuario usuario) throws Exception {
        return contatoRepository.findByUsuarioAndFlgContatoUsuarioIsTrue(usuario);
    }

    public String getEmail() {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal().toString();
    }
}
