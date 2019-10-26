package Data.Aggregators;

import java.math.BigDecimal;
import java.util.List;

public class SumAggregator extends Aggregator {
    public Object Apply(Object object1) {
        BigDecimal sum = new BigDecimal(0);
        if (object1 instanceof List) {

            List object = (List) object1;
            for (int i = 0; i < object.size(); i++) {

                if (object.get(i) instanceof Number) {
                    sum = new BigDecimal(((Number) object.get(i)).floatValue()).add(sum);
                }
            }
        } else {
            if (object1 instanceof Number)
                sum = new BigDecimal(((Number) object1).floatValue());
        }

        return sum;
    }
}

