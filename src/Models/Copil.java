package Models;

import java.time.LocalDate;

public class Copil {
    String id;
    int id_contract;
    int id_educator;
    String id_grupa;
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

    public void setId_contract(int id_contract) {
        this.id_contract = id_contract;
    }

    public void setId_educator(int id_educator) {
        this.id_educator = id_educator;
    }

    public void setId_grupa(String id_grupa) {
        this.id_grupa = id_grupa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getId_contract() {
        return id_contract;
    }

    public int getId_educator() {
        return id_educator;
    }

    public String getId_grupa() {
        return id_grupa;
    }

    public String medicalToString()
    {
        return fisaMedicala.toString();
    }
}
