package Services;

import Models.Client;
import Repositories.ClientRepository;
import Utils.IdGenerator;

public class ClientService {
    private IdGenerator idGenerator = IdGenerator.getInstance();
    private ClientRepository clientRepository = ClientRepository.getInstance();

    public ClientService()
    {
    }

    public Client[] getAll()
    {
        return clientRepository.getAll();
    }

    public boolean add(Client c)
    {
        c.setId(idGenerator.getNextCode());
        return clientRepository.add(c);
    }

    public boolean update(String id, Client c) {
        return clientRepository.update(id, c);
    }

    public boolean delete(String  id)
    {
        return clientRepository.delete(id);
    }

}
