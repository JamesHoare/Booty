package com.netaporter.booty.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.*;

/**
 * Created by jameshoare on 28/03/2014.
 */
@RestController
@RequestMapping(value = "/booty",produces = APPLICATION_JSON_VALUE)
public class BootyController {

    @RequestMapping
    public String greetingBooty(){
        return "Hello Booty";
    }

}
