package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterMovie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositorySetupTest {
    AfishaRepository repository = new AfishaRepository();
    PosterMovie movie1 = new PosterMovie(1, "https://image1", "While Were Young", "drama", true);
    PosterMovie movie2 = new PosterMovie(2, "https://image2", "The Tax Collector", "thriller", false);
    PosterMovie movie3 = new PosterMovie(3, "https://image3", "Possessor", "thriller", false);

    @BeforeEach
    public void setUp() {
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);
    }

    @Test
    public void saveAndFindAllThreeMovies() {
        PosterMovie[] actual = repository.findAll();
        PosterMovie[] expected = new PosterMovie[]{movie1, movie2, movie3};
        assertArrayEquals(expected, actual);
    }


    @Test
    void findById() {
        int getID = 3;
        PosterMovie actual = repository.findById(getID);
        PosterMovie expected = movie3;
        assertEquals(expected, actual);
    }


    @Test
    void findByNonExistentId() {
        int getID = 5;
        PosterMovie actual = repository.findById(getID);
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void removeById() {
        int getId = 3;
        repository.removeById(getId);

        PosterMovie[] actual = repository.findAll();
        PosterMovie[] expected = new PosterMovie[]{movie1, movie2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByNonExistentId() {
        int getId = 5;
        repository.removeById(getId);

        PosterMovie[] actual = repository.findAll();
        PosterMovie[] expected = new PosterMovie[]{movie1, movie2, movie3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        repository.removeAll();

        PosterMovie[] actual = repository.findAll();
        PosterMovie[] expected = new PosterMovie[0];
        assertArrayEquals(expected, actual);
    }
}