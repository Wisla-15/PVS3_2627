package exams;
//Doplnte atributy pro Film
//
//Jsou jimi:
//Název filmu,
//Rok vydani,
//rating (4.5, 7.8... vyssi = lepsi)
//doba trvani ve vterinach
//
//Vypis do konzole:
//Vypsano serazene dle data vydani od nejstarsich
//Vypsano serazeno dle jmena
//TOP 10 filmu dle ratingu

import fileworks.DataImport;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;

//Link na odevzdani GIST:
//https://forms.cloud.microsoft/Pages/ResponsePage.aspx?id=f_BDFfkwekCetYp67EGP_1pSNPXTVBFPg7PGychWGEdUM040WFhKVFpJQ1RBUVZYVUU2MUYxS0hETCQlQCNjPTEu
public class MovieComparing {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/movies.txt");
        ArrayList<Movie> movies = new ArrayList<>();
        while(di.hasNext()){
            String[] params = di.readLine().split(";");
            movies.add(new Movie(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[3]), Double.parseDouble(params[2])));
        }

        for (Movie m : movies){
            System.out.println(m.toString());
        }
        movies.sort(Movie.BY_NAME);
        for (Movie m : movies){
            System.out.println(m.toString());
        }
        movies.sort(Movie.BY_DATE);
        for (Movie m : movies){
            System.out.println(m.toString());
        }
        movies.sort(Movie.BY_RATING);
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1 +". "+movies.get(i).name+" "+movies.get(i).rating);
        }

        di.finishImport();
    }
}


class Movie implements Comparable{
    String name;
    int madeIn, time;
    double rating;

    public Movie(String name, int madeIn, int time, double rating) {
        this.name = name;
        this.madeIn = madeIn;
        this.time = time;
        this.rating = rating;
    }

    public static final Comparator<Movie> BY_NAME = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.name.compareTo(o2.name);
        }
    };
    public static final Comparator<Movie> BY_DATE = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {return Integer.compare(o1.madeIn, o2.madeIn);}
    };
    public static final Comparator<Movie> BY_RATING = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Double.compare(o2.rating, o1.rating);
        }
    }
;
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", madeIn=" + madeIn +
                ", time=" + time +
                ", rating=" + rating +
                '}';
    }
}