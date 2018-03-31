import org.apache.poi.hssf.record.formula.functions.T;

public abstract class Creator {
    public abstract <T extends Product> T createProduct(Class<T> clazz);
}
