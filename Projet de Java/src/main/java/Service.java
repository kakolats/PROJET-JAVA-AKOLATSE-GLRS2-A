import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.Scanner;
public class Service {
    public JsonElement toJsonTree(java.lang.Object src) {
        return null;
    }

    public static Scanner scanner = new Scanner(System.in);

    public Client login(Client[] clio){
        String log;
        String pass;
        do{
            System.out.println("Veuillez entrez votre login");
            log = scanner.nextLine();
            if (Validator.isVide(log)){
                System.out.println("Champ obligatoire");
            }
            if (!Validator.isMail(log)){
                System.out.println("Adresse mail incorrecte");
            }
        }while (Validator.isVide(log)||!Validator.isMail(log));

        do{
            System.out.println("Veuillez entrez votre password");
            pass = scanner.nextLine();
            if (Validator.isVide(pass)){
                System.out.println("Champ obligatoire");
            }
        }while (Validator.isVide(pass));

        Client n= Validator.loginExist(log,clio);
        if (n!=null){
            if (pass.equals(n.getPassword())){
                return n;
            }else{
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("Login ou mot de passe incorrect");

            }
        }else{
            System.out.println("\033[H\033[2J");
            System.out.println("Le login entré n'existe pas");

        }
        return null;
    }

    public Admin loginAdmin(Admin[] clio){
        String log;
        String pass;
        do{
            System.out.println("Veuillez entrez votre login");
            log = scanner.nextLine();
            if (Validator.isVide(log)){
                System.out.println("Champ obligatoire");
            }
            if (!Validator.isMail(log)){
                System.out.println("Adresse mail incorrecte");
            }
        }while (Validator.isVide(log)||!Validator.isMail(log));

        do{
            System.out.println("Veuillez entrez votre password");
            pass = scanner.nextLine();
            if (Validator.isVide(pass)){
                System.out.println("Champ obligatoire");
            }
        }while (Validator.isVide(pass));

        Admin n= Validator.loginAdminExist(log,clio);
        if (n!=null){
            if (pass.equals(n.getPassword())){
                return n;
            }else{
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("Login ou mot de passe incorrect");

            }
        }else{
            System.out.println("\033[H\033[2J");
            System.out.println("Le login entré n'existe pas");

        }
        return null;
    }

