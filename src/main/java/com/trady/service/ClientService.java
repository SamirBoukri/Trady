package com.trady.service;

import com.trady.model.Client;
import com.trady.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {return clientRepository.findAll();};

    public Client saveClient(Client client) {return clientRepository.save(client);};

    public Client updateclient(Client client, Long id) {
        return clientRepository.findById(id).map(existing -> {
            existing.setNom(client.getNom());
            existing.setPrenom(client.getPrenom());
            return clientRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("client non trouvé"));
    }

    public void deleteclient(Long id) {
        clientRepository.deleteById(id);
    }
}
