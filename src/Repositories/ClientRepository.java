package Repositories;

import Models.Client;

public class ClientRepository {

    Client[] clients;

    public ClientRepository()
    {
        this.clients = new Client[100];
    }

    public Client[] getAll()
    {
        return clients;
    }

    public void add(Client c)
    {
        int i=0;
        while(clients[i]!= null)
        { i++; }
        clients[i]=c;
    }
}
