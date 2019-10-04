package com.trilogyed.glossaryservice.service;

import com.trilogyed.glossaryservice.model.Definition;
import com.trilogyed.glossaryservice.util.feign.DefinitionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceLayer {

    private DefinitionClient feign;

    @Autowired
    public ServiceLayer(DefinitionClient feign){
        this.feign = feign;
    }


    public Definition saveDefinition(Definition definition){
        return feign.addDefinition(definition);
    }

    public List<Definition> findDefinitionsForTerm(String term){
        return feign.getDefinitionByTerm(term);
    }




}