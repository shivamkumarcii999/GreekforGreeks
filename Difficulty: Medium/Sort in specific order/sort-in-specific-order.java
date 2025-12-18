import java.util.*;

class Solution {
    public void sortIt(int[] arr) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        // Separate odd and even
        for (int num : arr) {
            if (num % 2 != 0)
                odd.add(num);
            else
                even.add(num);
        }

        // Sort odd descending
        Collections.sort(odd, Collections.reverseOrder());

        // Sort even ascending
        Collections.sort(even);

        // Merge back into array
        int index = 0;
        for (int num : odd)
            arr[index++] = num;

        for (int num : even)
            arr[index++] = num;
    }
}
