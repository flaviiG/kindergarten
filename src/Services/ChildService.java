package Services;

import Repositories.ChildRepository;
import Models.Copil;
import Repositories.ClientRepository;
import Utils.IdGenerator;

public class ChildService {
    private IdGenerator idGenerator = IdGenerator.getInstance();
    private ChildRepository childRepository = ChildRepository.getInstance();

    public void add(Copil c)
    {
        c.setId("C" + idGenerator.getNextCode().toString());
        childRepository.add(c);
    }

    public Copil[] getAll()
    {
        return  childRepository.getAll();
    }

    public boolean update(String id, Copil c)
    {
        return childRepository.update(id, c);
    }

    public boolean delete(String id)
    {
        return childRepository.delete(id);
    }

}
