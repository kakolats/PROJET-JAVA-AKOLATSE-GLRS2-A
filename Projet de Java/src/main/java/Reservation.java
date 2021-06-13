public class Reservation{
    private int id;
    private String date;
    private int duree;
    private String etat;
    private static int nbreReservation;

    //Attribut navigationnel
    private String clientLogin;
    private String localId;

    //Getters
    public String getLocalId() {
        return localId;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public String getDate(){
        return date;
    }

    public int getDuree(){
        return duree;
    }

    public String getEtat(){
        return etat;
    }

    public int getId(){
        return id;
    }

    //Setters
    public void setLocalId(String localId) {

        this.localId = localId;

    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;

    }

    public void setDate(String date){

        this.date=date;
    }

    public void setDuree(int duree){
        this.duree=duree;
    }

    public void setEtat(String etat){
        this.etat=etat;
    }

    //Constructeurs
    public Reservation(){
        id=++nbreReservation;
    }
    public Reservation(int duree, String date, String etat, String clientLogin, String localId){
        id=++nbreReservation;
        setDate(date);
        setDuree(duree);
        setEtat(etat);
        setClientLogin(clientLogin);
        setLocalId(localId);
    }
    public String afficher(){
        return "id: "+this.id+" date: "+this.date+" duree: "+this.duree+" etat: "+this.etat+" client: "+this.clientLogin +" local: "+this.localId;
    }
}