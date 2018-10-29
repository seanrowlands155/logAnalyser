package com.sr.loganalyser.parsers.csv;

import com.sr.loganalyser.parsers.csv.model.LogLineEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CSVWriterTest {

    @Autowired
    private ResourceLoader resourceLoader;


    @Autowired
    private CSVWriter csvWriter;

    @Autowired
    private CSVParser csvParser;

    @Test
    public void writeToStatsFile() throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(resourceLoader
                .getResource("classpath:Real_log.csv").getInputStream()));
        final ByteArrayInputStream csvInput = new ByteArrayInputStream(reader.lines().collect(Collectors.joining("\n")).getBytes());


        final List<LogLineEntry> logLineEntries = CSVParser.parseCsvToLogLineEntries(csvInput);
        CSVParser.sortLogLineEntries(logLineEntries, Comparator.comparing(LogLineEntry::getSessionId).thenComparing(LogLineEntry::getDateTime));

       // csvWriter.writeToStatsFile(logLineEntries);
    }
}