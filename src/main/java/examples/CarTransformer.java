package examples;

import transformers.MappingContainers;
import transformers.MappingsContainer;

import java.util.function.BiConsumer;
import java.util.function.Function;

class CarTransformer {

    private final MappingsContainer<CarRecord, CarBuilder> mappingsContainer;

    public CarTransformer() {
        this.mappingsContainer = MappingContainers.listBacked();
    }

    public CarBuilder transform(CarRecord carRecord, CarBuilder carBuilder) {
        mappingsContainer.getPropertyMappings().forEach(mapping -> mapping.map(carRecord, carBuilder));
        return carBuilder;
    }

    public <T, R> CarTransformer withMapping(Function<CarRecord, T> recordPropertyGetter,
                                             BiConsumer<CarBuilder, R> builderPropertySetter,
                                             Function<T, R> transformation) {
        this.mappingsContainer.withMapping(recordPropertyGetter, builderPropertySetter, transformation);
        return this;
    }

    public <T> CarTransformer withMapping(Function<CarRecord, T> recordPropertyGetter,
                                          BiConsumer<CarBuilder, T> builderPropertySetter) {
        this.mappingsContainer.withMapping(recordPropertyGetter, builderPropertySetter);
        return this;
    }

}
