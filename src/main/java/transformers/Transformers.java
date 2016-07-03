package transformers;

public class Transformers {
    public static <From, To> Transformer<From, To> create() {
        MappingsContainer<From, To> mappingsContainerCreatedOutsideLambda = MappingContainers.listBacked();
        return () -> mappingsContainerCreatedOutsideLambda;
    }
}
