package Models;

public class Client {
    int id;
    String nume;
    String prenume;
    String telefon;
    String email;
    String adresa;

    public Client(String nume, String prenume, String telefon, String email, String adresa)
    {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
        this.adresa = adresa;
    }

    public String toString()
    {
        return nume + " " + prenume;
    }
}
