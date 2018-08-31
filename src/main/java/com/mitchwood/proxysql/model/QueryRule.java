package com.mitchwood.proxysql.model;

import lombok.Data;

@Data
public class QueryRule {

    int id;
    boolean active;
    String username;
    String schemaname;
    int flagIn;
    String clientAddr;
    String proxyAddr;
    int proxyPort;
    String digest;
    String matchDigest;
    String matchPattern;
    boolean negateMatchPattern;
    String regexModifiers;
    int flagOut;
    String replacePattern;
    int destinationHostGroup;
    Integer cacheTtl;
    boolean reconnect;
    int timeout;
    int retries;
    int delay;
    int mirrorFlagOut;
    int mirrorHostGroup;
    String errorMessage;
    boolean stickyConnection;
    boolean multiplex;
    boolean log;
    boolean apply;
    String comment;

}
