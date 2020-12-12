package com.example;

import java.util.List;

public class Apps {

    private List<App> Apps;

    public Apps(List<App> Apps) {
        this.Apps = Apps;
    }

    public Apps() {}

    public java.util.List<App> getApps() {
        return Apps;
    }

    public void setApps(List<App> Apps) {
        this.Apps = Apps;
    }
}
