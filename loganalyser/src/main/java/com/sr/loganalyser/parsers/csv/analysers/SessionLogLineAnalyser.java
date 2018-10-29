package com.sr.loganalyser.parsers.csv.analysers;

import com.sr.loganalyser.parsers.csv.model.LogLineEntry;
import com.sr.loganalyser.parsers.csv.model.UrlStatSummary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SessionLogLineAnalyser {

    public static Map<String, List<UrlStatSummary>> getUrlSummary(final Map<String, List<LogLineEntry>> sessionLogMap) {

        sessionLogMap.entrySet().stream().map(stringListEntry -> stringListEntry.getKey());

        return null;
    }
}
