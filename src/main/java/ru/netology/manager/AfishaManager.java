package ru.netology.manager;

import ru.netology.domain.PosterMovie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private int maxList = 10;
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) { this.repository = repository; }

    public AfishaManager(int maxList, AfishaRepository repository) {
        this.maxList = maxList;
        this.repository = repository;
    }

    public void add(PosterMovie movie) { repository.save(movie); }

    public PosterMovie[] getAll() {
        PosterMovie[] movies = repository.findAll();
        int length = movies.length;
        if (movies.length > maxList){
            length = maxList;
        }
        PosterMovie[] result = new PosterMovie[length];
        for (int i = 0; i < length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public PosterMovie findById(int id) { return repository.findById(id); }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }
}
