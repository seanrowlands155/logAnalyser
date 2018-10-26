package com.sr.loganalyser.parsers;

import com.sr.loganalyser.parsers.csv.CSVParser;
import com.sr.loganalyser.parsers.csv.model.LogLineEntry;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
public class CSVParserTest {

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void parseCSV() throws IOException {

        final ByteArrayInputStream csvInput = new ByteArrayInputStream(resourceLoader
                .getResource("classpath:TestData.csv")
                .getInputStream()
                .readAllBytes());

        final List<LogLineEntry> result = CSVParser.parseCsvToLogLineEntries(csvInput);
        Assert.assertEquals("Result Size Correct", result.size(), 16);
        Assert.assertEquals("IP Address Correct", result.get(0).getIpAddress(), "213.216.144.200");

    }

    @Test
    public void mapBySessionID() throws IOException {
        final ByteArrayInputStream csvInput = new ByteArrayInputStream(resourceLoader
                .getResource("classpath:TestData.csv")
                .getInputStream()
                .readAllBytes());

        final List<LogLineEntry> logLineEntries = CSVParser.parseCsvToLogLineEntries(csvInput);
        Map<String, List<LogLineEntry>> resultSessionMap = CSVParser.mapBySessionID(logLineEntries);
        Assert.assertEquals(1, resultSessionMap.size());
        Assert.assertEquals(16, resultSessionMap.get("01B031744910BA97E686D890741DEBB6").size());
    }

    @Test
    public void mapBySessionIdMultipleSessions() throws IOException {
        final ByteArrayInputStream csvInput = new ByteArrayInputStream(resourceLoader
                .getResource("classpath:TestDataTwoSessions.csv")
                .getInputStream()
                .readAllBytes());

        final List<LogLineEntry> logLineEntries = CSVParser.parseCsvToLogLineEntries(csvInput);
        Map<String, List<LogLineEntry>> resultSessionMap = CSVParser.mapBySessionID(logLineEntries);
        Assert.assertEquals(2, resultSessionMap.size());

    }
}