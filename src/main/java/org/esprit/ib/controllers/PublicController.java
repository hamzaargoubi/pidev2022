package org.esprit.ib.controllers;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.esprit.ib.utils.TokenPlayLoadExtractor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/public")
public class PublicController {

    private static final HashMap String = null;

	@GetMapping("/ping")
    public String ping() {
        return "Server is OK!";
    }
    
    @PostMapping("/testConvertToken")
    public Map<String,String> convertToken(@RequestHeader("Authorization") String token) {

        return TokenPlayLoadExtractor.extract(token);

    }
}
