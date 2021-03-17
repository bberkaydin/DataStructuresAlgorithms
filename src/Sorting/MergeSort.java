package Interview.Sorting;

class MergeSort
{
    /*
    The first while loop from lines 16 to 24 checks if the value of both the
    iterators is less than the respective array size,
    then it compares which of the element in right_arr or left_arr is smaller than the
    other and chooses that one to place in arr.

    The second while loop from lines 29 to 31 checks that if only elements
    in the left_arr are left then simply append them to arr

    The third while loop from lines 32 to 34 does the same but for the right_arr.
     */
    public static void merge(int[] left_arr,int[] right_arr, int[] arr,int left_size, int right_size){

        int i=0,l=0,r = 0;
        //The while loops check the conditions for merging
        while(l<left_size && r<right_size){

            if(left_arr[l]<right_arr[r]){
                arr[i++] = left_arr[l++];
            }
            else{
                arr[i++] = right_arr[r++];
            }
        }
        while(l<left_size){
            arr[i++] = left_arr[l++];
        }
        while(r<right_size){
            arr[i++] = right_arr[r++];
        }
    }

    /*
    The method first checks the base case which is, that if the length of
    the array is less than 2 then return the array as it is, as shown on line 37.

    If the base case is not satisfied then the method creates two arrays; the left and right subdivision and
    recursively calls itself on these two arrays which now contain the copied data of the original array

    The last step, on line 58 is that the method calls the merge method which
    compares and sorts the left and right arrays.
     */
    public static void mergeSort(int [] arr, int len){
        if (len < 2){return;}

        int mid = len / 2;
        int [] left_arr = new int[mid];
        int [] right_arr = new int[len-mid];

        //Dividing array into two and copying into two separate arrays
        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                left_arr[i] = arr[i];
            }
            else{
                right_arr[k] = arr[i];
                k = k+1;
            }
        }
        // Recursively calling the function to divide the subarrays further
        mergeSort(left_arr,mid);
        mergeSort(right_arr,len-mid);
        // Calling the merge method on each subdivision
        merge(left_arr,right_arr,arr,mid,len-mid);
    }

    public static void main( String args[] ) {
        int [] array = {12,1,10,50,5,15,45};
        mergeSort(array,array.length);
        for(int i =0; i< array.length;++i){
            System.out.print(array[i]+ " ");
        }
    }
}
