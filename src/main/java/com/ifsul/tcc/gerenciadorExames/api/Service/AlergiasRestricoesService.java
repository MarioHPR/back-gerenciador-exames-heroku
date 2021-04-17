package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.AlergiaRestricaoRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.AlergiaOuRestricaoResponse;
import com.ifsul.tcc.gerenciadorExames.api.Entity.AlergiasRestricoes;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import com.ifsul.tcc.gerenciadorExames.api.Repository.AlergiasRestricoesRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlergiasRestricoesService {

    private final AlergiasRestricoesRepository alergiasRestricoesRepository;
    private final UsuarioRepository usuarioRepository;

    public AlergiasRestricoesService(AlergiasRestricoesRepository alergiasRestricoesRepository, UsuarioRepository usuarioRepository) {
        this.alergiasRestricoesRepository = alergiasRestricoesRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void inserirAlergiaRestricao(AlergiaRestricaoRequest alergiaOuRestricao) {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        if(usuario.isPresent()){
            AlergiasRestricoes newAlergiaRestricao = new AlergiasRestricoes(alergiaOuRestricao);
            newAlergiaRestricao.setUsuario(usuario.get());
            alergiasRestricoesRepository.save(newAlergiaRestricao);
        }
    }

    public void editarAlergiaRestricao(Integer id, AlergiaRestricaoRequest alergiaOuRestricao) {
        Optional<AlergiasRestricoes> oldAlergiaRestricao = alergiasRestricoesRepository.findById(id);
        if(oldAlergiaRestricao.isPresent()){
            oldAlergiaRestricao.get().setTipo(alergiaOuRestricao.getTipo());
            oldAlergiaRestricao.get().setDescricao(alergiaOuRestricao.getDescricao());
            alergiasRestricoesRepository.save(oldAlergiaRestricao.get());
        }
    }

    public void excluirAlergiaDescricao(Integer id) {
        Optional<AlergiasRestricoes> alergiaOuDescricao = alergiasRestricoesRepository.findById(id);
        alergiaOuDescricao.ifPresent(alergiasRestricoesRepository::delete);
    }

    public List<AlergiaOuRestricaoResponse> listagemAlergiaOuDescricoes() {
        String email = getEmail();
        Optional<Usuario> usuario = usuarioRepository.findByEmail( email );
        return usuario.map(alergiasRestricoesRepository::findAllByUsuarioOrderByTipo).orElse(null);
    }

    public String getEmail() {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal().toString();
    }
}
