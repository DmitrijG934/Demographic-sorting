import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

enum EyeColors {
    GREEN, BROWN, BLUE, GRAY, DEFAULT
}

class Humanity {
    
    private EyeColors color;
    private double averageLifeExpectancy;
    private boolean youngCivilization;
    private String lang;
    private String caption;
    public static long countHumanity = 73_000_000;
    private double averagePay;
    private long population;
    
    Humanity(String caption, EyeColors color, 
            double middleLifeExp, boolean youngCivil, double mPay,
            long population,
            String ... languages) {
        this.caption = caption;
        this.color = color;
        this.averagePay = mPay;
        this.population = population;
        this.averageLifeExpectancy = middleLifeExp;
        this.youngCivilization = youngCivil;
        this.lang = Arrays.toString(languages);
    }
    
    Humanity(String caption, double middleLifeExp, 
    String ... languages) {
        this(caption, EyeColors.DEFAULT, middleLifeExp, false, 0, 0,
        languages);
    }

    
    @Override
    public String toString() {
        return String.format("Nation: %s\nEye color: %s\nAverage Life: %2.2f\nYoung civilization: %s\nAverage Pay: %2.2f\nPopulation: %d\nLanguages: %s\n", caption,
        String.valueOf(color), averageLifeExpectancy, 
        String.valueOf(youngCivilization), 
        averagePay, population, lang);
    }
    
    public double getAveragePayment() { return averagePay; }
    
    public void setAveragePayment(double averagePay) 
    { 
        this.averagePay = averagePay;
    }
    
    public long getPopulation() { return population; }
    
    
}

class RussianHumanity extends Humanity {
    
    RussianHumanity() {
        super("Russian", EyeColors.BLUE, 70.91, false, 35369, 146_000_000,
        "Russian", "Ukraine",
        "English");
    }
    
}

class UkraineHumanity extends Humanity {
    
    UkraineHumanity() {
        super("Ukraine", EyeColors.GREEN, 71.19, false, 18669.5,
        45_000_000, "Russian", "Ukraine", "English");
    }
    
}

class GermanHumanity extends Humanity {
   
    GermanHumanity() {
        super("German", EyeColors.BLUE, 81.09, false, 280132.21, 82_067_000,
        "Deutsch", "English", "French", "Italian");
    }
    
}

class CompareCountries {
    
    private ArrayList<Humanity> people;
    
    CompareCountries() {
        people = new ArrayList<>();
        startComparing();
    }
    
    class paymentComprasion implements Comparator<Humanity> {
        @Override
        public int compare(Humanity one, Humanity two) {
            return (int) (one.getAveragePayment() - two.getAveragePayment());
        }
    }
    
    class populationComprasion implements Comparator<Humanity> {
        @Override
        public int compare(Humanity one, Humanity two) {
            return (int) (one.getPopulation() - two.getPopulation());
        }
    }
    
    public void startSortingByPayment() {
        Collections.sort(people, new paymentComprasion());
    }
    
    public void startSortingByPopulation() {
        Collections.sort(people, new populationComprasion());
    }
    
    private void startComparing() {
        
        //Initialize objects of different countries
        Humanity rh = new RussianHumanity();
        Humanity uh = new UkraineHumanity();
        Humanity gh = new GermanHumanity();
        
        people.add(rh);
        people.add(uh);
        people.add(gh);
        
        System.out.println("Before sorting...\n----------");
        for(Humanity h: people) System.out.println(h);
        startSortingByPayment();
         System.out.println("After sorting...\n----------");
        for(Humanity t: people) System.out.println(t);
        
        
    }
    
}

public class DemographicApplication {

    public static void main(String []args){
        new CompareCountries();
    }
}