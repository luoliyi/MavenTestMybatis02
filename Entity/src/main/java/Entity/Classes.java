package Entity;

public class Classes {
    private int cid;
    private String cname;

    public Classes(){}
    public Classes(String name) {
        this.cname = name;
    }

    public Classes(int cid, String name) {
        this.cid = cid;
        this.cname = name;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return cname;
    }

    public void setName(String name) {
        this.cname = name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "cid=" + cid +
                ", name='" + cname + '\'' +
                '}';
    }
}
