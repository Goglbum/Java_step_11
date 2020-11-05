package ru.netology.manager;

import ru.netology.domain.PosterMovie;

public class MovieManager {
  private int maxList = 10;
  private PosterMovie[] movies = new PosterMovie[0];

  public MovieManager(int maxList) {
    this.maxList = maxList;
  }

  public MovieManager() {
  }

  public void add(PosterMovie movie) {
    // создаём новый массив размером на единицу больше
    int length = movies.length + 1;
    PosterMovie[] tmp = new PosterMovie[length];
    System.arraycopy(movies, 0, tmp, 0, movies.length);
    // кладём последним наш элемент
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = movie;
    movies = tmp;
  }

  public PosterMovie[] getAll() {
    int list = movies.length;
    if (movies.length > maxList){
      list = maxList;
    }
    PosterMovie[] result = new PosterMovie[list];
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    for (int i = 0; i < result.length; i++) {
      int index = movies.length - i - 1;
      result[i] = movies[index];
    }
    return result;
  }
}
