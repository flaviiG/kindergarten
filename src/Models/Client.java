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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresa() {
        return adresa;
    }

    public String toString()
    {
        return nume + " " + prenume;
    }
}
