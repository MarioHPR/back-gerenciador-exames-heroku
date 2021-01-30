package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.ifsul.tcc.gerenciadorExames.api.DTO.UsuarioDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import com.ifsul.tcc.gerenciadorExames.api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    private final String emailMatcher = "@gmail.com";

    @Transactional
    public UsuarioDTO adicionarUsuario(UsuarioDTO usuarioDTO ) throws Exception {

        if ( validaTamanhoDaSenha(usuarioDTO) ) {

            if ( usuarioDTO.getEmail().contains(emailMatcher) ) {
                Usuario usuario = new Usuario(usuarioDTO);
                usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
                return new UsuarioDTO(repository.save(usuario));
            }
        }
        throw new Exception();
    }

    private boolean validaTamanhoDaSenha(UsuarioDTO usuarioDTO) {
        return usuarioDTO.getSenha().length() >= 6 && usuarioDTO.getSenha().length() <= 12;
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
