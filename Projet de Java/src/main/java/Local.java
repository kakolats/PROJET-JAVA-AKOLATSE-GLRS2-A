import java.util.ArrayList;
import java.util.List;

public class Local {
    protected static int nombreLocaux;
    private static final int FORMAT=4;
    private int nombreReservations;
    protected String ref;
    protected String localisation;
    protected int prix;
    protected int tauxLoc;

    //Attribut navigationnel
    private List<Reservation> reservationList = new ArrayList<>();
    //Constructeurs

    public Local() {

        ref=generateRef();
    }
    public Local(String localisation){
        ref=generateRef();
        setLocalisaton(localisation);

    }
    public Local(String localisation,int prix,int tauxLoc){
        ref=generateRef();
        setLocalisaton(localisation);
        setPrix(prix);
        setTauxLoc(tauxLoc);
    }



    //Getters
    public ArrayList getreservationList() {
        return (ArrayList) reservationList;
    }
    public String getRef(){
        return ref;
    }
    public String getLocalisation(){
        return localisation;
    }
    public int getPrix(){
        return prix;
    }
    public int getTauxLoc(){
        return tauxLoc;
    } 

    //Setters
    public void setLocalisaton(String localisation){
        this.localisation=localisation;
    }
    public void setPrix(int prix){
        this.prix=prix;
    }
    public void setTauxLoc(int tauxLoc){
        this.tauxLoc=tauxLoc;
    }


    //Fonctions
    private String generateRef()
    {
        String nombreC = "";
        String nombreDeLocauxString = String.valueOf(++nombreLocaux);
        for(int i=1; i<=(FORMAT - nombreDeLocauxString.length()); i++)
        {
            nombreC += "C";
        }
        return "Ref"+nombreC+nombreDeLocauxString;
    }

    public void addReservation(Reservation reservation){
        reservationList.add(reservation);
    }

    public void listerReservation()
    {
        for (Reservation element : reservationList)
        {
            if (element != null)
            {
                element.afficher();
            }

        }
    }


    public String afficher(){
        return "---------------------------------------------------------------------"
                +"\n ref: "+getRef()+"\n localisation: "+getLocalisation()+"\n"
                +"---------------------------------------------------------------------";

    }

}