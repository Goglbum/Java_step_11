package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterMovie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerNonSetupTest {
  MovieManager manager = new MovieManager();
  PosterMovie movie1 = new PosterMovie(1, "https://image1", "While Were Young", "drama", true);
  PosterMovie movie2 = new PosterMovie(2, "https://image2", "The Tax Collector", "thriller", false);
  PosterMovie movie3 = new PosterMovie(3, "https://image3", "Possessor", "thriller", false);
  PosterMovie movie4 = new PosterMovie(4, "https://image4", "Spycies", "cartoon", true);
  PosterMovie movie5 = new PosterMovie(5, "https://image5", "Domangchin yeoja", "drama", false);
  PosterMovie movie6 = new PosterMovie(6, "https://image6", "Le bonheur des uns", "comedy", false);
  PosterMovie movie7 = new PosterMovie(7, "https://image7", "Letto numero", "thriller", true);
  PosterMovie movie8 = new PosterMovie(8, "https://image8", "Mogul Mowgli", "drama", false);
  PosterMovie movie9 = new PosterMovie(9, "https://image9", "Radioactive", "drama", false);
  PosterMovie movie10 = new PosterMovie(10, "https://image10", "Druk", "drama", false);
  PosterMovie movie11 = new PosterMovie(11, "https://image11", "Escuela de Miedo", "cartoon", false);

  @Test
  public void addThreeMovies() {
    manager.add(movie1);
    manager.add(movie2);
    manager.add(movie3);

    PosterMovie[] actual = manager.getAll();
    PosterMovie[] expected = new PosterMovie[]{movie3, movie2, movie1};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void addElevenMovies() {
    manager.add(movie1);
    manager.add(movie2);
    manager.add(movie3);
    manager.add(movie4);
    manager.add(movie5);
    manager.add(movie6);
    manager.add(movie7);
    manager.add(movie8);
    manager.add(movie9);
    manager.add(movie10);
    manager.add(movie11);

    PosterMovie[] actual = manager.getAll();
    PosterMovie[] expected = new PosterMovie[]{movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void nonMovies() {
    PosterMovie[] actual = manager.getAll();
    PosterMovie[] expected = new PosterMovie[0];

    assertArrayEquals(expected, actual);
  }

}