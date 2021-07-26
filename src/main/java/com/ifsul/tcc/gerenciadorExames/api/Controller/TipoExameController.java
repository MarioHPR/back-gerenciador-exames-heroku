package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.ApiApplication;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.DadosTipoExameRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.ResumoExameRequest;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.DadosTipoExameResponse;
import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.TipoExameResponse;
import com.ifsul.tcc.gerenciadorExames.api.DTO.TipoExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.Service.TipoExameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/tipoExame")
public class TipoExameController {

    @Autowired
    TipoExameService tipoExameService;

    private Logger logger = LoggerFactory.getLogger(ApiApplication.class);

//    @PostMapping(value = "/salvar-resumo/")
//    @ResponseBody
//    public ResponseEntity<String> salvarTipoExameResumo(@RequestBody DadosTipoExameRequest tipoExameDTO ) {
//        logger.info(LocalDate.now().toString());
//        try {
//            tipoExameService.salvar(tipoExameDTO);
//            return ResponseEntity.ok().build();
//        } catch ( Exception e ) {
//            logger.error(e.getMessage());
//            return ResponseEntity.badRequest().build();
//        }
//    }

    @PostMapping(value = "/salvar-resumo/")
    @ResponseBody
    public ResponseEntity<String> salvarTipoExameResumo(@RequestBody ResumoExameRequest request ) {
        logger.info(LocalDate.now().toString());
        try {
            tipoExameService.salvar(request);
            return ResponseEntity.ok().build();
        } catch ( Exception e ) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar/todos" )
    @ResponseBody
    public ResponseEntity<List<TipoExameResponse>> todosOsTiposExames() throws Exception {
        try {
            return  ResponseEntity.ok().body(tipoExameService.buscarTodosOsTipoExamesDoUsuario());
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar/")
    @ResponseBody
    public ResponseEntity<List<DadosTipoExameResponse>> todosOsTipos() {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja tipoExame salvo!");
        try {
            return ResponseEntity.ok().body(tipoExameService.buscarTipoExamesDoUsuario());
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public TipoExameDTO editar(@PathVariable Integer id, @RequestBody TipoExameDTO tipoExameDTO) throws Exception {
        return tipoExameService.editarTipoExame(tipoExameDTO,id);
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseBody
    public ResponseEntity<String> deletarTipoExame(@PathVariable int id) {
        logger.info(LocalDate.now().toString() + ", id: " + id );

        try {
            tipoExameService.removerTipoExame( id);
            return ResponseEntity.ok().body("TipoExame removida com sucesso! ");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
