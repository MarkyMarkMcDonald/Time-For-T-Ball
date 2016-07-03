package transformers;


import java.util.function.BiConsumer;
import java.util.function.Function;

public interface Transformer<From, To> {

    MappingsContainer<From, To> getMappingsContainer();

    default To transform(From carRecord, To carBuilder) {
        getMappingsContainer().getPropertyMappings().forEach(mapping -> mapping.map(carRecord, carBuilder));
        return carBuilder;
    }

    default <T, R> Transformer<From, To> withMapping(Function<From, T> recordPropertyGetter,
                                      BiConsumer<To, R> builderPropertySetter,
                                      Function<T, R> transformation) {
        getMappingsContainer().withMapping(recordPropertyGetter, builderPropertySetter, transformation);
        return this;
    }

    default <T> Transformer<From, To> withMapping(Function<From, T> recordPropertyGetter,
                                   BiConsumer<To, T> builderPropertySetter) {
        getMappingsContainer().withMapping(recordPropertyGetter, builderPropertySetter);
        return this;
    }
}
