package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.ApiApplication;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosUsuarioRequest;
import com.ifsul.tcc.gerenciadorExames.api.DTO.UsuarioDTO;
import com.ifsul.tcc.gerenciadorExames.api.Service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    private Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<Void> adicionarUsuario(@RequestBody DadosUsuarioRequest dadosUsuario  ) {
        try{
            usuarioService.adicionarUsuario(dadosUsuario);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            logger.error("Erro ao salvar usuario: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/editar/senha")
    @ResponseBody
    public ResponseEntity<String> trocarSenha( @RequestBody UsuarioDTO usuarioDTO) {
        try {
            usuarioService.alterarSenha( usuarioDTO.getEmail(), usuarioDTO.getSenha() );
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro: "+e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
