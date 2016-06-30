package examples;

import transformers.MappingsContainer;
import transformers.PropertyMapping;
import transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

class CarTransformer implements MappingsContainer<CarRecord, CarBuilder>, Transformer<CarRecord, CarBuilder> {

    private List<PropertyMapping> propertyMappings = new ArrayList<>();

    private final CarRecord carRecord;
    private final CarBuilder carBuilder;

    public CarTransformer(CarRecord carRecord, CarBuilder carBuilder) {
        this.carRecord = carRecord;
        this.carBuilder = carBuilder;
    }

    @Override
    public List<PropertyMapping> getPropertyMappings() {
        return propertyMappings;
    }

    @Override
    public void addPropertyMapping(PropertyMapping propertyMapping) {
        propertyMappings.add(propertyMapping);
    }

    @Override
    public CarBuilder transform() {
        transform(getPropertyMappings(), carRecord, carBuilder);
        return carBuilder;
    }

}
