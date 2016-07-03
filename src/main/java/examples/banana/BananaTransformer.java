package examples.banana;

import transformers.MappingContainers;
import transformers.MappingsContainer;

import java.util.function.BiConsumer;
import java.util.function.Function;

class BananaTransformer {
    private MappingsContainer<BananaRecord, BananaBuilder> mappingsContainer;

    public BananaTransformer() {
        mappingsContainer = MappingContainers.listBacked();
    }

    public BananaBuilder transform(BananaRecord bananaRecord, BananaBuilder bananaBuilder) {
        mappingsContainer.getPropertyMappings().forEach(mapping -> mapping.map(bananaRecord, bananaBuilder));
        return bananaBuilder;
    }

    public <T, R> BananaTransformer withMapping(Function<BananaRecord, T> recordPropertyGetter,
                                             BiConsumer<BananaBuilder, R> builderPropertySetter,
                                             Function<T, R> transformation) {
        this.mappingsContainer.withMapping(recordPropertyGetter, builderPropertySetter, transformation);
        return this;
    }

    public <T> BananaTransformer withMapping(Function<BananaRecord, T> recordPropertyGetter,
                                          BiConsumer<BananaBuilder, T> builderPropertySetter) {
        this.mappingsContainer.withMapping(recordPropertyGetter, builderPropertySetter);
        return this;
    }
}
