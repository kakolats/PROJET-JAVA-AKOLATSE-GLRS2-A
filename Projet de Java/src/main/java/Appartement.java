import java.util.ArrayList;
import java.util.List;

public class Appartement extends Local{
    private int nbrePieces;
    private int nbreLocal;




    //Attribut navigationnel
    private List<Chambre> chambreList = new ArrayList<>();

    //Setters
    public void setNbrePieces(int nbrePieces){
        this.nbrePieces=nbrePieces;
    }

    //Getters
    public ArrayList getTableLocal() {
        return (ArrayList) chambreList;
    }
    public int getNbrePieces(){
        return nbrePieces;
    }

    //Constructeurs
    public Appartement(){

    }
    public Appartement(String localisation){
        super(localisation);
    }
    public Appartement(String localisation,int prix,int tauxLoc,int nbrePieces){
        super(localisation,prix,tauxLoc);
        setNbrePieces(nbrePieces);
    }
    public void addChambre(Chambre local){
        chambreList.add(local);
    }

    public void listerChambres()
    {
        for (Chambre element : chambreList)
        {
            if (element != null)
            {
                System.out.println(element.afficher());
            }

        }
    }

    @Override
    public String afficher(){
        return "---------------------------------------------------------------------"
                +super.afficher()+"\n nbrePièces: "+ getNbrePieces()+"\n"
                +"---------------------------------------------------------------------";
    }
}