package ru.netology.domain;

public class PosterManager {
    // Массив
    private String[] films = new String[0];
    // Поля
    private int limitAddedFilms;

    // Конструкторы
    public PosterManager() {
        limitAddedFilms = 10;
    }

    public PosterManager(int limitAddedFilms) {
        this.limitAddedFilms = limitAddedFilms;
    }

    // Методы
    // 1. Добавление нового фильма
    public void addFilms(String film) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    // 2. Вывод всех фильмов в порядке добавления
    public String[] findAll() {
        return films;
    }

    // 3. Вывод максимум лимит последних добавленных фильмов в обратном от добавления порядке
    public String[] findLast() {
        int resultLength;
        if (limitAddedFilms <= films.length) {
            resultLength = limitAddedFilms;
        } else {
            resultLength = films.length;
        }
        String[] tmp = new String[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = films[films.length - 1 - i];
        }
        return tmp;
    }
}
