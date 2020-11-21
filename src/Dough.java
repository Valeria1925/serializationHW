import java.io.Serializable;

public class Dough implements Serializable {
String size;
String type;
private static final long serialVersionUID = 1;
    @Override
    public String toString() {
        return "Dough{" +
                "size='" + size + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
