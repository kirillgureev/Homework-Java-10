package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {
    // Тесты на добавление фильмов и показ всех фильмов
    @Test
    public void addFiveFilms() {
        PosterManager manager = new PosterManager();
        manager.addFilms("Film1");
        manager.addFilms("Film2");
        manager.addFilms("Film3");
        manager.addFilms("Film4");
        manager.addFilms("Film5");

        String[] expected = {"Film1", "Film2", "Film3", "Film4", "Film5"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addOneFilm() {
        PosterManager manager = new PosterManager();
        manager.addFilms("Film1");

        String[] expected = {"Film1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addZeroFilm() {
        PosterManager manager = new PosterManager();
        manager.addFilms(null);

        String[] expected = {null};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    // Тесты на вывод максимум лимит последних добавленных фильмов в обратном от добавления порядке
    // 1. Тесты на вывод добавленных фильмов с лимитом по умолчанию - 10
    @Test
    public void shouldShowZeroLastAddedFilm() {
        PosterManager manager = new PosterManager();
        manager.addFilms(null);

        String[] expected = {null};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOneLastAddedFilm() {
        PosterManager manager = new PosterManager();
        manager.addFilms("Film1");

        String[] expected = {"Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNineLastAddedFilms() {
        PosterManager manager = new PosterManager();
        manager.addFilms("Film1");
        manager.addFilms("Film2");
        manager.addFilms("Film3");
        manager.addFilms("Film4");
        manager.addFilms("Film5");
        manager.addFilms("Film6");
        manager.addFilms("Film7");
        manager.addFilms("Film8");
        manager.addFilms("Film9");

        String[] expected = {"Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowTenLastAddedFilms() {
        PosterManager manager = new PosterManager();
        manager.addFilms("Film1");
        manager.addFilms("Film2");
        manager.addFilms("Film3");
        manager.addFilms("Film4");
        manager.addFilms("Film5");
        manager.addFilms("Film6");
        manager.addFilms("Film7");
        manager.addFilms("Film8");
        manager.addFilms("Film9");
        manager.addFilms("Film10");

        String[] expected = {"Film10", "Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowElevenLastAddedFilms() {
        PosterManager manager = new PosterManager();
        manager.addFilms("Film1");
        manager.addFilms("Film2");
        manager.addFilms("Film3");
        manager.addFilms("Film4");
        manager.addFilms("Film5");
        manager.addFilms("Film6");
        manager.addFilms("Film7");
        manager.addFilms("Film8");
        manager.addFilms("Film9");
        manager.addFilms("Film10");
        manager.addFilms("Film11");

        String[] expected = {"Film11", "Film10", "Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3", "Film2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    // 2. Тесты на вывод добавленных фильмов с выставленным лимитом
    @Test
    public void shouldShowZeroLastAddedFilmWithLimit() {
        PosterManager manager = new PosterManager(5);
        manager.addFilms(null);

        String[] expected = {null};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOneLastAddedFilmWithLimit() {
        PosterManager manager = new PosterManager(5);
        manager.addFilms("Film1");

        String[] expected = {"Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFiveLastAddedFilmsWithLimit() {
        PosterManager manager = new PosterManager(5);
        manager.addFilms("Film1");
        manager.addFilms("Film2");
        manager.addFilms("Film3");
        manager.addFilms("Film4");
        manager.addFilms("Film5");
        manager.addFilms("Film6");
        manager.addFilms("Film7");

        String[] expected = {"Film7", "Film6", "Film5", "Film4", "Film3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastAddedFilmsWithLimit() {
        PosterManager manager = new PosterManager(14);
        manager.addFilms("Film1");
        manager.addFilms("Film2");
        manager.addFilms("Film3");
        manager.addFilms("Film4");
        manager.addFilms("Film5");
        manager.addFilms("Film6");
        manager.addFilms("Film7");

        String[] expected = {"Film7", "Film6", "Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
