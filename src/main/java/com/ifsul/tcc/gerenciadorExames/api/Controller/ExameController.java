package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.ApiApplication;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosExameEditRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.ResumoExameRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.ExameResponse;
import com.ifsul.tcc.gerenciadorExames.api.Service.ExameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/exame")
public class ExameController {

    @Autowired
    ExameService exameService;

    private Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    @GetMapping( value = "/buscar-dados/{idExame}")
    @ResponseBody
    public ResponseEntity<ExameResponse> todosDadosExameEspecifico(@PathVariable Integer idExame ) {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja dados no exame salvas!");
        try {
            return ResponseEntity.ok().body(exameService.buscarExameEspecificadoUsuarioPorId(idExame));
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar-todos/")
    @ResponseBody
    public ResponseEntity<List<ExameResponse>> todosExamesPorUsuario() {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja exames salvas!");
        try {
            return ResponseEntity.ok().body(exameService.buscarTodosExamesDoUsuario());
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

//    @PutMapping(value = "/editar/{id}")
//    @ResponseBody
//    public ResponseEntity<ExameResponse> editar(@PathVariable Integer id, @RequestBody DadosExameEditRequest dadosExameRequest) throws Exception {
//        logger.info(LocalDate.now().toString());
//        try {
//            return ResponseEntity.ok().body(exameService.editarExame(dadosExameRequest, id));
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return ResponseEntity.badRequest().build();
//        }
//    }
    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public ResponseEntity<ExameResponse> editar(@PathVariable Integer id, @RequestBody ResumoExameRequest request) throws Exception {
        logger.info(LocalDate.now().toString());
        try {
            return ResponseEntity.ok().body(exameService.editarExame(request, id));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseBody
    public ResponseEntity<String> deletarConsulta(@PathVariable Integer id) {
        logger.info(LocalDate.now().toString() + ", id: " + id );

        try {
            exameService.removerExame(id);
            return ResponseEntity.ok().body("Consulta removida com sucesso! ");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
