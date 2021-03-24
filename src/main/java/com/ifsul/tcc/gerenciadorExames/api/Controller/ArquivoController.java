package com.ifsul.tcc.gerenciadorExames.api.Controller;


import com.ifsul.tcc.gerenciadorExames.api.Entity.Arquivo;
import com.ifsul.tcc.gerenciadorExames.api.Repository.ArquivoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/arquivo")
public class ArquivoController {

    @Autowired
    private ArquivoRepository arquivoRepository;

    /*
     * MultipartFile Upload
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<Long> uploadMultipartFile(@RequestParam("upload") MultipartFile file) {
        try {
            // save file to PostgreSQL
            Arquivo filemode = new Arquivo(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            Arquivo arquivoResponse = arquivoRepository.save(filemode);
            return ResponseEntity.ok().body(arquivoResponse.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        Optional<Arquivo> fileOptional = arquivoRepository.findById(id);

        if(fileOptional.isPresent()) {
            Arquivo file = fileOptional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(file.getPic());
        }

        return ResponseEntity.status(404).body(null);
    }
}
