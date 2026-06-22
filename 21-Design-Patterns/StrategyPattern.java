import java.util.Arrays;

public class StrategyPattern {

    interface SortStrategy {
        void sort(int[] arr);
        String name();
    }

    static class BubbleSort implements SortStrategy {
        public void sort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }
            }
        }

        public String name() { return "BubbleSort"; }
    }

    static class QuickSort implements SortStrategy {
        public void sort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        private void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        private int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            int tmp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = tmp;
            return i + 1;
        }

        public String name() { return "QuickSort"; }
    }

    static class MergeSort implements SortStrategy {
        public void sort(int[] arr) {
            mergeSort(arr, 0, arr.length - 1);
        }

        private void mergeSort(int[] arr, int l, int r) {
            if (l < r) {
                int m = (l + r) / 2;
                mergeSort(arr, l, m);
                mergeSort(arr, m + 1, r);
                merge(arr, l, m, r);
            }
        }

        private void merge(int[] arr, int l, int m, int r) {
            int[] left = Arrays.copyOfRange(arr, l, m + 1);
            int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
            int i = 0, j = 0, k = l;
            while (i < left.length && j < right.length) {
                arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
            }
            while (i < left.length) arr[k++] = left[i++];
            while (j < right.length) arr[k++] = right[j++];
        }

        public String name() { return "MergeSort"; }
    }

    static class Sorter {
        private SortStrategy strategy;

        Sorter(SortStrategy strategy) {
            this.strategy = strategy;
        }

        void setStrategy(SortStrategy strategy) {
            this.strategy = strategy;
        }

        void sort(int[] arr) {
            long start = System.nanoTime();
            strategy.sort(arr);
            long elapsed = System.nanoTime() - start;
            System.out.println(strategy.name() + " -> " + Arrays.toString(arr) + " (" + elapsed + "ns)");
        }
    }

    public static void main(String[] args) {
        int[] data1 = {64, 34, 25, 12, 22, 11, 90};
        int[] data2 = {64, 34, 25, 12, 22, 11, 90};
        int[] data3 = {64, 34, 25, 12, 22, 11, 90};

        Sorter sorter = new Sorter(new BubbleSort());
        sorter.sort(data1);

        sorter.setStrategy(new QuickSort());
        sorter.sort(data2);

        sorter.setStrategy(new MergeSort());
        sorter.sort(data3);
    }
}
