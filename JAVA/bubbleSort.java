public class BubbleSort { //The name given to this algorithm is due to this concept that after performing this algorithm each time,the largest element of the array comes at the last position,similar to a bubble when it comes to the surfacetop of a water body
    public static void bubbleSort(int[] arr) {
        int N = arr.length;
        
        for (int i = 0; i < N - 1; i++) {  //This outer loop is for performing the sorting operation till the array(arr) is completely sorted.
            for (int j = 0; j < N - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) { //We are checking here for two consecutive numbers and swapping them if the condition is true
                    int temp = arr[j]; //the temp variable has been declared and initialised to do the swapping procedure.
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        
        System.out.println("Original array:");
        for (int num : arr) System.out.print(num + " ");
        
        bubbleSort(arr);
        
        System.out.println("\nSorted array:");
        for (int num : arr) System.out.print(num + " ");
    }
}
