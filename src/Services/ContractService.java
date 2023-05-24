package Services;

import Models.Contract;
import Repositories.ContractRepository;
import Utils.IdGenerator;

public class ContractService {
    private IdGenerator idGenerator = IdGenerator.getInstance();
    private ContractRepository contractRepository = ContractRepository.getInstance();

    public ContractService()
    {
    }

    public Contract[] getAll()
    {
        return contractRepository.getAll();
    }

    public boolean add(Contract c)
    {
        c.setId_contract(idGenerator.getNextCode()*10);
        return contractRepository.add(c);
    }

    public boolean update(String id, Contract c) {
        return contractRepository.update(id, c);
    }

    public boolean delete(String  id)
    {
        return contractRepository.delete(id);
    }
}
