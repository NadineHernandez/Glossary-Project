package com.trilogyed.glossaryservice.service;

import com.trilogyed.glossaryservice.model.Definition;
import com.trilogyed.glossaryservice.util.feign.DefinitionClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class ServiceLayerTest {

    private DefinitionClient definitionClient;
    private ServiceLayer serviceLayer;

    private void setupDefinitionClient() {
        definitionClient = mock(DefinitionClient.class);
        Definition definition = new Definition();
        definition.setId(1);
        definition.setDefinition("define");
        definition.setTerm("term");

        Definition definition2 = new Definition();
        definition2.setDefinition("define");
        definition2.setTerm("term");

        List<Definition> list = new ArrayList<>();
        list.add(definition);

        doReturn(definition).when(definitionClient).addDefinition(definition2);
        doReturn(list).when(definitionClient).getDefinitionByTerm(definition2.getTerm());
    }


    @Before
    public void setUp() throws Exception {
        setupDefinitionClient();
        serviceLayer = new ServiceLayer(definitionClient);

    }

    @Test
    public void saveDefinition() {
        Definition definition2 = new Definition();
        definition2.setDefinition("define");
        definition2.setTerm("term");
        definition2 = serviceLayer.saveDefinition(definition2);
        assertEquals(1, serviceLayer.findDefinitionsForTerm(definition2.getTerm()).size());

    }

    @Test
    public void findDefinitionsForTerm() {

        Definition definition2 = new Definition();
        definition2.setDefinition("define");
        definition2.setTerm("term");
        definition2 = serviceLayer.saveDefinition(definition2);
        assertEquals(1, serviceLayer.findDefinitionsForTerm(definition2.getTerm()).size());

    }
}