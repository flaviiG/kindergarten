package Models;

public class Educator {
    int id;
    String nume;
    String prenume;
    String telefon;
    String email;
    String adresa;
    int salariu;

    public Educator(String nume, String prenume, String telefon, String email, String adresa, int salariu)
    {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
        this.adresa = adresa;
        this.salariu = salariu;
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
    public int getSalariu() {
        return salariu;
    }
    public String toString()
    {
        return nume + " " + prenume;
    }
}
