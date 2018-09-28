package Entity;
public class User {

    private int uid;
    private String uname;
    private int uage;
    private int usex;
    private String udesc;
    private int cid;
    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public User(){}
    public User(String uname, int uage, int usex, String udesc) {
        this.uname = uname;
        this.uage = uage;
        this.usex = usex;
        this.udesc = udesc;
    }

    public User(int uid, String uname, int uage, int usex, String udesc) {
        this.uid = uid;
        this.uname = uname;
        this.uage = uage;
        this.usex = usex;
        this.udesc = udesc;
    }
    public User(String uname, int uage, int usex, String udesc,int cid) {
        this.uname = uname;
        this.uage = uage;
        this.usex = usex;
        this.udesc = udesc;
        this.cid=cid;
    }
    public User(int uid, String uname, int uage, int usex, String udesc,int cid) {
        this.uid = uid;
        this.uname = uname;
        this.uage = uage;
        this.usex = usex;
        this.udesc = udesc;
        this.cid=cid;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uage=" + uage +
                ", usex=" + usex +
                ", udesc='" + udesc + '\'' +
                ", cid=" + cid +
                ",classname="+this.classes.getName()+
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public int getUsex() {
        return usex;
    }

    public void setUsex(int usex) {
        this.usex = usex;
    }

    public String getUdesc() {
        return udesc;
    }

    public void setUdesc(String udesc) {
        this.udesc = udesc;
    }
}