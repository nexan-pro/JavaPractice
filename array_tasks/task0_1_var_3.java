package array_tasks;
//block A № 3 liner
public class task0_1_var_3 {
    public static void main(String[] args) {
        int[] arr = new int[7];
        for (int i = 0; i < 5; ++i)
            arr[i] = (int)(-4 + (Math.random() * 10));
        System.out.print("Source array: ");
        for (int i = 0; i < 5; ++i)
            System.out.print(arr[i] + " ");
        if (arr[0] > 0)
            System.out.print("\r\nfirst greater");
        else
            System.out.print("\r\nfirst less");
    }
}
