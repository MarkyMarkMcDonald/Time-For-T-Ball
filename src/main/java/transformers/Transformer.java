package transformers;

import java.util.List;

public interface Transformer<From, To> {

    To transform();

    default void transform(List<PropertyMapping> mappings, From from, To to) {
        mappings.forEach(mapping -> mapping.map(from, to));
    }

}
