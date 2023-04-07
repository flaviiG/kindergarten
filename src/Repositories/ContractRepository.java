package Repositories;

import Models.Contract;

public class ContractRepository {
    Contract [] contracts;

    public  ContractRepository()
    {
        this.contracts = new Contract[100];
    }

    public void add(Contract c)
    {
        int i=0;
        while(contracts[i]!= null)
        { i++; }
        contracts[i]=c;
    }

    public Contract[] getAll()
    {
        return contracts;
    }
}
