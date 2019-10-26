package Data.Sequences;

import Data.Aggregators.Aggregator;
import Data.Filters.Filter;
import Data.TestObjects.Student;
import Data.Transforms.Transformer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StudentSequence extends Sequence {
    private List<Student> data;
    int End;

    public StudentSequence(int end) {
        End = end;
    }

    public StudentSequence GenerateList() {
        data = new LinkedList<>();
        for (int i = 0; i < End; i++) {
            data.add(new Student("blabla", ThreadLocalRandom.current().nextInt(18, 24), ThreadLocalRandom.current().nextInt(0, 100), new Random().nextFloat() * (100 - 40) + 40));
        }
        System.out.println("Generated List:");
        for (Student i : data
                ) {
            System.out.print(i.getName() + "\\" + i.getAverage() + "\\" + i.getProgrammingMark() + ",");
            System.out.println();
        }
        System.out.println();
        return this;
    }

    public StudentSequence AcceptFilter(Filter filter) {
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
        for (Student i : data
                ) {
            System.out.print(i.getName() + "\\" + i.getAverage() + "\\" + i.getProgrammingMark() + ",");
        }
        System.out.println();
        return this;
    }

    public Object AcceptAggregator(Aggregator aggregator) {
        return aggregator.Apply(data);
    }

    public StudentSequence AcceptTransformer(Transformer transformer) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, ((Student) transformer.Apply(data.get(i))));
        }
        System.out.println("Transformed List:");
        for (Student i : data
                ) {
            System.out.print(i.getName() + "\\" + i.getAverage() + "\\" + i.getProgrammingMark() + ",");
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
