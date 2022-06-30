package org.esprit.ib.services.interfaces;

import org.esprit.ib.domain.Client;
import org.esprit.ib.domain.dto.ClientDto;

import java.util.Collection;

public interface IClientService {

    Client save(ClientDto clientDto);

    Collection<ClientDto> getAll();
}
