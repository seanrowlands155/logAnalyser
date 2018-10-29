package com.sr.loganalyser.parsers.csv;

import com.sr.loganalyser.parsers.csv.model.LogLineEntry;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CSVWriter {

    private final Path path;

    public CSVWriter(@Value("${output.location}") final String path) {
        this.path = Paths.get(path);
    }

    public synchronized void writeToStatsFile(final List<LogLineEntry> resultsToWrite) throws IOException {
        CSVPrinter printer = new CSVPrinter(Files.newBufferedWriter(path), CSVFormat.EXCEL);
        resultsToWrite.forEach(logLineEntry -> {
            try {
                printer.printRecord(logLineEntry.getSessionId(),logLineEntry.getHttpMethod(), logLineEntry.getBaseURL(), logLineEntry.getDateTime());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        printer.close(true);
    }
}
