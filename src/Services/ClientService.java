package Services;

import Models.Client;
import Repositories.ClientRepository;

public class ClientService {
    ClientRepository clientRepository;

    public ClientService()
    {
        clientRepository = new ClientRepository();
    }

    public Client[] getAll()
    {
        return clientRepository.getAll();
    }

    public void add(Client c)
    {
        clientRepository.add(c);
    }
}
