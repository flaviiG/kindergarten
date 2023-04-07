package Repositories;

import Models.Copil;

import java.util.Arrays;

public class ChildRepository {

    Copil [] children;

    public ChildRepository()
    {
        this.children = new Copil[100];
    }

    public void add(Copil c)
    {
        int i=0;
        while(children[i]!= null)
        { i++; }
        children[i]=c;
    }

    public Copil[] getAll()
    {
        return children;
    }

}
