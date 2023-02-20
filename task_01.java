import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Реализовать алгоритм сортировки слиянием
 */

public class task_01 {
    public static void main(String[] args) {
        int colCount = 2;
        int rowsCount = 10;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        getMatrixRndInt(matrix, colCount, rowsCount);
        printMatrix(matrix);

        int[] arr = new int[matrix.get(0).size() + matrix.get(1).size()];
        copyListsMatrixToArray(arr, matrix);
        System.out.println(Arrays.toString(arr));                                                                               // заполнили массив типа int[] элементами многомерного списка типа ArrayList<ArrayList<Integer>>
        mergeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    public static void getMatrixRndInt(ArrayList<ArrayList<Integer>> list, int countColumns, int countRows) {
        Random rnd = new Random();
        
        for (int i = 0; i < countColumns; i++) {
            list.add(new ArrayList<Integer>(countRows));                                                                        // получим многомерный список рандомных чисел с нужным количеством строк и столбцов
            for (int j = 0; j < countRows; j++) {
                list.get(i).add(rnd.nextInt(-100, 100));
            }
        }
    }

    public static void printMatrix(ArrayList<ArrayList<Integer>> listLiStrings) {
        for (int i = 0; i < listLiStrings.size(); i++) {
            for (int j = 0; j < listLiStrings.get(i).size(); j++) {
                System.out.printf("\t%d\t", listLiStrings.get(i).get(j));                                               // печатаем список в виде таблицы
            }
            System.out.println("\n");
        }
    }

    public static void copyListsMatrixToArray(int[] array, ArrayList<ArrayList<Integer>> matrix) {
        int ind = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                array[ind] = matrix.get(i).get(j);
                ind++;
            }
        }
    }

    public static void mergeSort(int[] array, int len) {
        if (len < 2) return;

        int mid = len / 2;
        int[] l = new int[mid];
        int[] r = new int[len - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int i = mid; i < len; i++) {
            r[i - mid] = array[i];
        }

        mergeSort(l, mid);
        mergeSort(r, len - mid);

        merge(array, l, r, mid, len - mid);
    }

    public static void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) array[k++] = l[i++];
            else array[k++] = r[j++];
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }
}