package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main( String[] args ) throws IOException {
        Logger logger = Logger.getInstance();
        Filter filter;
        List<Integer> result;
        List<Integer> randomList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int n = Integer.parseInt(reader.readLine());
        System.out.print("Введите верхнюю границу для значений: ");
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            randomList.add(new Random().nextInt(m));
        }
        logger.log("Создаём и наполняем список");
        System.out.print("Вот случайный список: ");
        for (int i = 0; i < randomList.size(); i++) {
            System.out.print(" " + randomList.get(i));
        }
        System.out.println();
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int treshold = Integer.parseInt(reader.readLine());
        filter = new Filter(treshold);
        logger.log("Запускаем фильтрацию");
        result = filter.filterOut(randomList);
        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(" " + result.get(i));
        }
        System.out.println();
        logger.log("Завершаем программу");
    }
}
