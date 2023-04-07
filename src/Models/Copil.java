package Models;

import java.time.LocalDate;

public class Copil {
    String nume;
    String prenume;
    LocalDate data_nastere;

    FisaMedicala fisaMedicala;

    public Copil(String nume, String prenume, LocalDate data_nastere, FisaMedicala fisaMedicala ) {
        this.fisaMedicala = new FisaMedicala(fisaMedicala);
        this.nume = nume;
        this.prenume = prenume;
        this.data_nastere = data_nastere;
    }
    public String toString()
    {
        return nume + " " + prenume + " " + data_nastere;
    }

    public void setMedicalReport(float greutate, String medic, LocalDate data)
    {
        this.fisaMedicala.setGreutate(greutate);
        this.fisaMedicala.setMedic_familie(medic);
        this.fisaMedicala.setUltima_consultatie(data);
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public LocalDate getData_nastere() {
        return data_nastere;
    }

    public String medicalToString()
    {
        return fisaMedicala.toString();
    }
}
