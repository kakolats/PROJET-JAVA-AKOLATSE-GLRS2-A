import java.util.regex.*;    
import java.util.*;

public class Validator{

    /* isNci
    isTel
    isAdresse
    isMail*/


    public static boolean isVide(String value){
        return value.isEmpty();
    } 

    public static boolean isMail(String mail){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";  
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);  
        return matcher.matches();
    }

    public static boolean isNci(String nci){
        String forme= "^[1-2]+[\\s]+[1-9]{3,}+[\\s]+[1-9]{4,}+[\\s]+[1-9]{5,}$";
        Pattern pattern = Pattern.compile(forme);
        Matcher matcher = pattern.matcher(nci);  
        return matcher.matches();
    }

    public static boolean isTel(String tel){
        String phoneFormat= "^(?:(?:\\+|00)221|0)+[\\s]+[7{2,}]+[\\s]+[\\d]{3,}+[\\s]+[\\d]{2,}+[\\s]+[\\d]{2,}$";
        Pattern pattern = Pattern.compile(phoneFormat);
        Matcher matcher = pattern.matcher(tel);  
        return matcher.matches();
    }

    public static Client loginExist(String login,Client[] cl){
        for(Client c:cl){
            if(c!=null){
                if (login.equals(c.getEmail())){
                    return c;
                }
            }
        }
        return null;
    }
    public static Admin loginAdminExist(String login,Admin[] ad){
        for(Admin a:ad){
            if(a!=null){
                if (login.equals(a.getLogin())){
                    return a;
                }
            }
        }
        return null;
    }



}