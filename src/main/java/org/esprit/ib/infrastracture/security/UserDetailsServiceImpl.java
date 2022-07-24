package org.esprit.ib.infrastracture.security;

import lombok.extern.log4j.Log4j2;
import org.esprit.ib.domain.entities.Client;
import org.esprit.ib.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email);
        if (client == null) {
            log.error("Client not found");
            throw new UsernameNotFoundException("Client not found");
        }

        return new User(client.getCredentials().getEmail(), client.getCredentials().getPassword(), new ArrayList<>());
    }
}