    public Client register(){
        String nci;
        String mail;
        String password;
        String nom;
        String phone;
        String adresse;
        Client [] clientTable= JsonModel.getCLients("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\comptes.json");
        //NCI
        do{
            System.out.println("Entrez votre nci");
            nci = scanner.nextLine();
            if (!Validator.isNci(nci)){
                System.out.println("Nci invalide");
            }
            if(Validator.isVide(nci)){
                System.out.println("Champ obligatoire");
            }
        }while (!Validator.isNci(nci)||Validator.isVide(nci));

        //MAIL
        do{
            System.out.println("Entrez votre mail");
            mail = scanner.nextLine();
            if (!Validator.isMail(mail)){
                System.out.println("Mail invalide");
            }
            if(Validator.isVide(mail)){
                System.out.println("Champ obligatoire");
            }
            if(Validator.loginExist(mail,clientTable)!=null){
                System.out.println("Login déja existant");
            }
        }while (!Validator.isMail(mail)||Validator.isVide(mail)||Validator.loginExist(mail,clientTable)!=null);

        //PASSWORD
        do{
            System.out.println("Entrez votre mot de passe");
            password = scanner.nextLine();
            if(Validator.isVide(password)){
                System.out.println("Champ obligatoire");
            }
        }while (Validator.isVide(password));

        //FULL NAME
        do{
            System.out.println("Entrez votre nom Complet");
            nom = scanner.nextLine();
            if(Validator.isVide(nom)){
                System.out.println("Champ obligatoire");
            }
        }while (Validator.isVide(nom));

        //PHONE NUMBER
        do{
            System.out.println("Entrez votre mumero de telephone");
            phone = scanner.nextLine();
            if(Validator.isVide(phone)){
                System.out.println("Champ obligatoire");
            }
            if(!Validator.isTel(phone)){
                System.out.println("Numero incorrect");
            }
        }while (Validator.isVide(phone)||!Validator.isTel(phone));
        //ADRESS
        do{
            System.out.println("Entrez votre nom Complet");
            adresse = scanner.nextLine();
            if(Validator.isVide(adresse)){
                System.out.println("Champ obligatoire");
            }
        }while (Validator.isVide(adresse));

        Client [] tableClient = new Client[clientTable.length+1];
        Client client = new Client(nci,mail,password,nom,phone,adresse);
        int i=0;
        for(Client c: clientTable){
            if (c!=null){
                tableClient[i]=c;
                i++;
            }
        }
        tableClient[i]=client;

        JsonArray jsonArray1 = new Gson().toJsonTree(tableClient).getAsJsonArray();
        JsonModel.writeJsonArray(jsonArray1,"C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\comptes.json");
        System.out.println("Compte crée avec succès");
        return (client);

    }
    public void doReservationChambre(Client client,Chambre local){
        Reservation [] reservationTable= JsonModel.getReservations("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\reservations.json");
        Reservation [] tableReservation = new Reservation[reservationTable.length+1];
        Reservation reser= new Reservation(2,"02-02-2020","En cours", client.getNci(), local.getRef());
        int i=0;
        for(Reservation c: reservationTable){
            if (c!=null){
                tableReservation[i]=c;
                i++;
            }
        }
        tableReservation[i]=reser;
        JsonArray jsonArray1 = new Gson().toJsonTree(tableReservation).getAsJsonArray();
        JsonModel.writeJsonArray(jsonArray1,"C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\reservations.json");
        local.addReservation(reser);
        System.out.println("Reservations faites avec succès");
    }
    public void doReservationAppartement(Client client,Appartement local){
        Reservation [] reservationTable= JsonModel.getReservations("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\reservations.json");
        Reservation [] tableReservation = new Reservation[reservationTable.length+1];
        Reservation reser= new Reservation(2,"02-02-2020","En cours", client.getEmail(), local.getRef());
        int i=0;
        for(Reservation c: reservationTable){
            if (c!=null){
                tableReservation[i]=c;
                i++;
            }
        }
        tableReservation[i]=reser;
        JsonArray jsonArray1 = new Gson().toJsonTree(tableReservation).getAsJsonArray();
        JsonModel.writeJsonArray(jsonArray1,"C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\reservations.json");
        local.addReservation(reser);
        System.out.println("Reservations faites avec succès");
    }
    public Reservation[] afficherReservationByClient(String login){
        Reservation[] reservations = JsonModel.getReservations("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\reservations.json");
        Reservation[] reservations2=new Reservation[reservations.length];
        int j =0;
        for (Reservation element:reservations){
            if (element!=null){
                if (element.getClientLogin().equals(login)){
                    System.out.println(element.afficher());
                    reservations2[j]=element;
                    j++;
                }
            }
        }
        return reservations2;
    }
    public void annulerReservation(int id){
        Reservation[] reservations1=JsonModel.getReservations("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\reservations.json");
        Reservation[] reservations2=new Reservation[(reservations1.length)];
        int z=0;
        for(Reservation reservation:reservations1){
            if (reservation!=null){
                if(reservation.getId()!=id){
                    reservations2[z]=reservation;
                }
            }
            z++;
        }
        JsonArray jsonArray1 = new Gson().toJsonTree(reservations2).getAsJsonArray();
        JsonModel.writeJsonArray(jsonArray1,"C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\reservations.json");
    }

