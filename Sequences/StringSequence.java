package Data.Sequences;

import Data.Aggregators.Aggregator;
import Data.Filters.Filter;
import Data.Transforms.Transformer;

import java.util.LinkedList;
import java.util.List;


public class StringSequence extends Sequence {
    private List<String> data;
    int End;

    public StringSequence(int end) {
        End = end;
    }

    public StringSequence GenerateList() {
        data = new LinkedList<>();
        for (int i = 0; i < End; i++) {
            data.add("abcde");
        }
        System.out.println("Generated List:");
        for (String i : data
                ) {
            System.out.print(i + ",");
            System.out.println();
        }
        System.out.println();
        return this;
    }

    public StringSequence AcceptFilter(Filter filter) {
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
        for (String i : data
                ) {
            System.out.print(i + ",");
        }
        System.out.println();
        return this;
    }

    public Object AcceptAggregator(Aggregator aggregator) {
        return aggregator.Apply(data);
    }

    public StringSequence AcceptTransformer(Transformer transformer) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, ((String) transformer.Apply(data.get(i))));
        }
        System.out.println("Transformed List:");
        for (String i : data
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
