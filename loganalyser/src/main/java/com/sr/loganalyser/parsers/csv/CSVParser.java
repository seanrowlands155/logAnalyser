package com.sr.loganalyser.parsers.csv;

import com.sr.loganalyser.parsers.csv.model.LogLineEntry;
import org.apache.commons.csv.CSVFormat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class CSVParser {

    public static List<LogLineEntry> parseCsvToLogLineEntries(final ByteArrayInputStream inputStream) throws IOException {
        InputStreamReader in = new InputStreamReader(inputStream);
        org.apache.commons.csv.CSVParser csvFileToRead = CSVFormat.DEFAULT.parse(in);
        List<LogLineEntry> logLineEntries = new ArrayList<>();

        csvFileToRead.getRecords().forEach(csv ->
                logLineEntries.add(new LogLineEntry()
                        .setIpAddress(csv.get(0))
                        .setSessionId(csv.get(1))
                        .setDateTime(csv.get(2))
                        .setHttpMethod(csv.get(4))
                        .setBaseURL(csv.get(5))));

        return logLineEntries;
    }

    public static Map<String, List<LogLineEntry>> mapBySessionID(final List<LogLineEntry> logLineEntries) {
        return logLineEntries.stream().collect(groupingBy(LogLineEntry::getSessionId));
    }

}
