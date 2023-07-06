# Movie Recommendation App

The Movie Recommendation App is a Java Swing application designed to offer personalized movie recommendations based on
user ratings. It employs a cosine similarity algorithm to compare users and organize them into a Heap data structure
based on their similarity. By leveraging this approach, the app suggests movies that have been highly rated by users who
exhibit similar preferences.

Furthermore, the app provides a feature to create a dummy user. This dummy user can rate movies and receive personalized
recommendations based on their ratings and the ratings of other similar users in the system.

## Features

Upon launching the Movie Recommendation App, you will see a graphical user interface (GUI) with two sections:

- **Recommendation for Target User:** In this section, you can select a target user ID from the available users listed
  in the
  target_user.csv file. After selecting the user, click the "Recommend Movies" button to generate movie recommendations
  for
  the target user. The recommendations are based on the cosine similarity between the target user and other users'
  ratings.

- **Dummy User Recommendations:** In this section, you can create a dummy user by clicking the "Create Dummy User"
  button. The
  app will generate a dummy user and display five random movies for rating. After rating the movies, click the "Get
  Recommendations" button to generate personalized movie recommendations for the dummy user.

## Code Overview

The Movie Recommendation App consists of several classes:

- **Recommender:** This class is responsible for calculating recommendations and performing similarity calculations. It
  utilizes the cosine similarity algorithm to compare user ratings and generate movie recommendations.

- **User:** Represents a user in the movie recommendation system. Each user has a unique ID and a set of movie ratings.

- **Movie:** Represents a movie in the movie recommendation system. Each movie has a unique ID, title, and genre.

- **MaxHeap:** A custom implementation of a max heap data structure used for storing and retrieving users based on their
  similarity scores.

## Data Files

The Movie Recommendation App relies on the following data files:

- **movies.csv:** This file contains information about different movies, such as movie ID, title, genre, etc. The app
  uses
  this file to display movie details and recommendations.

- **main_data.csv:** This file contains user ratings for movies. Each row represents a user, and each column represents
  a
  movie ID. The values indicate the user's rating for the corresponding movie. The app uses this file to calculate
  cosine
  similarity and generate recommendations.

- **target_user.csv:** This file contains information about target users in the Movie Recommendation App. This file is
  used to provide personalized movie recommendations to specific users.