package array_tasks;
//block 'B' № 8 liner
public class task0_3_var_3 {
    public static void main(String[] args) {
            int[] array = new int[9000];
            double rez = 0;
            int ecx = 0;
            for (int i = 1000; i < 10000; ++i) {
                array[ecx] = i;
                ecx++;
            }
            System.out.print("Source array: ");
        for (int i = 1000; i < 9000; ++i) {
            if (check(array[i]))
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    private static boolean check(int re) {
        if (((re / 100) % 10 + (re / 1000) % 10) == ((re % 10) + (re / 10) % 10))
            return true;
        return false;
    }
}
