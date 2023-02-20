import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Задан целочисленный список ArrayList.
 * Найти минимальное, максимальное и среднее арифметическое этого списка.
 */

public class task_03 {
    public static void main(String[] args) {
        ArrayList<Integer> listNew = new ArrayList<>();
        int count = 10;
        getListRndInt(listNew, count);
        System.out.println(listNew);

        int[] minMax = maxAndMinElemsList(listNew);
        float arithMean = arithmeticMean(listNew);
        System.out.printf("Min elem = %d, Max elem = %d, Arithmetic mean = %f\n", minMax[0], minMax[1], arithMean);

    }

    public static void getListRndInt(ArrayList<Integer> list, int countElems) {
        Random rnd = new Random();

        for (int i = 0; i < countElems; i++) {
            list.add(rnd.nextInt(-100, 100));                                            // получим список рандомных чисел с нужным количеством элементов
        }
    }

    public static int[] maxAndMinElemsList(ArrayList<Integer> list) {
        ArrayList<Integer> sortList = new ArrayList<>(list);
        sortList.sort(null);

        int[] arrMinMax = new int[] { sortList.get(0), sortList.get(1) };         // получим мин и макс элемент списка

        return arrMinMax;
    }

    public static float arithmeticMean(ArrayList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        int sum = 0;
        float arithmeticMean = 0;

        while (iterator.hasNext()) {                                                           // получим среднее арифметическое списка
            sum += iterator.next();
        }
        arithmeticMean = Float.parseFloat(Integer.toString(sum)) / list.size();

        return arithmeticMean;
    }
}