package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.ApiApplication;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosConsultaRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.NewDadosConsultaRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.DadosConsultaResponse;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ConsultaDTO;
import com.ifsul.tcc.gerenciadorExames.api.Service.ConsultaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/consulta")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    private Logger logger = LoggerFactory.getLogger(ApiApplication.class);

//    @PostMapping(value = "/salvar/")
//    @ResponseBody
//    public ResponseEntity<String> salvarConsulta( @RequestBody DadosConsultaRequest dadosConsulta ) {
//        logger.info(LocalDate.now().toString());
//        try {
//            consultaService.salvar(dadosConsulta);
//            return ResponseEntity.ok().build();
//        } catch ( Exception e ) {
//            logger.error(e.getMessage());
//            return ResponseEntity.badRequest().build();
//        }
//    }

    @PostMapping(value = "/salvar/")
    @ResponseBody
    public ResponseEntity<String> salvarConsulta( @RequestBody NewDadosConsultaRequest dadosConsulta ) {
        logger.info(LocalDate.now().toString());
        try {
            consultaService.salvar(dadosConsulta);
            return ResponseEntity.ok().build();
        } catch ( Exception e ) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar/consultas")
    @ResponseBody
    public ResponseEntity<List<ConsultaDTO>> todasConsultas() {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja Consultas salvas!");
        try {
            return ResponseEntity.ok().body(consultaService.buscarConsultasDoUsuario());
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar/consulta/{id}")
    @ResponseBody
    public ResponseEntity<DadosConsultaResponse> buscarConsultaPorId(@PathVariable Integer id) {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja Consulta salva!");
        try {
            return ResponseEntity.ok().body(consultaService.buscarConsultaEspecificadoUsuarioPorId(id));
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

//    @PutMapping(value = "/editar/{id}")
//    @ResponseBody
//    public ResponseEntity<DadosConsultaResponse> editar(@PathVariable Integer id, @RequestBody DadosConsultaRequest dadosConsulta) throws Exception {
//        return ResponseEntity.ok().body(consultaService.editarConsulta(dadosConsulta,id));
//    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public ResponseEntity<DadosConsultaResponse> editar(@PathVariable Integer id, @RequestBody NewDadosConsultaRequest dadosConsulta) throws Exception {
        return ResponseEntity.ok().body(consultaService.editarConsulta(dadosConsulta,id));
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseBody
    public ResponseEntity<String> deletarConsulta(@PathVariable int id) {
        logger.info(LocalDate.now().toString() + ", id: " + id );

        try {
            consultaService.removerConsulta( id);
            return ResponseEntity.ok().body("Consulta removida com sucesso! ");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
