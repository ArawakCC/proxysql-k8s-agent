package com.mitchwood.proxysql.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {

    @NonNull
    String username;
    String password;
    boolean active;
    int hostgroup;
    String schema;
    int maxConnections;
    boolean useSsl;
    boolean transactionPersistent;
    boolean fastForward;

}
