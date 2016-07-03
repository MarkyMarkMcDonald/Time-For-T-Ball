package transformers;

import java.util.function.BiConsumer;
import java.util.function.Function;

class OneToOne<T, From, To> implements PropertyMapping<From, To> {
    private final Function<From, T> recordPropertyGetter;
    private final BiConsumer<To, T> builderPropertySetter;

    OneToOne(Function<From, T> recordPropertyGetter, BiConsumer<To, T> builderPropertySetter) {
        this.recordPropertyGetter = recordPropertyGetter;
        this.builderPropertySetter = builderPropertySetter;
    }

    public void map(From record, To builder) {
        T result = recordPropertyGetter.apply(record);
        builderPropertySetter.accept(builder, result);
    }

}
