package com.sr.loganalyser.parsers.csv.model;

public class UrlStatSummary {

    private String url;

    private long averageResponseMs;

    private long averageResponseSize;


    public String getUrl() {
        return url;
    }

    public UrlStatSummary setUrl(String url) {
        this.url = url;
        return this;
    }

    public long getAverageResponseMs() {
        return averageResponseMs;
    }

    public UrlStatSummary setAverageResponseMs(long averageResponseMs) {
        this.averageResponseMs = averageResponseMs;
        return this;
    }

    public long getAverageResponseSize() {
        return averageResponseSize;
    }

    public UrlStatSummary setAverageResponseSize(long averageResponseSize) {
        this.averageResponseSize = averageResponseSize;
        return this;
    }
}
