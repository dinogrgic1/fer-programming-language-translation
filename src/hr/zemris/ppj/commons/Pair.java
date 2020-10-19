package hr.zemris.ppj.commons;

import java.util.Objects;

public class Pair<T, K> {

    T first;

    public T getFirst() {
        return first;
    }

    public K getSecond() {
        return second;
    }

    public void setSecond(K second) {
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    K second;

    public Pair(T left, K right) {
        this.first = left;
        this.second = right;
    }

    @Override
    public String toString() {
        return "(" + first +
                "," + second +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pairState = (Pair<?, ?>) o;
        return Objects.equals(first, pairState.first) &&
                Objects.equals(second, pairState.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
