package org.esprit.ib.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping("/health")
    public String health() {
        return "Server is OK!";
    }
}
