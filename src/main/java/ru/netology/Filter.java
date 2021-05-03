package ru.netology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * todo Document type Filter
 */
public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < source.size(); i++) {
            int element = source.get(i);
            if (element > treshold) {
                result.add(element);
                logger.log("Элемент \"" + element + "\" проходит");
            }
            else {
                logger.log("Элемент \"" + element + "\" не проходит");
            }
        }
        logger.log("Прошло фильтр " + result.size() + " элемента(ов) из " + source.size());
        return result;
    }
}
