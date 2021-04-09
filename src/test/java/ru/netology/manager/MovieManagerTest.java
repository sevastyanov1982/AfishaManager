package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    Movie first = new Movie(1, "Bladshot", "http1", "action");
    Movie second = new Movie(2, "Vpered", "http2", "cartoon");
    Movie third = new Movie(3, "Hotel_Belgrade", "http3", "comedy");
    Movie fourth = new Movie(4, "Gentlemens", "http4", "action");
    Movie fifth = new Movie(5, "Invisible_man", "http5", "horror");
    Movie sixth = new Movie(6, "Trolls'", "http6", "cartoon");
    Movie seventh = new Movie(7, "Number One", "http7", "comedy");
    Movie eight = new Movie(8, "Bogatyr", "http8", "comedy");
    Movie ninth = new Movie(9, "The_Lion_King", "http9", "cartoon");
    Movie tenth = new Movie(10, "1+1", "http10", "comedy");
    Movie eleventh = new Movie(11, "Fire", "http10", "action");

    @Test
    void shouldAddedMovie() { ///добавить фильм
        MovieManager manager = new MovieManager(3);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowEmpty() {
        MovieManager manager = new MovieManager(10);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetCurrentFilms() {
        MovieManager manager = new MovieManager(5);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        Movie[] actual = manager.getLastMovie();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eight, seventh};

        assertArrayEquals(expected, actual);
    }
}