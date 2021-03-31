import javax.swing.plaf.SliderUI;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/8 20:28
 */
public class BinaryHeap<Key extends Comparable<Key>> {

    private Key[] pq;

    private int N = 0;

    public BinaryHeap(int cap) {
        pq = (Key[]) new Comparable[cap + 1];
    }

    /**
     * 获取当前索引的父节点的索引
     *
     * @param root
     * @return
     */
    public int parent(int root) {
        return root / 2;
    }

    /**
     * 获取当前索引的左孩子索引
     *
     * @param root
     * @return
     */
    public int left(int root) {
        return root * 2;
    }

    public int right(int root) {
        return root * 2 + 1;
    }

    public Key max() {
        return pq[1];
    }

    public void insert(Key e) {
        N++;
        pq[N] = e;
        swim(N);
    }

    public Key delMax() {

        Key max = pq[1];
        exch(1,N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    /**
     * 最大堆  大元素上浮
     *
     * @param k
     */
    public void swim(int k) {
        while (k > 1 && less(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 最大堆 小元素下沉,把较大的那个子节点和A交换
     *
     * @param k
     */
    public void sink(int k) {
        while (left(k) <= N) {
            int older = left(k);
            if (right(k) <= N && less(older, right(k))) {
                older = right(k);
            }

            if (less(older, k)) break;
            exch(k, older);
            k = older;
        }
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * 判断 pq[i] 是否比 pq[j] 小
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
}
