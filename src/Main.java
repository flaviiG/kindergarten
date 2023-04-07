import Controllers.*;
import Models.Client;
import Models.Copil;
import Models.FisaMedicala;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        ChildController childController= new ChildController();
        ClientController clientController = new ClientController();

        Scanner sc = new Scanner(System.in);
        String option;
        do{
            System.out.println("1. Add Client");
            System.out.println("2. Add Child");
            System.out.println("3. Create contract");
            System.out.println("4. See all children");
            System.out.println("5. See all clients");
            System.out.println("6. Edit medical report of a child");
            System.out.println("7. See medical reports");
            System.out.println("8. Create contract");
            System.out.println("9. Contract payment");
            option = sc.nextLine();

            switch(Integer.parseInt(option))
            {
                case 1:
                {
                    break;
                }
                case 2:
                {
                    System.out.println("Nume:");
                    String nume = sc.nextLine();
                    System.out.println("Prenume");
                    String prenume = sc.nextLine();
                    System.out.println("Data nasterii");
                    LocalDate data;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    data = LocalDate.parse(sc.nextLine(), formatter);
                    Copil c = new Copil(nume, prenume, data,new FisaMedicala());
                    childController.add(c);
                    break;
                }
                case 4:
                {
                    Copil [] children = childController.getAll();
                    int ok=1;
                    for(int i=0;i<children.length && ok==1;i++)
                    {
                        if(children[i]==null)
                        {
                            ok=0;
                        }
                        else
                        {
                            System.out.println(children[i].toString());
                        }
                    }
                    break;
                }
                case 6:
                {
                    System.out.println("Select child:");
                    Copil [] children = childController.getAll();
                    for(int i=0;i<children.length;i++) {
                        if(children[i] != null) {
                            System.out.println(i + ". " + children[i]);
                        }
                    }
                    int index = Integer.parseInt(sc.nextLine());
                    float greutate;
                    greutate = Float.parseFloat(sc.nextLine());
                    String medic = sc.nextLine();
                    LocalDate data;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    data = LocalDate.parse(sc.nextLine(), formatter);
                    children[index].setMedicalReport(greutate, medic, data);

                    break;
                }
                case 7:
                {
                    Copil [] children = childController.getAll();
                    for(int i=0;i<children.length;i++) {
                        if(children[i] != null) {
                            System.out.println(children[i].getNume() + " " + children[i].getPrenume());
                            System.out.println(children[i].medicalToString());
                            System.out.println();
                        }
                    }
                    break;
                }
                case 8:
                {
                    System.out.println("Select client:");
                    Client[] clients = clientController.getAll();
                    for(int i=0;i<clients.length;i++) {
                        if(clients[i] != null) {
                            System.out.println(i + ". " + clients[i]);
                        }
                    }
                    int client_index = Integer.parseInt(sc.nextLine());

                    System.out.println("Select child:");
                    Copil [] children = childController.getAll();
                    for(int i=0;i<children.length;i++) {
                        if (children[i] != null) {
                            System.out.println(i + ". " + children[i]);
                        }
                    }
                    int child_index = Integer.parseInt(sc.nextLine());



                    break;
                }
            }
        }
        while(!option.equals("stop"));
        option=sc.nextLine();

    }
}