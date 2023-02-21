package com.lostsidewalk.buffy.app.model;

import com.lostsidewalk.buffy.query.QueryMetrics;
import lombok.Data;

import java.util.Date;

@Data
public class QueryMetricsWithErrorDetails {

    private Long queryId;
    private Integer httpStatusCode;
    private String httpStatusMessage;
    private String redirectFeedUrl;
    private Integer redirectHttpStatusCode;
    private String redirectHttpStatusMessage;
    private Integer importCt;
    private Integer persistCt;
    private Date importTimestamp;
    private String queryExceptionTypeMessage;

    public QueryMetricsWithErrorDetails(Long queryId, Integer httpStatusCode, String httpStatusMessage, String redirectFeedUrl, Integer redirectHttpStatusCode, String redirectHttpStatusMessage, Integer importCt, Integer persistCt, Date importTimestamp, String queryExceptionTypeMessage) {
        this.queryId = queryId;
        this.httpStatusCode = httpStatusCode;
        this.httpStatusMessage = httpStatusMessage;
        this.redirectFeedUrl = redirectFeedUrl;
        this.redirectHttpStatusCode = redirectHttpStatusCode;
        this.redirectHttpStatusMessage = redirectHttpStatusMessage;
        this.importCt = importCt;
        this.persistCt = persistCt;
        this.importTimestamp = importTimestamp;
        this.queryExceptionTypeMessage = queryExceptionTypeMessage;
    }

    public static QueryMetricsWithErrorDetails from(QueryMetrics queryMetrics, String errorDetails) {
        return new QueryMetricsWithErrorDetails(
                queryMetrics.getQueryId(),
                queryMetrics.getHttpStatusCode(),
                queryMetrics.getHttpStatusMessage(),
                queryMetrics.getRedirectFeedUrl(),
                queryMetrics.getRedirectHttpStatusCode(),
                queryMetrics.getRedirectHttpStatusMessage(),
                queryMetrics.getImportCt(),
                queryMetrics.getPersistCt(),
                queryMetrics.getImportTimestamp(),
                errorDetails);
    }
}