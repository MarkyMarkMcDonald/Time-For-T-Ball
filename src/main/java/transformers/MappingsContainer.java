package transformers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/*
 Holds property -> property mappings From one object To another.
 A mapping represents each property on the From object with a value, T,
 being used for the setter/builder call on the To object, R.
 If R and T are not the same type, a transformer function is required that converts from T to R.
 */
class MappingsContainer<From, To> implements Iterable<PropertyMapping> {

    private final List<PropertyMapping> propertyMappings;

    MappingsContainer() {
        this.propertyMappings = new ArrayList<>();
    }

    @Override
    public Iterator<PropertyMapping> iterator() {
        return propertyMappings.iterator();
    }

    <T, R> void addMapping(Function<From, T> recordPropertyGetter,
                                                  BiConsumer<To, R> builderPropertySetter,
                                                  Function<T, R> transformation) {
        OneToOneWithTransformation<R, T, From, To> propertyMapping = new OneToOneWithTransformation(recordPropertyGetter, builderPropertySetter, transformation);
        propertyMappings.add(propertyMapping);
    }

    <T> void addMapping(Function<From, T> recordPropertyGetter,
                                               BiConsumer<To, T> builderPropertySetter) {
        OneToOne<T, From, To> oneToOneMapping = new OneToOne<>(recordPropertyGetter, builderPropertySetter);
        propertyMappings.add(oneToOneMapping);
    }
}
