package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.ApiApplication;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosUsuarioRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.DadosUsuarioResponse;
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
    public ResponseEntity<Void> adicionarUsuario(@RequestBody DadosUsuarioRequest dadosUsuario  ) throws Exception {
        DadosUsuarioRequest teste = dadosUsuario;
        usuarioService.adicionarUsuario(dadosUsuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/editar")
    @ResponseBody
    public ResponseEntity<Void> editarDadosDoUsuario( @RequestBody DadosUsuarioRequest dadosUsuario) throws Exception {
        usuarioService.alterarDadosUsuario( dadosUsuario );
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/buscar-dados")
    @ResponseBody
    public ResponseEntity<DadosUsuarioResponse> buscarDados(){
        try {
            return ResponseEntity.ok().body(usuarioService.buscarDadosDoUsuario());
        } catch (Exception e) {
            logger.error("Erro: "+e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
