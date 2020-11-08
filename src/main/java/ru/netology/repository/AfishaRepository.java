package ru.netology.repository;

import ru.netology.domain.PosterMovie;

public class AfishaRepository {
    private PosterMovie[] movies = new PosterMovie[0];

    public void save(PosterMovie movie) {
        int length = movies.length +1;
        PosterMovie[] tmp = new PosterMovie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public PosterMovie[] findAll() { return movies; }

    public PosterMovie findById(int id) {
        for (int i = 0; i< movies.length; i++) {
            int index = movies.length - i - 1;
            if (movies[index].getId() == id) {
                return movies[index];
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) { return; }
        int length = movies.length - 1;
        PosterMovie[] tmp = new PosterMovie[length];
        int index = 0;
        for (PosterMovie item : movies) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        movies = new PosterMovie[0];
    }
}
