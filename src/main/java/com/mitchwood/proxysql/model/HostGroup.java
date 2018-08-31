package com.mitchwood.proxysql.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class HostGroup {

    @NonNull
    int writerGroupId;

    @NonNull
    int readerGroupId;

    String description;
}
