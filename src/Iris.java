import java.util.Arrays;
import java.util.List;

public class Iris {

    public String[] atrybuty;
    public String decyzja;

    public Iris(String[] atrybuty, String decyzja) {
        this.atrybuty = atrybuty;
        this.decyzja = decyzja;
    }


    @Override
    public String toString() {
        return Arrays.toString(atrybuty) +
                " " + decyzja;
    }
}
