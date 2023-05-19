import java.util.HashMap;

public class User implements Comparable<User> {
   private int userID;
   private HashMap<Integer, Integer> ratings; // movieID, rating
   private double similarity;

   public User(int userID, HashMap<Integer, Integer> ratings) {
      this.userID = userID;
      this.ratings = ratings;
      this.similarity = -1;
   }

   @Override
   public String toString() {
      return String.format("%d", userID);
   }

   // Encapsulation
   public int getUserID() {
      return userID;
   }

   public void setUserID(int userID) {
      this.userID = userID;
   }

   public HashMap<Integer, Integer> getRatings() {
      return ratings;
   }

   public void setRatings(HashMap<Integer, Integer> ratings) {
      this.ratings = ratings;
   }

   public double getSimilarity() {
      return similarity;
   }

   public void setSimilarity(double similarity) {
      this.similarity = similarity;
   }

   @Override
   public int compareTo(User user) {
      return Double.compare(this.similarity, user.similarity);
   }
}
