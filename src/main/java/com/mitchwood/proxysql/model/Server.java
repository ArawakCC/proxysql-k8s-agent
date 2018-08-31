package com.mitchwood.proxysql.model;

import lombok.NonNull;

public class Server {

    boolean writeable = false;

    @NonNull
    String hostname;

}
