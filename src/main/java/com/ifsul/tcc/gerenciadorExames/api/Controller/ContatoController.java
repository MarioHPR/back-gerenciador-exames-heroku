package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.ApiApplication;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ContatoDTO;
import com.ifsul.tcc.gerenciadorExames.api.Service.ContatoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/contato")
public class ContatoController {
    @Autowired
    ContatoService contatoService;

    private Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    @PostMapping(value = "/salvar-contato/{email}")
    @ResponseBody
    public ResponseEntity<String> salvarContato( @PathVariable String email, @RequestBody ContatoDTO contatoDTO ) {
        logger.info(LocalDate.now().toString());
        try {
            contatoService.salvar( contatoDTO, email );
            return ResponseEntity.ok().build();
        } catch ( Exception e ) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<ContatoDTO> salvarContato( @RequestBody ContatoDTO contatoDTO ) {
        logger.info(LocalDate.now().toString());
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getPrincipal().toString();
        try {
            return ResponseEntity.ok().body(contatoService.salvar(contatoDTO, email));
        } catch ( Exception e ) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar/contato")
    @ResponseBody
    public ResponseEntity<List<ContatoDTO>> todosContatos() {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja Contato salvo!");
        try {
            return ResponseEntity.ok().body(contatoService.buscarContatos());
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar/{id}")
    @ResponseBody
    public ResponseEntity<ContatoDTO> buscarContatoPorId(@PathVariable Integer id ) {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja Contato salvo!");
        try {
            return ResponseEntity.ok().body(contatoService.buscarContatoPorId(id));
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }
}
