package com.sportsradar.sportsServiceApi.enums;

import javax.swing.*;

public enum StatusType {

    COMPLETED("Completed"),

    SCHEDULED("Scheduled"),
    Live("Live");

    private String status;

    StatusType(String status) {
        this.status = status;
    }

    public String value() {
        return status;
    }

    public static StatusType fromValue(String e) {
        for (StatusType a : StatusType.values()) {
            if (a.value().equalsIgnoreCase(e)) {
                return a;
            }
        }
        throw new IllegalArgumentException(e);
    }

}
