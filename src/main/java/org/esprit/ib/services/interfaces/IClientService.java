package org.esprit.ib.services.interfaces;

import org.esprit.ib.domain.dto.ClientDto;
import org.esprit.ib.domain.entities.Client;

import java.util.Collection;
import java.util.UUID;

public interface IClientService {

	Client getClientByEmail(String email);
    void save(ClientDto clientDto);

    Collection<ClientDto> getAll();

    void delete(UUID uuid);
}
