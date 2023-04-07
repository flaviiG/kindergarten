package Controllers;

import Models.Client;
import Services.ClientService;

public class ClientController {
    ClientService clientService;
    public ClientController()
    {
        this.clientService = new ClientService();
    }

    public Client[] getAll()
    {
        return clientService.getAll();
    }

    public void add(Client c)
    {
        clientService.add(c);
    }
}
