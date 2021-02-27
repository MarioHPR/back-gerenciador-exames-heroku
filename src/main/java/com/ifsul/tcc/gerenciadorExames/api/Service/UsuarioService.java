package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosUsuarioRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.DadosUsuarioResponse;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ContatoDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.EnderecoDTO;
import com.ifsul.tcc.gerenciadorExames.api.DTO.UsuarioDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import com.ifsul.tcc.gerenciadorExames.api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private EnderecoService enderecoService;

    private final String emailMatcher = "@gmail.com";

    @Transactional
    public Usuario adicionarUsuario(DadosUsuarioRequest dadosUsuario) throws Exception {
        if ( validaTamanhoDaSenha(dadosUsuario) ) {
            if ( dadosUsuario.getEmail().contains(emailMatcher) ) {
                Usuario usuario = new Usuario(dadosUsuario);
                usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
                Usuario response = repository.save(usuario);
                ContatoDTO cont = dadosUsuario.retornarContatoDTO();
                cont.setFlgContatoUsuario(Boolean.TRUE);
                EnderecoDTO end = dadosUsuario.retornarEnderecoDTO();
                end.setFlgEnderecoDoUsuario(Boolean.TRUE);
                contatoService.salvar(cont, response.getEmail());
                enderecoService.salvar(end, response.getEmail());
                return response;
            }
        }
        throw new Exception();
    }

    public DadosUsuarioResponse buscarDadosDoUsuario() throws Exception {
        String email = getEmail();
        Optional<Usuario> usuario = repository.findByEmail(email);
        if(usuario.isPresent()){
            ObjectMapper ob = new ObjectMapper();
            ContatoDTO contatoDTO = contatoService.buscarContatoDoUsuario(usuario.get());
            EnderecoDTO endereco = enderecoService.buscarEnderecoDoUsuario(usuario.get());
            return new DadosUsuarioResponse(usuario.get(), endereco, contatoDTO);
        }
        return null;
    }

    public String getEmail() {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal().toString();
    }

    private boolean validaTamanhoDaSenha(DadosUsuarioRequest dadosUsuario) {
        return dadosUsuario.getSenha().length() >= 6 && dadosUsuario.getSenha().length() <= 12;
    }

    @Transactional( rollbackFor = Exception.class )
    public UsuarioDTO alterarSenha(String email, String senha) throws Exception {

        Optional<Usuario> usuario = repository.findByEmail(email);

        if (usuario.isPresent()) {
            usuario.get().setSenha(senha);
            return new UsuarioDTO(repository.save(usuario.get()));
        }
        throw new Exception();
    }
}
