package transformers;

import java.util.function.BiConsumer;
import java.util.function.Function;

class OneToOneWithTransformation<T, R, Record, Builder> implements PropertyMapping<Record, Builder> {
    private final Function<Record, T> recordPropertyGetter;
    private final BiConsumer<Builder, R> builderPropertySetter;
    private final Function<T, R> transformation;

    public OneToOneWithTransformation(
            Function<Record, T> recordPropertyGetter,
            BiConsumer<Builder, R> builderPropertySetter,
            Function<T, R> transformation) {

        this.recordPropertyGetter = recordPropertyGetter;
        this.builderPropertySetter = builderPropertySetter;
        this.transformation = transformation;
    }

    @Override
    public void map(Record record, Builder builder) {
        T value = recordPropertyGetter.apply(record);
        R transformedValue = transformation.apply(value);
        builderPropertySetter.accept(builder, transformedValue);
    }
}
