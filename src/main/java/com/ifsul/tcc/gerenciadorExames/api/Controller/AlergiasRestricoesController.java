package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.ApiApplication;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.AlergiaRestricaoRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.AlergiaOuRestricaoResponse;
import com.ifsul.tcc.gerenciadorExames.api.Entity.AlergiasRestricoes;
import com.ifsul.tcc.gerenciadorExames.api.Service.AlergiasRestricoesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/restricoes")
public class AlergiasRestricoesController {

    private final AlergiasRestricoesService alergiasRestricoesService;

    public AlergiasRestricoesController(AlergiasRestricoesService alergiasRestricoesService) {
        this.alergiasRestricoesService = alergiasRestricoesService;
    }
    private Logger logger = LoggerFactory.getLogger(ApiApplication.class);
    @GetMapping( value = "/")
    @ResponseBody
    public ResponseEntity<List<AlergiaOuRestricaoResponse>> buscarRestricoes() {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja Nenhuma restrição salva!");
        try {
            return ResponseEntity.ok().body(alergiasRestricoesService.listagemAlergiaOuDescricoes());
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<Void> salvarRestricao(@RequestBody AlergiaRestricaoRequest restricao) {
        logger.info(LocalDate.now().toString());
        try {
            alergiasRestricoesService.inserirAlergiaRestricao( restricao );
            return ResponseEntity.ok().build();
        } catch ( Exception e ) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public ResponseEntity<Void> editarRestricao(@PathVariable Integer id, @RequestBody AlergiaRestricaoRequest restricao) {
        alergiasRestricoesService.editarAlergiaRestricao(id, restricao);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseBody
    public ResponseEntity<String> deletarInstituicao(@PathVariable int id) {
        logger.info(LocalDate.now().toString() + ", id: " + id );

        try {
            alergiasRestricoesService.excluirAlergiaDescricao(id);
            return ResponseEntity.ok().body("Descrição removida com sucesso! ");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
