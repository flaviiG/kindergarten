package Controllers;

import Models.Educator;
import Services.EducatorService;
import Services.EducatorService;

public class EducatorController {
    EducatorService educatorService;
    public EducatorController()
    {
        this.educatorService = new EducatorService();
    }

    public Educator[] getAll()
    {
        return educatorService.getAll();
    }

    public boolean add(Educator c)
    {
        return educatorService.add(c);
    }

    public boolean update(String id, Educator c)
    {
        return educatorService.update(id, c);
    }

    public boolean delete(String id)
    {
        return educatorService.delete(id);
    }
}
