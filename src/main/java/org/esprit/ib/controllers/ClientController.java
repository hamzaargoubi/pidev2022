package org.esprit.ib.controllers;

import org.esprit.ib.domain.dto.ClientDto;
import org.esprit.ib.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    IClientService clientService;

    @PostMapping("/save")
    public boolean save(@RequestBody ClientDto clientDto) {
        clientService.save(clientDto);
        return true;
    }

    @GetMapping
    public Collection<ClientDto> getAll() {
        return clientService.getAll();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") UUID uuid) {
        clientService.delete(uuid);
        return true;
    }
}
