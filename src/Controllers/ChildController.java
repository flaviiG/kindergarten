package Controllers;

import Models.Copil;
import Services.ChildService;

public class ChildController {

    ChildService childService;
    public ChildController()
    {
        this.childService = new ChildService();
    }
    public void add(Copil c)
    {
        childService.add(c);
    }

    public Copil[] getAll()
    {
        return childService.getAll();
    }

    public boolean update(String id, Copil c)
    {
        return childService.update(id, c);
    }

    public boolean delete(String id)
    {
        return childService.delete(id);
    }
}
