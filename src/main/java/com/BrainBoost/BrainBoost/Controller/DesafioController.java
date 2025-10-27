package com.BrainBoost.BrainBoost.Controller;

import com.BrainBoost.BrainBoost.Service.DesafioService;
import com.BrainBoost.BrainBoost.model.Desafio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/desafios")
public class DesafioController {

    private static Logger logger = LoggerFactory.getLogger(DesafioController.class);

    @Autowired
    private DesafioService ds;

    @PostMapping("/create")
    public ResponseEntity<Desafio> create(@RequestBody Desafio def){

        logger.info("API = desafios/create");

        logger.info("Puxando os dados para a função!");
        Desafio df = ds.create(def);

        return ResponseEntity.status(HttpStatus.CREATED).body(df);
    }



}
