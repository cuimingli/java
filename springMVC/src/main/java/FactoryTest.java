public class FactoryTest {
    public static void main(String args[]){
        Creator factory  = new ConcreteCreator();
        Product product1 = factory.createProduct(ConcreateProduct1.class);
        Product product2 = factory.createProduct(ConcreateProduct2.class);

    }
}
