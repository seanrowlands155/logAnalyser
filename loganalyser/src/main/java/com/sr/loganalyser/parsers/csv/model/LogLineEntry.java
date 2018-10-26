package com.sr.loganalyser.parsers.csv.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogLineEntry {

    private static final String DATE_TIME_PATTERN = "dd/MMM/yyyy:HH:mm:ss";

    private static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    private String ipAddress;

    private String sessionId;

    private LocalDateTime dateTime;

    private String httpMethod;

    private String baseURL;

    private String queryString;

    private int httpStatusCode;

    private long responseSize;

    private long responseTimeMu;

    public LogLineEntry() {
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LogLineEntry setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public LogLineEntry setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public LogLineEntry setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public LogLineEntry setBaseURL(String baseURL) {
        this.baseURL = baseURL;
        return this;
    }

    public String getQueryString() {
        return queryString;
    }

    public LogLineEntry setQueryString(String queryString) {
        this.queryString = queryString;
        return this;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public LogLineEntry setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
        return this;
    }

    public long getResponseSize() {
        return responseSize;
    }

    public LogLineEntry setResponseSize(long responseSize) {
        this.responseSize = responseSize;
        return this;
    }

    public long getResponseTimeMu() {
        return responseTimeMu;
    }

    public LogLineEntry setResponseTimeMu(long responseTimeMu) {
        this.responseTimeMu = responseTimeMu;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LogLineEntry setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public LogLineEntry setDateTime(final String dateTimeString) {
        this.setDateTime(LocalDateTime.parse(dateTimeString, DATE_TIME_FORMATTER));
        return this;
    }
}
