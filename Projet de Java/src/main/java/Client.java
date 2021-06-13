import java.util.ArrayList;
import java.util.List;

public class Client{
    private String nci;
    private String password;
    private int nombreDeReservations;
    private String nomComplet;
    private String tel;
    private String adresse;
    private String email;


    //Attribut navigationnel
    private List<Reservation> listReservation = new ArrayList<>();



    //Getters
    public ArrayList getListReservation() {
        return (ArrayList) listReservation;
    }
    public String getNci(){

        return nci;
    }
    public String getNomComplet(){

        return nomComplet;
    }
    public String getTel(){

        return tel;
    }
    public String getAdresse(){

        return adresse;
    }
    public String getEmail(){

        return email;
    }
    public String getPassword() {
        return password;
    }


    //Setters
    public void setPassword(String password) {
        this.password = password;
    }
    public void setNci(String nci){
        this.nci=nci;
    }
    public void setNomComplet(String nomComplet){
        this.nomComplet=nomComplet;
    }
    public void setTel(String tel){
        this.tel=tel;
    }
    public void setAdresse(String adresse){
        this.adresse=adresse;
    }
    public void setEmail(String email){

        this.email=email;
    }

    //Constructeurs
    public Client() {

    }
    public Client(String nci,String email,String password,String nomComplet,String tel,String adresse){
        setNci(nci);
        setEmail(email);
        setPassword(password);
        setNomComplet(nomComplet);
        setTel(tel);
        setAdresse(adresse);

    }


    public String afficher(){
        return "nci: "+this.nci+" nom: "+this.nomComplet+" tel: "+this.tel+" adresse: "+this.adresse+" email: "+this.email;
    }


    public void addReservation(Reservation reservation){
        listReservation.add(reservation);
    }

    public void listerReservation()
    {
        for (Reservation element : listReservation)
        {
            if (element != null)
            {
                element.afficher();
            }

        }
    }
}