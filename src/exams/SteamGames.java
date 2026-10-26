package exams;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

// Soubor má 4 sloupečky oddělené znakem "\t" - tabulátor
// name	price	num_reviews_total	short_description
// Některé řádky nemusí obsahovat krátký popisek

// Naimplementujte třídu reprezentující 1 hru/řádek
// Načtěte soubor
// Naimplementujte jednotlivé metody

public class SteamGames{

    public static void main(String[] args) {

        DataImport di = new DataImport("data/steam_games.txt");

        List<Game> games = new ArrayList<>();
        ArrayList<Game> free = new ArrayList<>();

        // TODO: načíst soubor do arraylistu 👌
        while (di.hasNext()){
            String[] params = di.readLine().split("\t");

            if (params.length == 3) games.add(new Game(params[0], Double.parseDouble(params[1]), Integer.parseInt(params[2])));
            if (params.length == 4) games.add(new Game(params[0], Double.parseDouble(params[1]), Integer.parseInt(params[2]), params[3]));

            if (Double.parseDouble(params[1]) == 0.0) {
                if (params.length == 3) free.add(new Game(params[0], Double.parseDouble(params[1]), Integer.parseInt(params[2])));
                if (params.length == 4) free.add(new Game(params[0], Double.parseDouble(params[1]), Integer.parseInt(params[2]), params[3]));

            }
        }

        System.out.println("Games total loaded: " + games.size());

        System.out.println("Number of free games: " + totalFreeGames(games));
        System.out.println("Average number of reviews per game: " + avgReviewPerGame(games));
        System.out.println("The most expensive game is: " + mostExpansive(games));

        System.out.println(games.get(0));                   // zdarma
        System.out.println(games.get(games.size() / 2));    // placené

        di.finishImport();
    }




    private static Game mostExpansive(List<Game> games) {
        // TODO: vrátit nejdražší hru 👌
        Game mostExpensive = games.getFirst();
        for (int i = games.size(); i>0; i--){
            Game g = games.get(i-1);
            if (g.getPrice()> mostExpensive.getPrice()) mostExpensive = g;
        }

        return mostExpensive;
    }

    private static long totalFreeGames(List<Game> games) {
        // TODO: vrátit počet her, které jsou zdarma 👌
        long n = 0;

        for (int i = games.size(); i>0; i--){
            Game g = games.get(i-1);
            if (g.getPrice() == 0.0) n++;
        }

        return n;
    }
    private static double avgReviewPerGame(List<Game> games) {
        // TODO: vrátit průměrný počet hodnocení 👌
        long n = games.size();
        long hodnoceni =0;
        for (int i = games.size(); i>0; i--){
            Game g = games.get(i-1);
            hodnoceni += g.getRecenze();
        }

        return (double) hodnoceni / n;
    }
}

class Game {
    // TODO: getter pro krátký popisek bude vracet "Not released yet" pokud není popisek uveden hra je "zdarma"
    protected String name;
    protected double price;
    protected int recenze;
    protected String popis = " ";

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", recenze=" + recenze +
                ", popis='" + getPopis() + '\'' +
                '}';
    }

    public Game(String name, double price, int recenze) {
        this.name = name;
        this.price = price;
        this.recenze = recenze;
        if (price == 0) this.popis = "Not released yet";

    }

    public Game(String name, double price, int recenze, String popis) {
        this.name = name;
        this.price = price;
        this.recenze = recenze;
        this.popis = popis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRecenze() {
        return recenze;
    }

    public void setRecenze(int recenze) {
        this.recenze = recenze;
    }

    public String getPopis() {
        if (popis.equals(" ")) return "Not released yet";
            else return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }


}