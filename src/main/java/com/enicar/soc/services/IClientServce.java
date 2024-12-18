package com.enicar.soc.services;

import com.enicar.soc.entities.Client;
import com.enicar.soc.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientServce {

    List<Client> getAllClients();

    Client getClientById(Long id);

    Client addClient(Client client);

    Client deleteClientById(Long id);
}
