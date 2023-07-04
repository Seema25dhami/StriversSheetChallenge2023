import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* Using hashet for optimal solution */


public class Solution {

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K) {

        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();

        // Sort the array in ascending order
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                int j = i + 1;
                int k = n - 1;

                while (j < k) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum == K) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(arr[i]);
                        triplet.add(arr[j]);
                        triplet.add(arr[k]);
                        triplets.add(triplet);

                        // Move j and k pointers, skipping duplicates
                        while (j < k && arr[j] == arr[j + 1]) {
                            j++;
                        }
                        while (j < k && arr[k] == arr[k - 1]) {
                            k--;
                        }

                        j++;
                        k--;
                    } else if (sum < K) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }

        return triplets;
    }
}
