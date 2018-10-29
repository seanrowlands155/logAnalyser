package com.sr.loganalyser.parsers.csv.analysers;

import com.sr.loganalyser.parsers.csv.model.LogLineEntry;
import com.sr.loganalyser.parsers.csv.model.UrlStatSummary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SessionLogLineAnalyser {

    public static Map<String, List<UrlStatSummary>> getUrlSummary(final Map<String, Map<String, List<LogLineEntry>>> sessionToUrlMap) {

        Map<String,List<UrlStatSummary>> result = sessionToUrlMap.values().stream()
                .flatMap(stringListMap -> stringListMap.values().stream())
                .flatMap(logLineEntries -> logLineEntries.stream())
                .map(logLineEntry -> new UrlStatSummary().setUrl(logLineEntry.getBaseURL()))
                .collect(Collectors.groupingBy(UrlStatSummary::getUrl));

        return null;
    }
}
