package magic_cube;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Vvedite: N = ");
        int n = in.nextInt();
        int[][] array = new int[2 * n - 1][2 * n - 1];
        if (n % 2 != 0) {
            oddN(array, n);
        } else if (n % 4 == 0) {
            multipleFour(array, n);
        } else {
            evenN(array, n);
        }
        System.out.print("Summary of elements magical cube: " + (Math.pow(n,3) + n) / 2);
        //TODO
    }

    static int[][] oddN(int[][] src, int size) {
        int ss, nn, i, j, x, y;
        if (size % 2 != 0) {
            ss = ((size - 1) / 2);
            nn = 1;
            for (i = 0; i < size; i++)
                for (j = 0; j < size; j++) {
                    x = (-ss + i + j + size) % size;
                    y = (ss + i - j + size) % size;
                    src[x][y] = nn++;
                   // nn++;
                }
            for (i = 0; i < size; i++) {
                for (j = 0; j < size; j++)
                    System.out.print(src[i][j] + " ");
                System.out.println();
            }
        }
        return src;
    }
    static int[][] multipleFour(int[][] src, int size){
        int[][] lhs = new int[size][size];
        int[][] rhs = new int[size][size];
        int ecx = 0, tmp = size, cnt = 0, z = 1, x = 0, c = size / 4; //counter
        System.out.println("First square: ");
        while (c != 0) { //first matrix, first middle
            for (int i = 1; i <= size; i++) {
                lhs[ecx][cnt] = i;
                cnt++;
                lhs[z][x] = tmp;
                x++;
                tmp--;
            }
            tmp = size;
            ecx+=2;
            System.out.println("ecx = " + ecx + "cnt = " + cnt + "z = " + z + "x = " + x);
            z+=2;
            cnt = 0;
            x = 0;
            c--;
        }
        c = size / 4;
        while (c != 0) { //first matrix, second middle
            for (int i = 1; i <= size; i++) {
                lhs[ecx][cnt] = tmp;
                cnt++;
                lhs[z][x] = i;
                x++;
                tmp--;
            }
            tmp = size;
            ecx+=2;
            System.out.println("ecx = " + ecx + "cnt = " + cnt + "z = " + z + "x = " + x);
            z+=2;
            cnt = 0;
            x = 0;
            c--;
        }
        //secret formula = pow(n,2) - size => max element int second matrix
        int secretKey = (int)Math.pow(size, 2) - size; //our key to get maximal element in magic cube
        int tmp_rhs = (int)Math.pow(size, 2) - size; //temp key for addition
        //upd
        ecx = 0;
        cnt = 1;
        z = 1;
        int it = 0; //iteration
        c = size / 4;
        ///
        while (c != 0) { //second matrix first middle
            for (int i = 0; i < size - 1; i++) {
                rhs[cnt][ecx] += size + it;
                it += size;
                rhs[cnt - 1][z] = secretKey;
                secretKey -= size;
                cnt++;
            }
            z+=2;
            it = 0;
            secretKey = tmp_rhs;
            cnt = 1;
            ecx +=2;
            c--;
        }
        ///
        c = size / 4;
        while (c != 0) { //second matrix second middle
            for (int i = 0; i < size - 1; i++) {
                rhs[cnt-1][ecx] =  secretKey;
                rhs[cnt][z] += size + it;
                it += size;
                secretKey -= size;
                cnt++;
            }
            z+=2;
            it = 0;
            secretKey = tmp_rhs;
            cnt = 1;
            ecx +=2;
            c--;
        }
        ///
        System.out.println("First matrix: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.printf("%4d",lhs[i][j]);
            System.out.println();
        }
        System.out.println("Second matrix: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.printf("%4d", rhs[i][j]);
            System.out.println();
        }
        //add
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++)
                lhs[i][j] += rhs[i][j];
        }
        System.out.println("Magic matrix: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.printf("%4d",lhs[i][j]);
            System.out.println();
        }
        return src;
    }
    static int[][] evenN(int[][] src, int size){
        int[][] square = new int[size][size];
        int[][] tmp = oddN(src, size / 2);
        List<Integer> list = Arrays.asList(0,0, size /2, size / 2, 0, size / 2, size / 2, 0);
        ListIterator<Integer> it = list.listIterator();
        int i0, j0, n = 0;
        while (it.hasNext()) {
            i0 = it.next();
            j0 = it.next();
            for (int z = 0; z < size / 2; ++z)
                for (int x = 0; x < size / 2; ++x)
                    //System.out.print("i0 = " + i0 + "j0 = " + j0 + "\r\n");
                    square[z + i0][x + j0] = tmp[z][x] + n * (int) Math.pow((size / 2), 2);
            n++;
        }

        int tmp1 = square[0][0], tmp2 = square[size / 2 - 1][0]; //temp variable for save state
        square[0][0] = square[size / 2][0]; //error tut, check python equals inline
        square[size / 2][0] = tmp1;
        square[size / 2 - 1][0] = square[size - 1][0];
        square[size - 1][0] = tmp2;


        for (int z = 1; z < size / 2 - 1; ++z) { // python implementation : for i in range(1, size / 2 - 1): check parameters of func rand '1'
            tmp1 = square[z][1];
            square[z][1] = square[z + size / 2][1];
            square[z+size/2][1] = tmp1;
        }
        if (size > 6)
            for (int z = size / 2 - (size / 2 - 3) / 2; z < size / 2 + (size / 2 - 3) / 2; z++)
                for (int x = 0; x < size / 2; x++) {
                    tmp1 = square[x][z];
                    square[x][z] = square[size / 2 + x][z];
                    square[size / 2 + x][z] = tmp1;
                }

        for (int z = 0; z < size; z++) {
            for (int x = 0; x < size; x++)
                System.out.printf("%4d", square[z][x]);
            System.out.print("\r\n");
        }
        return src;
    }
}
