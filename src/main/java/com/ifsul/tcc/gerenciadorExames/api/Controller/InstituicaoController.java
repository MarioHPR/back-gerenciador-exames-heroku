package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.ApiApplication;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosInstituicaoRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.DadosInstituicaoResponse;
import com.ifsul.tcc.gerenciadorExames.api.DTO.InstituicaoDTO;
import com.ifsul.tcc.gerenciadorExames.api.Service.InstituicaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/instituicao")
public class InstituicaoController {

    @Autowired
    InstituicaoService instituicaoService;

    private Logger logger = LoggerFactory.getLogger(ApiApplication.class);
    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<String> salvarInstituicao(@RequestBody DadosInstituicaoRequest dadosInstituicao ) {
        logger.info(LocalDate.now().toString());
        try {
            instituicaoService.adicionarInstituicao( dadosInstituicao );
            return ResponseEntity.ok().build();
        } catch ( Exception e ) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar/instituicoes")
    @ResponseBody
    public ResponseEntity<List<DadosInstituicaoResponse>> todasInstituicoes() {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja Nenhuma instituição salva!");
        try {
            return ResponseEntity.ok().body(instituicaoService.buscarInstituicao());
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar/{id}")
    @ResponseBody
    public ResponseEntity<DadosInstituicaoResponse> buscarInstituicaoPorId(@PathVariable Integer id) {
        logger.info(LocalDate.now().toString());
        logger.warn("Pode voltar vazio caso nao haja Nenhuma instituição salva!");
        try {
            return ResponseEntity.ok().body(instituicaoService.buscarInstituicaoPorId(id));
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public ResponseEntity<Void> editar(@PathVariable Integer id, @RequestBody DadosInstituicaoRequest dadosInstituicao) throws Exception {
        instituicaoService.editarInstituicao(id, dadosInstituicao);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseBody
    public ResponseEntity<String> deletarInstituicao(@PathVariable int id) {
        logger.info(LocalDate.now().toString() + ", id: " + id );

        try {
            instituicaoService.removerInstituicao( id);
            return ResponseEntity.ok().body("Instituicao removida com sucesso! ");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
