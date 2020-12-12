package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;

@RestController
public class SampleAppsController {

    @Autowired
    private SampleAppsService sampleAppsService = new SampleAppsService();

    @RequestMapping(value="/apps", method=RequestMethod.GET)
    public Apps getApps(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return sampleAppsService.getAllApps();
    }


    @RequestMapping(value="/", method=RequestMethod.GET)
    public String healthCheckResponse() {
        return "Nothing here, used for health check. Try /apps instead.";
    }

}