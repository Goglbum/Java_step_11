package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.Timeout;
import ru.netology.domain.PosterMovie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager = new AfishaManager(repository);
    @InjectMocks
    private AfishaManager managerMaxList = new AfishaManager(5, repository);
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
    public void getOneMovies() {

        PosterMovie[] returned = new PosterMovie[]{movie1};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(movie1);

        manager.add(movie1);
        PosterMovie[] actual = manager.getAll();
        PosterMovie[] expected = new PosterMovie[]{movie1};
        assertArrayEquals(expected, actual);

        verify(repository).save(movie1);
    }

    @Test
    public void getThreeMovies() {
        PosterMovie[] returned = new PosterMovie[]{movie1, movie2, movie3};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(any());

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        PosterMovie[] actual = manager.getAll();
        PosterMovie[] expected = new PosterMovie[]{movie3, movie2, movie1};

        assertArrayEquals(expected, actual);

        verify(repository).save(movie1);
        verify(repository).save(movie2);
        verify(repository).save(movie3);
    }

    @Test
    public void getElevenMoviesDefault() {
        PosterMovie[] returned = new PosterMovie[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(any());

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

        verify(repository).save(movie1);
        verify(repository).save(movie2);
        verify(repository).save(movie11);
    }

    @Test
    public void getElevenMoviesChangeMaxList() {
        PosterMovie[] returned = new PosterMovie[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(any());

        managerMaxList.add(movie1);
        managerMaxList.add(movie2);
        managerMaxList.add(movie3);
        managerMaxList.add(movie4);
        managerMaxList.add(movie5);
        managerMaxList.add(movie6);
        managerMaxList.add(movie7);
        managerMaxList.add(movie8);
        managerMaxList.add(movie9);
        managerMaxList.add(movie10);
        managerMaxList.add(movie11);

        PosterMovie[] actual = managerMaxList.getAll();
        PosterMovie[] expected = new PosterMovie[]{movie11, movie10, movie9, movie8, movie7};

        assertArrayEquals(expected, actual);

        verify(repository).save(movie1);
        verify(repository).save(movie2);
        verify(repository).save(movie11);
    }

    @Test
    public void nonMovies() {
        PosterMovie[] returned = new PosterMovie[0];
        doReturn(returned).when(repository).findAll();

        PosterMovie[] actual = manager.getAll();
        PosterMovie[] expected = new PosterMovie[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {
        int idToFind = 4;
        doReturn(movie4).when(repository).findById(idToFind);

        PosterMovie actual = manager.findById(idToFind);
        PosterMovie expected = movie4;
        assertEquals(expected, actual);

        verify(repository).findById(idToFind);
    }

    @Test
    public void removeById() {
        int idToRemove = 3;
        PosterMovie[] returned = new PosterMovie[]{movie1, movie2, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        PosterMovie[] actual = manager.getAll();
        PosterMovie[] expected = new PosterMovie[]{movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie2, movie1};

        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }
    @Test
    public void removeAll() {
        PosterMovie[] returned = new PosterMovie[0];
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeAll();

        manager.removeAll();
        PosterMovie[] actual = manager.getAll();
        PosterMovie[] expected = new PosterMovie[0];
        assertArrayEquals(expected, actual);

        verify(repository).removeAll();
    }
}