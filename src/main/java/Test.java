import java.util.List;

public class Test {
   public static void main(String[] args) {
      List<Movie> movies = Recommender.getMovies();

      System.out.println(movies.size());
   }
}
