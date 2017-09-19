package nuc.jyg.chapter2.model;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 8:21 2017/9/10.
 * @Descrip
 */
public class Student {

    private final int id;
    private final String username;
    private final String password;
    private final String url;

    public Student(int id, String username, String password, String url) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
