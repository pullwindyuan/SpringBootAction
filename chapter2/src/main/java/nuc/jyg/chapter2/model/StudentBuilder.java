package nuc.jyg.chapter2.model;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 8:34 2017/9/10.
 * @Descrip
 */
public class StudentBuilder {

    private int id;
    private String username;
    private String password;
    private String url;

    public StudentBuilder id(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder username(String username) {
        this.username = username;
        return this;
    }

    public StudentBuilder password(String password) {
        this.password = password;
        return this;
    }

    public StudentBuilder url(String url) {
        this.url = url;
        return this;
    }

    public Student build() {
        return new Student(this.id, this.username,this.password,this.url);
    }
}
