public class Admin {


    private String login;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public Admin(){

    }
    public Admin(String login,String password){
        setLogin(login);
        setPassword(password);
    }
}
