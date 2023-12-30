import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] usage = new int[k];
        for (int i = 0; i < k; i++) {
            usage[i] = Integer.parseInt(st.nextToken());
        }

        int answer = scheduling(n, k, usage);
        System.out.println(answer);
    }

    public static int scheduling(int n, int k, int[] usage) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int[] multiTap = new int[n];
        int answer = 0;

        for (int i = 0; i < k; i++) {
            int device = usage[i];

            if (indexMap.containsKey(device)) {
                // Device is already in the multi-tap
                continue;
            }

            if (indexMap.size() < n) {
                // There is still space in the multi-tap
                multiTap[indexMap.size()] = device;
                indexMap.put(device, indexMap.size());
            } else {
                // Need to unplug a device
                int farthestIndex = -1;
                int farthestDevice = -1;

                for (int j = 0; j < n; j++) {
                    int nextUsage = getNextUsageIndex(i, usage, multiTap[j]);

                    if (nextUsage > farthestIndex) {
                        farthestIndex = nextUsage;
                        farthestDevice = j;
                    }
                }

                indexMap.remove(multiTap[farthestDevice]);
                indexMap.put(device, farthestDevice);
                multiTap[farthestDevice] = device;
                answer++;
            }
        }

        return answer;
    }

    private static int getNextUsageIndex(int currentIndex, int[] usage, int device) {
        for (int i = currentIndex; i < usage.length; i++) {
            if (usage[i] == device) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}