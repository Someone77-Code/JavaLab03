package Data.Sequences;

import Data.Aggregators.Aggregator;
import Data.Aggregators.IAggregatabale;
import Data.Filters.Filter;
import Data.Filters.IFilterable;
import Data.Transforms.ITransformable;
import Data.Transforms.Transformer;

public abstract class Sequence implements IFilterable, IAggregatabale, ITransformable {
    public abstract Sequence GenerateList();

    public abstract IFilterable AcceptFilter(Filter filter);

    public abstract Object AcceptAggregator(Aggregator aggregator);

    public abstract ITransformable AcceptTransformer(Transformer transformer);

    public abstract int occurrence(Object object);

}
