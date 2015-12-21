package com.aaronbandt.operations;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaronbandt.operations.exception.HealthcheckFileNotFoundException;

@Controller
public class HealthcheckController {

    private String healthcheckFilePath;

    @RequestMapping(value = "/healthcheck", method = {RequestMethod.GET, RequestMethod.HEAD})
    @ResponseBody
    public String healthcheck() {
        File file = new File(healthcheckFilePath);
        if (!file.exists()) {
            throw new HealthcheckFileNotFoundException(healthcheckFilePath);
        }
        return "OK";
    }

    public String getHealthcheckFilePath() {
        return healthcheckFilePath;
    }

    public void setHealthcheckFilePath(String healthcheckFilePath) {
        this.healthcheckFilePath = healthcheckFilePath;
    }

}
