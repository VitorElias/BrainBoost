package com.BrainBoost.BrainBoost.Controller;

import com.BrainBoost.BrainBoost.Service.DesafioService;
import com.BrainBoost.BrainBoost.data.dto.DesafioDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/desafios")
public class DesafioController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger logger = LoggerFactory.getLogger(DesafioController.class);

    @Autowired
    private DesafioService ds;

    @PostMapping("/create")
    public ResponseEntity<DesafioDTO> create(@RequestBody DesafioDTO def){

        logger.info("API = desafios/create");

        logger.info("Puxando os dados para a função!");
        DesafioDTO df = ds.create(def);

        return ResponseEntity.status(HttpStatus.CREATED).body(df);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesafioDTO> update(@PathVariable Long id , @RequestBody DesafioDTO def){

        logger.info("API /desafios/id={}",id);
        DesafioDTO def2 = ds.update(id,def);

        logger.info("Usuario Atualizado com sucesso id={}",id);
        return ResponseEntity.status(HttpStatus.OK).body(def2);
    }

    @GetMapping("/")
    public ResponseEntity<List<DesafioDTO>> findAll(){

        logger.info("API /desafios/ listar todos os usuarios:");
        List<DesafioDTO> users = ds.listAll();

        logger.info("Busca no banco por todos os usuários");
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesafioDTO> findById(@PathVariable Long id) {

        logger.info("API desafio/{id} : Buscar desafio por id");
        DesafioDTO desafio = ds.findDesafioById(id);

        logger.info("desafio buscado com  ID={}",desafio.getId());
        return ResponseEntity.ok(desafio);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("API desafio/delete/{id}");
        ds.deleteById(id);

        logger.info("desafio deletado id={}",id);
        return ResponseEntity.noContent().build();
    }




}
