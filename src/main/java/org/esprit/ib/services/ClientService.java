package org.esprit.ib.services;

import org.esprit.ib.domain.Client;
import org.esprit.ib.domain.dto.ClientDto;
import org.esprit.ib.repositories.ClientRepository;
import org.esprit.ib.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Client save(ClientDto clientDto) {
        clientDto.setPassword(passwordEncoder.encode(clientDto.getPassword()));
        return clientRepository.save(clientDto.toEntity());
    }

    @Override
    public Collection<ClientDto> getAll() {
        return clientRepository.findAll().stream().map(Client::toDto).collect(Collectors.toList());
    }
}
