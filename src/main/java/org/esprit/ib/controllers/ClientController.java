package org.esprit.ib.controllers;

import org.esprit.ib.domain.Client;
import org.esprit.ib.domain.dto.ClientDto;
import org.esprit.ib.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    IClientService clientService;

    @PostMapping("/save")
    public Client save(@RequestBody ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @GetMapping
    public Collection<ClientDto> getAll(){
        return clientService.getAll();
    }
}
