import Controllers.*;
import Models.*;
import Repositories.ContractRepository;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        ChildController childController= new ChildController();
        ClientController clientController = new ClientController();
        ContractRepository contractRepository = new ContractRepository();

        Scanner sc = new Scanner(System.in);
        String option;
        do{
            System.out.println("1. Client CRUD");
            System.out.println("2. Child CRUD");
            System.out.println("3. Create contract");
            System.out.println("4. See all children");
            System.out.println("5. See all clients");
            System.out.println("6. Edit medical report of a child");
            System.out.println("7. See medical reports");
            System.out.println("8. Create contract");
            System.out.println("9. Contract payment");
            System.out.println("10. See all contracts");
            option = sc.nextLine();

            switch(Integer.parseInt(option))
            {
                case 1:
                {
                    System.out.println("1. Add Client");
                    System.out.println("2. Get all clients");
                    System.out.println("3. Update Client");
                    System.out.println("4. Delete Client");
                    option = sc.nextLine();
                    switch(Integer.parseInt(option))
                    {
                        case 1:
                        {
                            String nume = sc.nextLine();
                            String prenume = sc.nextLine();
                            String telefon = sc.nextLine();
                            String email = sc.nextLine();
                            String adresa = sc.nextLine();

                            Client c = new Client(nume,prenume,telefon,email,adresa);

                            clientController.add(c);

                            break;
                        }
                        case 2:
                        {
                            clientController.getAll();
                            break;
                        }
                        case 3:
                        {
                            System.out.println("Select the Client id that you want to update: ");
                            String id = sc.nextLine();
                            System.out.println("Update the new client: ");
                            System.out.println("Nume: ");
                            String nume = sc.nextLine();
                            System.out.println("Prenume: ");
                            String prenume = sc.nextLine();
                            System.out.println("Telefon: ");
                            String telefon = sc.nextLine();
                            System.out.println("Email: ");
                            String email = sc.nextLine();
                            System.out.println("Adresa: ");
                            String adresa = sc.nextLine();

                            Client c = new Client(nume,prenume, telefon, email, adresa);

                            clientController.update(id, c);

                            break;
                        }
                        case 4:
                        {
                            System.out.println("Select the Client id that you want to delete: ");
                            String id = sc.nextLine();

                            clientController.delete(id);
                            break;
                        }
                    }
                    break;

                }
                case 2:
                {
                    System.out.println("1. Add Child");
                    System.out.println("2. Get all children");
                    System.out.println("3. Update Child");
                    System.out.println("4. Delete Child");
                    option = sc.nextLine();
                    switch(Integer.parseInt(option))
                    {
                        case 1:
                        {
                            System.out.println("Nume: ");
                            String nume = sc.nextLine();
                            System.out.println("Prenume: ");
                            String prenume = sc.nextLine();
                            System.out.println("Data nasterii");
                            LocalDate data;
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            data = LocalDate.parse(sc.nextLine(), formatter);
                            System.out.println("Id-ul educatorului: ");
                            int id_educator = Integer.parseInt(sc.nextLine());
                            System.out.println("Id-ul grupei: ");
                            String id_grupa = sc.nextLine();
                            System.out.println("Id-ul contractului: ");
                            int id_contract = Integer.parseInt(sc.nextLine());

                            Copil c = new Copil(nume,prenume, data, new FisaMedicala());

                            c.setId_educator(id_educator);
                            c.setId_contract(id_contract);
                            c.setId_grupa(id_grupa);

                            childController.add(c);
                            break;
                        }

                        case 2:
                        {
                            childController.getAll();
                            break;
                        }

                        case 3:
                        {
                            System.out.println("Select the Child id that you want to update: ");
                            String id = sc.nextLine();
                            System.out.println("Update the new child: ");
                            System.out.println("Nume: ");
                            String nume = sc.nextLine();
                            System.out.println("Prenume: ");
                            String prenume = sc.nextLine();
                            System.out.println("Data nasterii");
                            LocalDate data;
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            data = LocalDate.parse(sc.nextLine(), formatter);

                            Copil c = new Copil(nume,prenume, data, new FisaMedicala());

                            childController.update(id, c);

                            break;
                        }
                        case 4:
                        {
                            System.out.println("Select the Child id that you want to delete: ");
                            String id = sc.nextLine();

                            childController.delete(id);
                            break;
                        }
                    }
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
                case 5:
                {
                    clientController.getAll();
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
                    String denumire = sc.nextLine();
                    float pret = Float.parseFloat(sc.nextLine());
                    float pret_total = Float.parseFloat(sc.nextLine());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate data_inc;
                    LocalDate data_sf;
                    data_inc = LocalDate.parse(sc.nextLine(), formatter);
                    data_sf = LocalDate.parse(sc.nextLine(), formatter);

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

                    Contract c = new Contract(denumire, pret, clients[client_index], children[child_index], pret_total, data_inc, data_sf, null);
                    contractRepository.add(c);

                    break;
                }
                case 9:
                {
                    Contract[] contracts = contractRepository.getAll();
                    System.out.println("Select contract:");
                    for(int i=0;i<contracts.length;i++) {
                        if (contracts[i] != null) {
                            System.out.println(i + ". " + contracts[i]);
                        }
                    }
                    int index = Integer.parseInt(sc.nextLine());
                    String[] methods = {"Cash", "Card"};
                    System.out.println("1 - Cash       2 - Card");
                    int methods_index = Integer.parseInt(sc.nextLine());
                    contracts[index].setPlata(new Plata(methods[methods_index - 1], "Accepted", LocalDate.now()));
                    break;
                }
                case 10:
                {
                    Contract[] contracts = contractRepository.getAll();
                    for(int i=0;i<contracts.length;i++) {
                        if (contracts[i] != null) {
                            System.out.println(contracts[i].toString());
                        }
                    }

                    break;
                }
            }
        }
        while(!option.equals("stop"));
        option=sc.nextLine();

    }
}