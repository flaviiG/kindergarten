package Services;

import Repositories.ChildRepository;
import Models.Copil;

public class ChildService {
    ChildRepository childRepository;
    public ChildService(){
        this.childRepository = new ChildRepository();
    }

    public void add(Copil c)
    {
        childRepository.add(c);
    }

    public Copil[] getAll()
    {
        return  childRepository.getAll();
    }
}
