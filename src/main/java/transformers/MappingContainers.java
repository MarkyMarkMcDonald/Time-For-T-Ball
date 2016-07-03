package transformers;

import java.util.ArrayList;
import java.util.List;

public class MappingContainers {

    public static <T,R> MappingsContainer<T,R> listBacked() {
        return new ListBackedMappingsContainer<>();
    }

    private static class ListBackedMappingsContainer<T,R> implements MappingsContainer<T, R> {
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
