import java.util.Scanner;
public class Menus {
    public static Scanner scanner = new Scanner(System.in);

    public static int menuAccueil(){
        int choix;
        System.out.println
                ("Menu"
                        + "\n 1-Consulter catalogue Locaux disponibles"
                        + "\n 2-Se connecter"
                        + "\n 3-Créér un compte"
                        + "\n 4-Quitter");
        System.out.print("Faites votre choix : ");
        choix = Integer.parseInt(scanner.nextLine());
        return choix;
    }
    public static int menuAccueilClient(){
        int choixMC;
        System.out.println
                ("Menu"
                        + "\n 1-Consulter catalogue Locaux disponibles"
                        + "\n 2-Voir mes reservations"
                        + "\n 3-Se deconnecter ");
        System.out.print("Faites votre choix : ");
        choixMC = Integer.parseInt(scanner.nextLine());
        return choixMC;
    }

    public static int menuAccueilAdmin(){
        int choixAC;
        System.out.println
                ("Menu"
                        + "\n 1-Ajouter un  local"
                        + "\n 2-Lister les reservations d'un client"
                        + "\n 3-Se deconnecter");
        System.out.print("Faites votre choix : ");
        choixAC = Integer.parseInt(scanner.nextLine());
        return choixAC;
    }

    public static int menuCatalogue(){
        int choixC;
        System.out.println
                ("Menu"
                        + "\n 1-Afficher détails d'un produit"
                        + "\n 2-Retour");
        System.out.print("Faites votre choix : ");
        choixC = Integer.parseInt(scanner.nextLine());
        return choixC;
    }
    public static int menuDetail(){
        int choixD;
        System.out.println
                ("Menu"
                                + "\n 1-Reserver"
                                + "\n 2-Retour au catalogue");
                        System.out.print("Faites votre choix : ");
        choixD = Integer.parseInt(scanner.nextLine());
        return choixD;
    }
    public static int menuReservationsByClient(){
        int choixR;
        System.out.println
                ("Menu"
                        + "\n 1-Annuler une reservation"
                        + "\n 2-Retour au menu");
        System.out.print("Faites votre choix : ");
        choixR= Integer.parseInt(scanner.nextLine());
        return choixR;
    }
}
