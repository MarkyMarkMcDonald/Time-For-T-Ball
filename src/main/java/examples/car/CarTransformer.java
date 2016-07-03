package examples.car;

import transformers.Transformer;
import transformers.MappingContainers;
import transformers.MappingsContainer;


class CarTransformer implements Transformer<CarRecord, CarBuilder> {

    private final MappingsContainer<CarRecord, CarBuilder> mappingsContainer;

    public CarTransformer() {
        this.mappingsContainer = MappingContainers.listBacked();
    }

    @Override
    public MappingsContainer<CarRecord, CarBuilder> getMappingsContainer() {
        return mappingsContainer;
    }
}
