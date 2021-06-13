public class Chambre extends Local{
    private int dimension;

    //Setter
    public void setDimension(int dimension){
        this.dimension=dimension;
    }
    //Getter
    public int getDimension(){
        return dimension;
    }

    //Constructeur
    public Chambre(){

    }
    public Chambre(String localisation){
        super(localisation);
    }
    public Chambre(String localisation,int prix,int tauxLoc,int dimension){
        super(localisation,prix,tauxLoc);
        setDimension(dimension);
    }

    @Override
    public String afficher(){
        return "---------------------------------------------------------------------"
                +super.afficher()+"\n Dimension: "+ getDimension()+"\n"
                +"---------------------------------------------------------------------";
    }
}