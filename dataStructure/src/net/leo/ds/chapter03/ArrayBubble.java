/**
 * 冒泡排序
 * Created by leo.cao on 2016/11/10.
 */
public class ArrayBubble {
    private long[] data;
    private int nElems;

    public ArrayBubble(int cap) {
        data = new long[cap];
        nElems = 0;
    }

    public void add(long value) {
        if (outOfRange(nElems + 1))
            return;
        data[nElems++] = value;
    }

    public void bubbleSort() {
        // 外层循环 n 次，每次减一，out之后都是排序好的
        for (int out = nElems - 1; out > 0; out--) {
            // 两两比较将大值移到后面
            for (int i = 0; i < out; i++) {
                if (data[i] > data[i + 1]) {
                    swap(i, i + 1);
                }
            }
        }
    }

    private void swap(int idxA, int idxB) {
        long tmp = data[idxA];
        data[idxA] = data[idxB];
        data[idxB] = tmp;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private boolean outOfRange(int minSize) {
        return minSize > data.length;
    }

    public static void main(String[] args) {
        ArrayBubble ab = new ArrayBubble(30);
        ab.add(22);
        ab.add(23);
        ab.add(12);
        ab.add(42);
        ab.add(504);
        ab.add(128);
        ab.add(54);
        ab.add(59);

        ab.display();
        ab.bubbleSort();
        ab.display();
    }

}
