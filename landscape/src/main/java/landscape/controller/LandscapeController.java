package landscape.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/system")
public class LandscapeController {

    private final BuildProperties buildProperties;

    @Autowired
    public LandscapeController(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @GetMapping("/liveness")
    @ResponseStatus(value = HttpStatus.OK)
    public void liveness() {

    }

    @GetMapping(value = "/readiness", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, String> readiness() {
        return Collections.singletonMap(buildProperties.getName(), "OK");
    }

}