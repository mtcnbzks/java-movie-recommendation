import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Recommender {
   private final User targetUser;
   private static final List<User> users = getUsers(); // all users
   private int k; // similar user count
   private int x; // movie count

   public Recommender(User targetUser, int k, int x) {
      this.targetUser = targetUser;
      this.k = k;
      this.x = x;
   }

   // adds all users to max heap according to similarity
   public MaxHeap<User> getCloseUsers() {
      MaxHeap<User> closeUsers = new MaxHeap<>();

      for (User user : users) {
         double similarity = similarity(targetUser, user);
         user.setSimilarity(similarity);
         closeUsers.insert(user);
      }

      return closeUsers;
   }

   // returns K of the most similar users to target user
   public MaxHeap<User> getKCloseUsers() {
      MaxHeap<User> closeUsers = getCloseUsers();

      MaxHeap<User> kCloseUsers = new MaxHeap<>();

      for (int i = 0; i < k; i++) {
         kCloseUsers.insert(closeUsers.remove());
      }

      return kCloseUsers;
   }

   // returns X of the most rated movies by given user
   public List<Movie> getXMostRatedUserMovies(User user) {
      HashMap<Integer, Integer> userRatings = user.getRatings();

      List<Movie> movies = getMovies();
      List<Movie> ratedUserMovies = new ArrayList<>();

      for (Movie movie : movies) {
         int movieID = movie.getMovieID();

         if (userRatings.get(movieID) != 0) {
            ratedUserMovies.add(movie); // add rated movies to ratedUserMovies
         }
      }
      // sort ratedMovies according to user given ratings in descending order
      ratedUserMovies.sort((movie1, movie2) -> {
         int movie1Rating = userRatings.get(movie1.getMovieID());
         int movie2Rating = userRatings.get(movie2.getMovieID());

         return Integer.compare(movie2Rating, movie1Rating);
      });

      // return X of the most rated movies by given user
      return ratedUserMovies.subList(0, Math.min(x, ratedUserMovies.size()));
   }

   public List<Movie> getMovieRecommendations() {
      List<Movie> movieRecommendations = new ArrayList<>();

      MaxHeap<User> KCloseUsers = getKCloseUsers();

      // get X of the most rated movies by each user in KCloseUsers
      final int K_COUNT = KCloseUsers.getSize();
      for (int k = 0; k < K_COUNT; k++) {
         User user = KCloseUsers.remove();
         List<Movie> xMostRatedUserMovies = getXMostRatedUserMovies(user);
         movieRecommendations.addAll(xMostRatedUserMovies); // add all movies to movieRecommendations
      }

      return movieRecommendations;

   }

   // ************************************************************************************************* \\
   private static BufferedReader getBufferedReader(String fileName) {
      return new BufferedReader(
              new InputStreamReader(Objects.requireNonNull(Recommender.class.getResourceAsStream(fileName))));
   }

   public static List<Movie> getMovies() {
      List<Movie> movies = new ArrayList<>();
      String fileName = "movies.csv";

      try (BufferedReader bufferedReader = getBufferedReader(fileName)) {

         // pass the first line
         bufferedReader.readLine();

         String line;
         while ((line = bufferedReader.readLine()) != null) {
            movies.add(createMovie(line.trim())); // create movie and add to movies list
         }

      } catch (IOException e) {
         e.printStackTrace();
      }

      return movies;
   }

   private static Movie createMovie(String line) {
      // split line by comma, but ignore commas inside quotes
      String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
      int movieID = Integer.parseInt(parts[0]);
      String title = parts[1];
      List<String> genres = new ArrayList<>(Arrays.asList(parts[2].split("\\|")));
      return new Movie(movieID, title, genres);
   }

   private static List<User> getUsers() {
      List<User> users = new ArrayList<>();
      String fileName = "main_data.csv";

      return readUsersCSV(users, fileName);
   }

   public static List<User> getTargetUsers() {
      List<User> targetUsers = new ArrayList<>();
      String fileName = "target_user.csv";

      return readUsersCSV(targetUsers, fileName);
   }

   private static List<User> readUsersCSV(List<User> users, String fileName) {
      try (BufferedReader bufferedReader = getBufferedReader(fileName)) {

         // pass the first line
         bufferedReader.readLine();

         String line;
         while ((line = bufferedReader.readLine()) != null) {
            users.add(createUser(line.trim())); // create user and add to users list
         }

      } catch (IOException e) {
         e.printStackTrace();
      }

      return users;
   }

   private static User createUser(String line) {
      // split line by comma
      String[] split = line.split(",");

      int userID = Integer.parseInt(split[0]);

      // create ratings map
      HashMap<Integer, Integer> ratings = new HashMap<>();
      for (int i = 1; i < split.length; i++) {
         int rating = Integer.parseInt(split[i]);
         ratings.put(i, rating); // add rating to ratings map
      }
      return new User(userID, ratings);
   }

   // calculates cosine similarity between two users
   public double similarity(User user1, User user2) {
      // get ratings of users as array lists
      ArrayList<Integer> user1Ratings = new ArrayList<>(user1.getRatings().values());
      ArrayList<Integer> user2Ratings = new ArrayList<>(user2.getRatings().values());

      return cosineSimilarity(user1Ratings, user2Ratings);
   }

   // calculates cosine similarity between two vectors
   private static double cosineSimilarity(ArrayList<Integer> vector1, ArrayList<Integer> vector2) {
      if (vector1.size() != vector2.size()) {
         throw new IllegalArgumentException("Dimensions don't match");
      }

      double dotProduct = 0.0;
      double normA = 0.0;
      double normB = 0.0;

      for (int i = 0; i < vector1.size(); i++) {
         dotProduct += vector1.get(i) * vector2.get(i);
         normA += Math.pow(vector1.get(i), 2);
         normB += Math.pow(vector2.get(i), 2);
      }

      if (dotProduct == normA && normA == normB) {
         return 1.0;
      } else {
         return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
      }
   }

   public User getTargetUser() {
      return targetUser;
   }

   public static List<User> getUsersList() {
      return users;
   }

   public int getK() {
      return k;
   }

   public void setK(int k) {
      this.k = k;
   }

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }
}
