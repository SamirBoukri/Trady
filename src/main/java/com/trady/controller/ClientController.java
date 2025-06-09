package com.trady.controller;

import com.trady.model.Client;
import com.trady.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {this.clientService = clientService;}

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/{id}")
    public Client updateclient(@PathVariable Long id, @RequestBody Client c) {
        return clientService.updateclient(c, id);
    }

    @DeleteMapping("/{id}")
    public void deleteclient(@PathVariable Long id) {
        clientService.deleteclient(id);
    }

}
