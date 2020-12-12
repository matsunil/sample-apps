package com.example;

import org.springframework.stereotype.Service;


@Service
public class SampleAppsService {

    private Apps allApps;

    public void save(Apps apps) {
        allApps = apps;
    }

    public Apps getAllApps() {
        return allApps;
    }

}
