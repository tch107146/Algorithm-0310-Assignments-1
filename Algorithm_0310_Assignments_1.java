import java.util.Arrays;
import java.util.Comparator;

class Activity {
    String name;
    int start, finish, value;
    public Activity(String name, int start, int finish, int value) {
        this.name = name;
        this.start = start;
        this.finish = finish;
        this.value = value;
    }
}

public class Algorithm_0310_Assignments_1 {

    // 1. Greedy 策略：依結束時間排序，依序選取不重疊活動
    static void runGreedy(Activity[] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.finish));
        int lastFinish = -1;
        int totalValue = 0;
        System.out.print("Greedy Selected: ");
        for (Activity j : jobs) {
            if (j.start >= lastFinish) {
                System.out.print(j.name + " ");
                totalValue += j.value;
                lastFinish = j.finish;
            }
        }
        System.out.println("\nGreedy Total Value: " + totalValue);
    }

    // 2. DP 策略：考慮權重，尋找真正最佳解
    static int binarySearch(Activity[] jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].finish <= jobs[index].start) {
                if (jobs[mid + 1].finish <= jobs[index].start) low = mid + 1;
                else return mid;
            } else high = mid - 1;
        }
        return -1;
    }

    static void runDP(Activity[] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.finish));
        int n = jobs.length;
        int[] opt = new int[n];
        opt[0] = jobs[0].value;

        for (int i = 1; i < n; i++) {
            int inclProf = jobs[i].value;
            int l = binarySearch(jobs, i);
            if (l != -1) inclProf += opt[l];
            opt[i] = Math.max(inclProf, opt[i - 1]);
        }
        System.out.println("DP Optimal Total Value: " + opt[n - 1]);
    }

    public static void main(String[] args) {
        Activity[] jobs = {
            new Activity("A", 1, 4, 5), new Activity("B", 3, 5, 1),
            new Activity("C", 0, 6, 8), new Activity("D", 4, 7, 4),
            new Activity("E", 3, 8, 6), new Activity("F", 5, 9, 3),
            new Activity("G", 6, 10, 2), new Activity("H", 8, 11, 4)
        };

        System.out.println("--- Assignment 1: Greedy vs DP ---");
        runGreedy(jobs);
        runDP(jobs);
        System.out.println("\nTime Complexity Analysis:");
        System.out.println("- Sorting: O(n log n)");
        System.out.println("- DP with Binary Search: O(n log n)");
    }
}