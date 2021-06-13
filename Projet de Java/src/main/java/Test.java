import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class Test {
    public JsonElement toJsonTree(java.lang.Object src) {
        return null;
    }

    public static Scanner scanner = new Scanner(System.in);
    private static JSONArray Jsontab;

    public static void main(String args[]) {

        /*Validator valid = new Validator();
        String mot="";
        String mail="akolatse@gmail.com";
        String tel="+221 77 347 31 07";
        System.out.println(valid.isVide(mot));  
        System.out.println(valid.isMail(mail));
        System.out.println(valid.isTel(tel));

        Client cl = new Client("45", "ffd", "fsfs", "dsfsdf", "vdcdcd");

        Local lc = new Local("ague");
        Chambre ch = new Chambre("dakoar");
        Local ch1 = new Local("lagoos");
        System.out.println(lc.getRef());
        System.out.println(ch.getRef());
        System.out.println(ch1.getRef());
        System.out.println(lc.afficher());

        Reservation rs = new Reservation(8, 12, "cdc",cl.getNci(),ch.getRef());
        //cl.addReservation(rs);
        //lc.addReservation(rs);


        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        String json = gson.toJson(lc);



        try (FileWriter writer = new FileWriter("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\chambre.json")) {
            gson.toJson(ch1,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Jsontabc=jsonFile("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\chambre.json");

        //Gson gson = new Gson();

*/
       /* JsonModel jm = new JsonModel();
        Local[] lo;
        lo = jm.getJson("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\chambre.json");

        Local la =(Local) new Chambre("gmpo",5,481,45);


        ListIterator<Local> it = lol.listIterator();

        while(it.hasNext()){
            Local e = it.next();
            System.out.println(e.afficher());
        }


        jm.writeJsonArray(lo,"C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\chambre.json");
        ListIterator<Local> it = lo.listIterator();

        while(it.hasNext()){
            Local e = it.next();
            System.out.println(e.afficher());
        }

*/
        /*
        Appartement apart= new Appartement("lol",45,5,2);

        apart.addChambre(c);
        apart.addChambre(c1);
        Gson gson = new Gson();

        System.out.println(gson.toJson(apart));
        System.out.println("\n");
        apart.listerChambres();*/
        JsonModel jj = new JsonModel();
        //JSONArray jis = jj.jsonFile("C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\chambre.json");
        //ArrayList<Chambre> rere = jj.getChamber(jis);
       // System.out.println(rere);
/*
        Client cv = new Client("1235","akolatse@gmail.com","1234","akol steph","773473107","medina");

        System.out.println(gson.toJson(cv));*/

        Gson gson = new Gson();

        Chambre c = new Chambre("lo",48,8,2);
        Chambre c1 = new Chambre("lola",48,8,2);
        Chambre[] chamber= new Chambre[2];
        chamber[0]=c;
        chamber[1]=c1;
        JsonArray jsonArray1 = new Gson().toJsonTree(chamber).getAsJsonArray();
        System.out.println(jsonArray1);

        JsonModel.writeJsonArray(jsonArray1,"C:\\Users\\HP\\Projet de Java\\src\\main\\resources\\chambre.json");

    }




}