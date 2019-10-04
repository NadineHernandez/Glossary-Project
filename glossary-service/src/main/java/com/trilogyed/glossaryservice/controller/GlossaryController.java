package com.trilogyed.glossaryservice.controller;

import com.trilogyed.glossaryservice.model.Definition;
import com.trilogyed.glossaryservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/glossary")
public class GlossaryController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    public Definition addDefinition(@RequestBody Definition definition){
        return serviceLayer.saveDefinition(definition);
    }


    @GetMapping("/term/{term}")
    public List<Definition> getDefinitionsForTerm(@PathVariable String term){
        return serviceLayer.findDefinitionsForTerm(term);
    }




}
