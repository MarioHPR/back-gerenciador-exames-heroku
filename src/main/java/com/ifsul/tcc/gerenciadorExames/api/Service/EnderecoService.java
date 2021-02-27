package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.ifsul.tcc.gerenciadorExames.api.DTO.EnderecoDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Endereco;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import com.ifsul.tcc.gerenciadorExames.api.Repository.EnderecoRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional( rollbackFor = Exception.class )
    public EnderecoDTO salvar(EnderecoDTO enderecoDTO, String email) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if(usuario.isPresent()){
            Endereco endereco = new Endereco(enderecoDTO);
            endereco.setUsuario( usuario.get() );
            Endereco enderecoPersistido = enderecoRepository.save( endereco );

            return  new EnderecoDTO(enderecoPersistido);
        }
        throw new Exception();
    }

    @Transactional( rollbackFor = Exception.class )
    public String removerEndereco(int idEndereco) throws Exception {
        String email = getEmail();
        Optional<Endereco> endereco = enderecoRepository.findById(idEndereco);

        if (endereco.isPresent()) {
            enderecoRepository.deleteById(idEndereco);
            return endereco.get().getCep() + " deletada";
        }
        throw new Exception();
    }

    public EnderecoDTO buscarEndereco() throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            return new EnderecoDTO(enderecoRepository.findByUsuario( usuario.get() ).get());
        }
        throw new Exception();
    }

    public EnderecoDTO buscarEnderecoPorId(Integer id) throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            return new EnderecoDTO(enderecoRepository.findByIdAndUsuario( id, usuario.get() ).get());
        }
        throw new Exception();
    }

    public String getEmail() {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal().toString();
    }
    public EnderecoDTO buscarEnderecoDoUsuario(Usuario usuario) throws Exception {
        return enderecoRepository.findByUsuarioAndFlgEnderecoDoUsuarioIsTrue(usuario);
    }
}
