package com.ifsul.tcc.gerenciadorExames.api.Security;


import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import com.ifsul.tcc.gerenciadorExames.api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        if(usuario.isPresent()){
            return new User(
                    usuario.get().getUsername(),
                    usuario.get().getPassword(),
                    true,
                    true,
                    true,
                    true,
                    usuario.get().getAuthorities());
        }
        throw new UsernameNotFoundException("Usuario não existe!");
    }
}
