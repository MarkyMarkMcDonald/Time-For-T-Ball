package examples.banana;

import transformers.Transformer;
import transformers.MappingContainers;
import transformers.MappingsContainer;

class BananaTransformer implements Transformer<BananaRecord, BananaBuilder> {

    private MappingsContainer<BananaRecord, BananaBuilder> mappingsContainer;

    public BananaTransformer() {
        mappingsContainer = MappingContainers.listBacked();
    }

    @Override
    public MappingsContainer<BananaRecord, BananaBuilder> getMappingsContainer() {
        return mappingsContainer;
    }
}
