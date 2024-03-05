package io.codeforall.bootcamp.filhosdamain;

class Machine<T> {
    public T monoOperation(T i, MonoOperation<T> k) {
        return k.monoOperation(i);
    }

    public T biOperation(T i, T j, BiOperation<T> k) {
        return k.biOperation(i, j);
    }
}


