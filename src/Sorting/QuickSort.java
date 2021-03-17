package Interview.Sorting;
/*
Quicksort is a sorting algorithm, which is leveraging the divide-and-conquer principle.
It has an average O(n log n) complexity and it’s one of the most used sorting algorithms, especially for big data volumes.
It's important to remember that Quicksort isn't a stable algorithm.
A stable sorting algorithm is an algorithm where the elements with the same values appear in the same order
in the sorted output as they appear in the input list.
The input list is divided into two sub-lists by an element called pivot;
one sub-list with elements less than the pivot and another one with elements greater than the pivot.
This process repeats for each sub-list.
Finally, all sorted sub-lists merge to form the final output.

2.1. Algorithm Steps
We choose an element from the list, called the pivot. We'll use it to divide the list into two sub-lists.

We reorder all the elements around the pivot – the ones with smaller value are placed before it,
and all the elements greater than the pivot after it. After this step, the pivot is in its final position.
This is the important partition step.

We apply the above steps recursively to both sub-lists on the left and right of the pivot.
 */
public class QuickSort {
    /*
    The first method is quickSort() which takes as parameters the array to be sorted,
    the first and the last index. First, we check the indices and continue only if there are still elements to be sorted.
    We get the index of the sorted pivot and use it to recursively call partition()
    method with the same parameters as the quickSort() method, but with different indices:
     */
    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    /*
    Let's continue with the partition() method. For simplicity, this function takes the last element as the pivot.
    Then, checks each element and swaps it before the pivot if its value is smaller.
    By the end of the partitioning, all elements less then the pivot are on the left of it and
    all elements greater then the pivot are on the right of it. The pivot is at its final sorted position and
    the function returns this position:
     */
    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
