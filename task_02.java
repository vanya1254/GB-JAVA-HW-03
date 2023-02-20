import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Пусть дан произвольный список целых чисел, удалить из него четные числа
 */

public class task_02 {
    public static void main(String[] args) {
        ArrayList<Integer> listNew = new ArrayList<>();
        int count = 10;
        getListRndInt(listNew, count);
        System.out.println(listNew);

        removeEvenInt(listNew);
        System.out.println(listNew);

    }

    public static void getListRndInt(ArrayList<Integer> list, int countElems) {
        Random rnd = new Random();
        
        for (int i = 0; i < countElems; i++) {
            list.add(rnd.nextInt(-100, 100));                                     // получим список рандомных чисел с нужным количеством элементов
        }
    }

    public static void removeEvenInt(ArrayList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();

            if (temp % 2 == 0) iterator.remove();                                        // удалим четные числа из списка
        }

    }
}