    public void ajouterLocal(){
        int c;
        String localisation;
        String prix;
        String taux;
        String dimension;
        String nombrePieces;

        do{
            System.out.println("1-Ajouter Chambre \n"
            +"2-Ajouter Appartement");
            c=scanner.nextInt();
        }while (c!=1&&c!=2);

        if (c==1){
            System.out.println("AJOUT CHAMBRE \n");
            do{
                System.out.println("Entrez la localisation");
                localisation= scanner.nextLine();
                if(Validator.isVide(localisation)){
                    System.out.println("Champ obligatoire");
                }
            }while (Validator.isVide(localisation));

            do{
                System.out.println("Entrez le prix");
                prix = scanner.nextLine();
                if(Validator.isVide(prix)){
                    System.out.println("Champ obligatoire");
                }
            }while (Validator.isVide(prix));

            do{
                System.out.println("Entrez le taux de location");
                taux = scanner.nextLine();
                if(Validator.isVide(taux)){
                    System.out.println("Champ obligatoire");
                }
            }while (Validator.isVide(taux));

            do{
                System.out.println("Entrez la dimension");
                dimension = scanner.nextLine();
                if(Validator.isVide(dimension)){
                    System.out.println("Champ obligatoire");
                }
            }while (Validator.isVide(dimension));

            Chambre ch=new Chambre(localisation,Integer.parseInt(prix),Integer.parseInt(taux),Integer.parseInt(dimension));
            Chambre[] chambreList=JsonModel.getChambres("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\reservations.json");
            Chambre[] listChambre=new Chambre[(chambreList.length)+1];
            int i=0;
            for(Chambre chambre: chambreList){
                if (chambre!=null){
                    listChambre[i]=chambre;
                    i++;
                }
            }
            listChambre[i]=ch;

            JsonArray jsonArray1 = new Gson().toJsonTree(listChambre).getAsJsonArray();
            JsonModel.writeJsonArray(jsonArray1,"C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\chambre.json");
            System.out.println("Chambre ajoutée avec succès");
        }

        if(c==2){
            System.out.println("AJOUT APPARTEMENT");
            do{
                System.out.println("Entrez la localisation");
                localisation= scanner.nextLine();
                if(Validator.isVide(localisation)){
                    System.out.println("Champ obligatoire");
                }
            }while (Validator.isVide(localisation));

            do{
                System.out.println("Entrez le prix");
                prix = scanner.nextLine();
                if(Validator.isVide(prix)){
                    System.out.println("Champ obligatoire");
                }
            }while (Validator.isVide(prix));

            do{
                System.out.println("Entrez le taux de location");
                taux = scanner.nextLine();
                if(Validator.isVide(taux)){
                    System.out.println("Champ obligatoire");
                }
            }while (Validator.isVide(taux));

            do{
                System.out.println("Entrez le nombre de pièces");
                nombrePieces = scanner.nextLine();
                if(Validator.isVide(nombrePieces)){
                    System.out.println("Champ obligatoire");
                }
                if(Integer.parseInt(nombrePieces)<3){
                    System.out.println("Minimum 3 pièces");
                }
            }while (Validator.isVide(nombrePieces)||Integer.parseInt(nombrePieces)<3);
            Appartement ap=new Appartement(localisation,Integer.parseInt(prix),Integer.parseInt(taux),Integer.parseInt(nombrePieces));
            for (int l=0;l< ap.getNbrePieces();l++){
                Chambre ch =new Chambre(ap.localisation);
                ap.addChambre(ch);
            }
            Appartement[] app=JsonModel.getAppartement("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\appartement.json");
            Appartement[] app1=new Appartement[(app.length)+1];
            int i=0;
            for(Appartement chambre: app){
                if (chambre!=null){
                    app1[i]=chambre;
                    i++;
                }
            }
            app[i]=ap;

            JsonArray jsonArray1 = new Gson().toJsonTree(app1).getAsJsonArray();
            JsonModel.writeJsonArray(jsonArray1,"C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\appartement.json");
            System.out.println("Appartement ajoutée avec succès");
        }
    }
}