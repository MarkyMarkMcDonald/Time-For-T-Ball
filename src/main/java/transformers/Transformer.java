package transformers;


import java.util.function.BiConsumer;
import java.util.function.Function;

public class Transformer<From, To> {

    private final MappingsContainer<From, To> mappingsContainer;

    public Transformer() {
        this.mappingsContainer = MappingContainers.listBacked();
    }

    public To transform(From carRecord, To carBuilder) {
        mappingsContainer.getPropertyMappings().forEach(mapping -> mapping.map(carRecord, carBuilder));
        return carBuilder;
    }

    public <T, R> Transformer<From, To> withMapping(Function<From, T> recordPropertyGetter,
                                      BiConsumer<To, R> builderPropertySetter,
                                      Function<T, R> transformation) {
        mappingsContainer.withMapping(recordPropertyGetter, builderPropertySetter, transformation);
        return this;
    }

    public <T> Transformer<From, To> withMapping(Function<From, T> recordPropertyGetter,
                                   BiConsumer<To, T> builderPropertySetter) {
        mappingsContainer.withMapping(recordPropertyGetter, builderPropertySetter);
        return this;
    }
}
