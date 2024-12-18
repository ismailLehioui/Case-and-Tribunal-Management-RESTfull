package com.enicar.soc.services;

import com.enicar.soc.entities.Client;
import com.enicar.soc.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientServce{
    @Autowired
    ClientRepository clientRepository;

   @Override
    public List<Client> getAllClients(){
       return clientRepository.findAll();
   }
   @Override
    public Client getClientById(Long id){
       return clientRepository.findById(id).orElseThrow();
   }
   @Override
    public Client addClient(Client client){
       clientRepository.save(client);
       return null;
   }
   @Override
    public Client deleteClientById(Long id){
       //Client client = clientRepository.findById(id);
       return null;
   }
}
