package transformers;

import java.util.ArrayList;
import java.util.List;

public class MappingContainers {

    public static <From, To> MappingsContainer<From, To> listBacked() {
        return new ListBackedMappingsContainer<>();
    }

    private static class ListBackedMappingsContainer<From, To> implements MappingsContainer<From, To> {
        private List<PropertyMapping> propertyMappings = new ArrayList<>();

        @Override
        public List<PropertyMapping> getPropertyMappings() {
            return propertyMappings;
        }

        @Override
        public void addPropertyMapping(PropertyMapping propertyMapping) {
            propertyMappings.add(propertyMapping);
        }
    }
}
