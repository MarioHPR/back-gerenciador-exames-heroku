package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.ApiApplication;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ItemCampoExameDTO;
import com.ifsul.tcc.gerenciadorExames.api.Service.ItemCampoExameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/itemCampo")
public class ItemCampoExameController {
    @Autowired
    ItemCampoExameService itemCampoExameService;

    private Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    @PostMapping(value = "/salvar/{id}")
    @ResponseBody
    public ResponseEntity<String> salvarItemCampo(@PathVariable Integer id, @RequestBody ItemCampoExameDTO itemCampoExameDTO) {
        logger.info(LocalDate.now().toString());
        try {
            itemCampoExameService.salvar( itemCampoExameDTO, id );
            return ResponseEntity.ok().body("Item salvo com sucesso!");
        } catch ( Exception e ) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar/{id}")
    @ResponseBody
    public ResponseEntity<ItemCampoExameDTO> buscarItensCampoPorExame(@PathVariable Integer id) {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja itens salvos!");
        try {
            return ResponseEntity.ok().body(itemCampoExameService.buscarItemCampoPorId(id));
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping( value = "/buscar-itens/{idTipoExame}")
    @ResponseBody
    public ResponseEntity<List<ItemCampoExameDTO>> buscarItensdoTipoExame(@PathVariable Integer idTipoExame) {
        logger.info(LocalDate.now().toString());
        logger.warn("A lista pode voltar vazia caso nao haja itens salvos!");
        try {
            return ResponseEntity.ok().body(itemCampoExameService.buscarTodosItemCampoDoExame(idTipoExame));
        } catch ( Exception e ){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public ItemCampoExameDTO editarItem(@PathVariable Integer id, @RequestBody ItemCampoExameDTO itemCampoExameDTO) throws Exception {
        return itemCampoExameService.editarItemCampo(itemCampoExameDTO,id);
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseBody
    public ResponseEntity<String> deletarItem(@PathVariable int id) {
        logger.info(LocalDate.now().toString() + ",ItemCampo com id: " + id );

        try {
            itemCampoExameService.removerItemCampo( id );
            return ResponseEntity.ok().body("Item removido com sucesso! ");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
