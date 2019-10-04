package com.trilogyed.glossaryservice.util.feign;

import com.trilogyed.glossaryservice.model.Definition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "definition-service")
public interface DefinitionClient {

    @GetMapping(value = "/definition/term/{term}")
    public List<Definition> getDefinitionByTerm(@PathVariable String term);

    @PostMapping(value = "/definition")
    public Definition addDefinition (@RequestBody Definition definition);
}
