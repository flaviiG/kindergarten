package Services;

import Models.Educator;
import Repositories.EducatorRepository;
import Utils.IdGenerator;

public class EducatorService {
    private IdGenerator idGenerator = IdGenerator.getInstance();
    private EducatorRepository educatorRepository = EducatorRepository.getInstance();

    public EducatorService()
    {
    }

    public Educator[] getAll()
    {
        return educatorRepository.getAll();
    }

    public boolean add(Educator c)
    {
        c.setId(idGenerator.getNextCode());
        return educatorRepository.add(c);
    }

    public boolean update(String id, Educator c) {
        return educatorRepository.update(id, c);
    }

    public boolean delete(String  id)
    {
        return educatorRepository.delete(id);
    }
}
