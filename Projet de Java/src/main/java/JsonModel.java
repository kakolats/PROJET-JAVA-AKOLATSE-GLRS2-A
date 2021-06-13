import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonModel{

    public static void writeJsonArray(JsonArray jsonArray, String path) {
        try (FileWriter file = new FileWriter(path)) {
            Gson gs = new Gson();
            file.write(gs.toJson(jsonArray));
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Chambre[] getChambres(String path) {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonFile = new JSONArray();
        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);
            jsonFile = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Chambre[] founderArray = gson.fromJson(String.valueOf(jsonFile), Chambre[].class);
        return founderArray;

    }

    public static Appartement[] getAppartement(String path) {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonFile = new JSONArray();
        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);
            jsonFile = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Appartement[] founder = gson.fromJson(String.valueOf(jsonFile), Appartement[].class);
        return founder;

    }
    public static Admin[] getAdmin(String path) {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonFile = new JSONArray();
        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);
            jsonFile = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Admin[] founder = gson.fromJson(String.valueOf(jsonFile), Admin[].class);
        return founder;

    }
    public static Client[] getCLients(String path) {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonFile = new JSONArray();
        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);
            jsonFile = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Client[] founder = gson.fromJson(String.valueOf(jsonFile), Client[].class);
        return founder;

    }
    public static Reservation[] getReservations(String path) {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonFile = new JSONArray();
        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);
            jsonFile = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Reservation[] founder = gson.fromJson(String.valueOf(jsonFile), Reservation[].class);
        return founder;

    }


    public static ArrayList<Chambre> getChamber(JSONArray jsonArray){
        ArrayList<Chambre> listdata = new ArrayList<Chambre>();
        if (jsonArray != null) {
            //Iterating JSON array  
            for (int i=0;i<jsonArray.size();i++){
                //Adding each element of JSON array into ArrayList  
                listdata.add((Chambre) jsonArray.get(i));
            }
        }
        return listdata;
    }


}
