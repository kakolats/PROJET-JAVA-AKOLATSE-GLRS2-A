import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        JsonModel js = new JsonModel();
        Service service = new Service();
        int choix;
        int choixC;
        int choixD;


        Client[] clio= JsonModel.getCLients("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\comptes.json");
        Admin[] add=JsonModel.getAdmin("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\admin.json");
        //VISITEUR
        do{
            choix=Menus.menuAccueil();
            switch (choix){

                case 1:
                    System.out.println("Catalogue de locaux");
                    Chambre[] founderArray = JsonModel.getChambres("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\chambre.json");
                    for (Chambre loc:founderArray){
                        if (loc!=null){
                            System.out.println(loc.afficher());
                        }
                    }
                    Appartement[] ap = JsonModel.getAppartement("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\appartement.json");
                    for (Appartement app:ap){
                        if (app!=null){
                            System.out.println(app.afficher());
                            app.listerChambres();
                        }
                    }


                    do{
                        choixC=Menus.menuCatalogue();
                        switch (choixC){
                            //Details d'un local
                            case 1:
                                System.out.println("Entrez le numéro du local:");
                                String ref = scanner.nextLine();
                                Chambre ch=new Chambre();
                                Appartement a = new Appartement();
                                ch=null;
                                a=null;
                                for (Chambre loc:founderArray){
                                    if (loc!=null){
                                        if (ref.equals(loc.getRef())){
                                            ch=loc;
                                            System.out.println(loc.afficher());
                                            break;
                                        }
                                    }
                                }
                                for (Appartement app:ap){
                                    if (app!=null){
                                        if (ref.equals(app.getRef())){
                                            a=app;
                                            System.out.println(app.afficher());
                                            break;
                                        }
                                    }
                                }
                                do {
                                    choixD=Menus.menuDetail();
                                    switch (choixD){
                                        case 1 :
                                            int choixX;
                                            do{
                                                System.out.println("1-Se connecter \n"
                                                        +"2-Créer un compte");
                                                choixX=scanner.nextInt();
                                            }while (choixX!=1&&choixX!=2);

                                            if (choixX==1){
                                                Client c=service.register();
                                                if (a!=null){
                                                    service.doReservationAppartement(c,a);
                                                }else{
                                                    if(ch!=null){
                                                        service.doReservationChambre(c,ch);
                                                    }
                                                }
                                                clientView(c);
                                            }
                                            if(choixX==2){
                                                Client c= service.login(clio);
                                                if (a!=null){
                                                    service.doReservationAppartement(c,a);
                                                }else{
                                                    if(ch!=null){
                                                        service.doReservationChambre(c,ch);
                                                    }
                                                }
                                                clientView(c);
                                            }
                                            break;
                                    }

                                }while (choixD!=2);
                                break;
                        }

                    }while (choixC!=2);
                    break;

                case 2:
                    int connexionChoix;
                    System.out.println("CONNEXION");
                    do{
                        System.out.println("1-Admin"+"\n"+
                                "2-Client"+"\n");
                        connexionChoix=scanner.nextInt();
                    }while (connexionChoix!=1&&connexionChoix!=2);

                    if (connexionChoix==2){

                        Client vn = service.login(clio);
                        clientView(vn);
                        break;
                    }
                    if (connexionChoix==1){
                        Admin adm=service.loginAdmin(add);
                        break;
                    }

                case 3:
                    System.out.println("CREATION DE COMPTE");
                    Client client =service.register();
                    clientView(client);
                    break;

            }
        }while (choix!=4);




    }
    public static void clientView(Client cl){

        Service service1 = new Service();
        int choixC;
        int choixD;
        int choixMC;
        int choixR;
        do{
            choixMC=Menus.menuAccueilClient();
            switch (choixMC){
                case 1:
                    System.out.println("Catalogue de locaux");
                    Chambre[] founderArray = JsonModel.getChambres("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\chambre.json");
                    for (Chambre loc:founderArray){
                        if (loc!=null){
                            System.out.println(loc.afficher());
                        }
                    }
                    Appartement[] ap = JsonModel.getAppartement("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\appartement.json");
                    for (Appartement app:ap){
                        if (app!=null){
                            System.out.println(app.afficher());
                            app.listerChambres();
                        }
                    }


                    do{
                        choixC=Menus.menuCatalogue();
                        switch (choixC){
                            //Details d'un local
                            case 1:

                                System.out.println("Entrez le numéro du local:");
                                String rf = scanner.nextLine();
                                Chambre ch=new Chambre();
                                Appartement a = new Appartement();
                                ch=null;
                                a=null;
                                for (Chambre loc:founderArray){
                                    if (loc!=null){
                                        if (rf.equals(loc.getRef())){
                                            ch=loc;
                                            System.out.println(loc.afficher());
                                            break;
                                        }
                                    }
                                }
                                for (Appartement app:ap){
                                    if (app!=null){
                                        if (rf.equals(app.getRef())){
                                            a=app;
                                            System.out.println(app.afficher());
                                            break;
                                        }
                                    }
                                }
                                do {
                                    choixD=Menus.menuDetail();
                                    switch (choixD){
                                        case 1 :
                                            System.out.println("Reservation");
                                            if (a!=null){
                                                service1.doReservationAppartement(cl,a);
                                            }else{
                                                if(ch!=null){
                                                    service1.doReservationChambre(cl,ch);
                                                }
                                            }
                                            break;
                                    }

                                }while (choixD!=2);
                                break;
                        }

                    }while (choixC!=2);
                    break;

                case 2:
                    Reservation[] reservations=service1.afficherReservationByClient(cl.getEmail());

                    choixR=Menus.menuReservationsByClient();
                    do{
                        if (choixR==1){
                            System.out.println("ANNULATION DE RESERVATION \n");
                            System.out.println("Entrez le id de la reservation: ");
                            int id = scanner.nextInt();
                            service1.annulerReservation(id);
                            choixR=2;
                        }

                    }while (choixR!=2);
                    break;
            }
        }while (choixMC!=3);

    }

    public void adminView(Admin adm){
        Service service2= new Service();
        int choixAC;
        choixAC=Menus.menuAccueilAdmin();
        do{
            switch (choixAC){
                case 1:
                    service2.ajouterLocal();
                    break;
                case 2:
                    break;
            }
        }while (choixAC!=3);
    }


}
