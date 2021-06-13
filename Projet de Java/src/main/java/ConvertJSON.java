import com.google.gson.Gson;
public class ConvertJSON {
    public static MobilePhone getMobile(MobilePhone mobile) {
        mobile.setBrand("SAMSUNG");
        mobile.setName("J2 Core");
        mobile.setRam(2);
        mobile.setRom(4);
        return mobile;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Chambre ch = new Chambre("derolo",4,45,54);
        System.out.println("The JSON representation of Object mobilePhone is ");
        System.out.println(new Gson().toJson(ch));
    }
}