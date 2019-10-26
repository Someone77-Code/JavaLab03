package Data.Sequences;

import Data.Aggregators.Aggregator;
import Data.Filters.Filter;
import Data.Transforms.Transformer;

import java.util.LinkedList;
import java.util.List;

public class FibonacciSequence extends Sequence {
    private List<Integer> data;
    int End;

    public FibonacciSequence(int end) {
        End = end;
    }

    public FibonacciSequence GenerateList() {
        data = new LinkedList<>();
        data.add(1);
        data.add(1);
        while ((data.get(data.size() - 1) + data.get(data.size() - 2)) <= End) {
            data.add((data.get(data.size() - 1) + data.get(data.size() - 2)));
        }
        System.out.println("Generated List:");
        for (Integer i : data
                ) {
            System.out.print(i + ",");

        }
        System.out.println();
        return this;
    }

    public FibonacciSequence AcceptFilter(Filter filter) {
        List<Object> Removal = new LinkedList<>();
        for (int i = 0; i < data.size(); i++) {
            if (filter.IsAcceptable(data.get(i))) {
            } else {
                Removal.add(data.get(i));
            }
        }
        for (int i = 0; i < Removal.size(); i++) {
            data.remove(Removal.get(i));
        }
        System.out.println("Filtered List:");
        for (Integer i : data
                ) {
            System.out.print(i + ",");
        }
        System.out.println();
        return this;
    }

    public Object AcceptAggregator(Aggregator aggregator) {
        return aggregator.Apply(data);
    }

    public FibonacciSequence AcceptTransformer(Transformer transformer) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, ((Number) transformer.Apply(data.get(i))).intValue());
        }
        System.out.println("Transformed List:");
        for (Integer i : data
                ) {
            System.out.print(i + ",");
        }
        System.out.println();
        return this;
    }

    public int occurrence(Object object) {
        int Occurrence = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(object))
                Occurrence++;
        }
        return Occurrence;
    }

}
