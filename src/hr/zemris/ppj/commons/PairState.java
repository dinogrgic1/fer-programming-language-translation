package hr.zemris.ppj.commons;

public class PairState<T, K> {

    T left;
    K right;

    public PairState(T left, K right) {
        this.left = left;
        this.right = right;
    }

}
