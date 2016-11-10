/**
 * 数组
 * Created by leo.cao on 2016/11/9.
 */
public class ArrayApp {

    public static void main(String args[]) {

        long[] arr = new long[100];
        int nElems;
        long searchKey;

        arr[0] = 77;
        arr[1] = 88;
        arr[2] = 99;
        arr[3] = 66;
        arr[4] = 55;
        arr[5] = 99;

        nElems = 6;

        System.out.println("Display items");
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n....................................");
        // 查找
        searchKey = 55;
        boolean found = false;
        for (int i = 0; i < nElems; i++) {
            if (arr[i] == searchKey) {
                found = true;
                System.out.printf("found %d at [%d]", searchKey, i);
                break;
            }
        }
        if (found == false)
            System.out.println("Not found " + searchKey);

        System.out.println("\n....................................");
        // 删除
        searchKey = 66;
        int location = -1;
        for (int i = 0; i < nElems; i++) {
            if (arr[i] == searchKey) {
                location = i;
                break;
            }
        }

        if (location != -1) {
            for (int j = location; j < nElems - 1; j++) {
                arr[j] = arr[j + 1]; // 前移
            }
            nElems--;

            System.out.printf("after delete %s at[%d]  \n", searchKey, location);
            for (int i = 0; i < nElems; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        System.out.println("\n....................................");

    }
}
