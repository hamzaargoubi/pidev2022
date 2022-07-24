package org.esprit.ib.services.interfaces;

import org.esprit.ib.domain.dto.ClientDto;

import java.util.Collection;
import java.util.UUID;

public interface IClientService {

    void save(ClientDto clientDto);

    Collection<ClientDto> getAll();

    void delete(UUID uuid);
}
