package transformers;


import java.util.function.BiConsumer;
import java.util.function.Function;

public class Transformer<From, To> {

    private final MappingsContainer<From, To> mappingsContainer;

    public Transformer() {
        this.mappingsContainer = new MappingsContainer<>();
    }

    public To transform(From carRecord, To carBuilder) {
        mappingsContainer.forEach(mapping -> mapping.map(carRecord, carBuilder));
        return carBuilder;
    }

    public <T, R> Transformer<From, To> withMapping(Function<From, T> recordPropertyGetter,
                                      BiConsumer<To, R> builderPropertySetter,
                                      Function<T, R> transformation) {
        mappingsContainer.addMapping(recordPropertyGetter, builderPropertySetter, transformation);
        return this;
    }

    public <T> Transformer<From, To> withMapping(Function<From, T> recordPropertyGetter,
                                   BiConsumer<To, T> builderPropertySetter) {
        mappingsContainer.addMapping(recordPropertyGetter, builderPropertySetter);
        return this;
    }
}
