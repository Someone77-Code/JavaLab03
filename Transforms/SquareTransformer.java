package Data.Transforms;

public class SquareTransformer extends Transformer {

    public Object Apply(Object object) {
        Number Result = 0;
        if (object instanceof Number) {
            Result = ((Number) object).floatValue() * ((Number) object).floatValue();
        }
        return Result;
    }

}
