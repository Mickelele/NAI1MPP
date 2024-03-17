public class Element {
    String nazwa;
    Double odleglosc;


    public Element(String nazwa, Double odleglosc) {
        this.nazwa = nazwa;
        this.odleglosc = odleglosc;
    }

    @Override
    public String toString() {
        return nazwa +
                " " + odleglosc;
    }
}

