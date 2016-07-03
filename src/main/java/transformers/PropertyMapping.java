package transformers;

interface PropertyMapping<From, To> {
    void map(From from, To to);
}
