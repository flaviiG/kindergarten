package Models;

import java.time.LocalDate;

public class FisaMedicala {
    float greutate;
    String medic_familie;
    LocalDate ultima_consultatie;

    public FisaMedicala(float greutate, String medic_familie, LocalDate ultima_consultatie) {
        this.greutate = greutate;
        this.medic_familie = medic_familie;
        this.ultima_consultatie = ultima_consultatie;
    }

    public FisaMedicala()
    {
        this.greutate = 0;
        this.medic_familie = "Unknown";
        this.ultima_consultatie = null;
    }

    public FisaMedicala(FisaMedicala f)
    {
        this.greutate = f.greutate;
        this.ultima_consultatie = f.ultima_consultatie;
        this.medic_familie = f.medic_familie;
    }

    public float getGreutate() {
        return greutate;
    }

    public String getMedic_familie() {
        return medic_familie;
    }

    public LocalDate getUltima_consultatie() {
        return ultima_consultatie;
    }

    public void setGreutate(float greutate) {
        this.greutate = greutate;
    }

    public void setMedic_familie(String medic_familie) {
        this.medic_familie = medic_familie;
    }

    public void setUltima_consultatie(LocalDate ultima_consultatie) {
        this.ultima_consultatie = ultima_consultatie;
    }

    public String toString()
    {
        return "Medic de familie: " + medic_familie + " " + greutate + " " + ultima_consultatie;
    }
}
