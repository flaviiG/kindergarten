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

    public boolean add(Client c)
    {
        return clientService.add(c);
    }

    public boolean update(String id, Client c)
    {
        return clientService.update(id, c);
    }

    public boolean delete(String id)
    {
        return clientService.delete(id);
    }
}
