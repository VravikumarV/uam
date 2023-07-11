package com.techgaints.plugins.uam;


import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class MUserControllerTest {

    @Autowired
    private ResourceLoader resourceLoader;


    @Before
    public void loadFileData() throws IOException {
        Resource fileResource = resourceLoader.getResource("classpath:feed/indexData.csv");
        List<String> lines = Files.readAllLines(Paths.get(fileResource.getURI()));
        lines.stream().forEach(line -> log.info(line));
    }

    @Test
    public void testCase() throws IOException {
        Resource fileResource = resourceLoader.getResource("classpath:feed/indexData.csv");
        List<String> lines = Files.readAllLines(Paths.get(fileResource.getURI()));
        lines.stream().forEach(line -> log.info(line));
        assertEquals(5, lines.size());
    }

}

