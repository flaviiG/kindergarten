package Controllers;

import Models.Contract;
import Services.ContractService;

import java.util.HashMap;
import java.util.SortedSet;

public class ContractController {
    ContractService contractService;
    public ContractController()
    {
        this.contractService = new ContractService();
    }

    public HashMap<String, SortedSet<Contract>> getAll()
    {
        return contractService.getAll();
    }

    public boolean add(Contract c)
    {
        return contractService.add(c);
    }

    public boolean update(String id, Contract c)
    {
        return contractService.update(id, c);
    }

    public boolean delete(String id)
    {
        return contractService.delete(id);
    }
}
