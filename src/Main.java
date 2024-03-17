import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static int z = 1;
    public static void main(String[] args) {

        String fileName = "iris_training.txt";
        List<Iris> irisList = new ArrayList<>();
        try
        {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replace(',', '.');

                String[] attributes = line.split("\t");
                String[] subArray = Arrays.copyOfRange(attributes, 0, attributes.length-1);

                irisList.add(new Iris(subArray,attributes[attributes.length-1]));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        showList(irisList);

        Scanner skaner = new Scanner(System.in);
        System.out.println("Podaj parametr k: ");
        int k = skaner.nextInt();
        System.out.println(k);

        Map<Integer, Element> mapa = new HashMap<>();

        System.out.println("Podaj wartosc: ");
        System.out.println("wpisz stop aby zatrzymac");
        String decyzja = skaner.next();
        List<Double> wprowadzone = new ArrayList<>();

        while(!decyzja.equals("stop"))
        {
            wprowadzone.add(Double.parseDouble(decyzja));
            System.out.println("Podaj kolejna wartosc: ");
            decyzja = skaner.next();
        }

        System.out.println(wprowadzone);

        for(Iris i : irisList)
        {
            double suma = 0;
            for (int j = 0; j < i.atrybuty.length; j++) {
                double value = (wprowadzone.size() > j && wprowadzone.get(j) != null) ? wprowadzone.get(j) : 0;
                suma += Math.pow((value - Double.parseDouble(i.atrybuty[j])), 2);
            }
            Element e = new Element(i.decyzja, Math.sqrt(suma));
            mapa.put(z, e);
            z++;
        }

        showMap(mapa);


    }

    public static void showList(List<Iris> irisList){
        for(Iris i : irisList)
        {
            System.out.println(i);
        }
    }

    public static void showMap(Map<Integer, Element> mapa){
        for (Map.Entry<Integer, Element> entry : mapa.entrySet()) {
            System.out.println("Klucz: " + entry.getKey() + ", Wartość: " + entry.getValue());
        }
    }


}
