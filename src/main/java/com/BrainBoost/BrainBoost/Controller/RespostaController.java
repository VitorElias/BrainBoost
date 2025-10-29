package com.BrainBoost.BrainBoost.Controller;

import com.BrainBoost.BrainBoost.Service.RespostaService;
import com.BrainBoost.BrainBoost.data.dto.RespostaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resposta")
public class RespostaController  {

    private static final Logger logger = LoggerFactory.getLogger(RespostaController.class);

    @Autowired
    public RespostaService rs;

    @PostMapping("/")
    public ResponseEntity<RespostaDTO> create(@RequestBody RespostaDTO resp){
        logger.info("Criando nova resposta: {}", resp);
        RespostaDTO created = rs.createResposta(resp);
        logger.info("Resposta criada com sucesso: {}", created);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespostaDTO> update(@PathVariable Long id, @RequestBody RespostaDTO resp){
        logger.info("Atualizando resposta id={} com dados: {}", id, resp);
        RespostaDTO updated = rs.updateResposta(id, resp);
        logger.info("Resposta atualizada com sucesso: {}", updated);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaDTO> findById(@PathVariable Long id){
        logger.info("Buscando resposta pelo id={}", id);
        RespostaDTO resp = rs.findById(id);
        logger.info("Resposta encontrada: {}", resp);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/")
    public ResponseEntity<List<RespostaDTO>> findAll(){
        logger.info("Buscando todas as respostas");
        List<RespostaDTO> respostas = rs.findAll();
        logger.info("Total de respostas encontradas: {}", respostas.size());
        return ResponseEntity.ok().body(respostas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        logger.info("Deletando resposta id={}", id);
        rs.delete(id);
        logger.info("Resposta id={} deletada com sucesso", id);
        return ResponseEntity.noContent().build();
    }
}
