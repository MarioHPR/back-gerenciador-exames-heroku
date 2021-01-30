package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.ApiApplication;
import com.ifsul.tcc.gerenciadorExames.api.DTO.EnderecoDTO;
import com.ifsul.tcc.gerenciadorExames.api.Service.EnderecoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    private Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    @PostMapping(value = "/salvar-localidade/{email}")
    @ResponseBody
    public ResponseEntity<EnderecoDTO> salvarEndereco(@PathVariable String email, @RequestBody EnderecoDTO enderecoDTO ) {
        logger.info(LocalDate.now().toString());
        try {
            return ResponseEntity.ok().body(enderecoService.salvar( enderecoDTO, email ));
        } catch ( Exception e ) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<EnderecoDTO> salvarEndereco(@RequestBody EnderecoDTO enderecoDTO ) {
        logger.info(LocalDate.now().toString());
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getPrincipal().toString();
        try {
            return ResponseEntity.ok().body(enderecoService.salvar(enderecoDTO, email));
        } catch ( Exception e ) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar/enderecos")
    @ResponseBody
    public ResponseEntity<EnderecoDTO> todosEnderecos() {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja Endereco salvo!");
        try {
            return ResponseEntity.ok().body(enderecoService.buscarEndereco());
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar/endereco/{id}")
    @ResponseBody
    public ResponseEntity<EnderecoDTO> buscarEnderecoEspecifico(@PathVariable Integer id) {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja Endereco salvo!");
        try {
            return ResponseEntity.ok().body(enderecoService.buscarEnderecoPorId(id));
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseBody
    public ResponseEntity<String> deletarEndereco(@PathVariable int id) {
        logger.info(LocalDate.now().toString() + ", id: " + id );
        try {
            return ResponseEntity.ok().body("Endereco removido com sucesso! " + enderecoService.removerEndereco(id));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
