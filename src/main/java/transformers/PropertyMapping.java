package transformers;

interface PropertyMapping<T, R> {
    void map(T from, R to);
}
