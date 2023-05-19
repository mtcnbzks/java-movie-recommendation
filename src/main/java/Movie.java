import java.util.List;

public class Movie {
   private int movieID;
   private String title;
   private List<String> genres;

   public Movie(int movieID, String title, List<String> genres) {
      this.movieID = movieID;
      this.title = title;
      this.genres = genres;
   }

   @Override
   public String toString() {
      return String.format("%s", title);
   }

   // Encapsulation
   public int getMovieID() {
      return movieID;
   }

   public void setMovieID(int movieID) {
      this.movieID = movieID;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public List<String> getGenres() {
      return genres;
   }

   public void setGenres(List<String> genres) {
      this.genres = genres;
   }
}
