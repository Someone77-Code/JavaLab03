package Data.Filters;

public class EvenFilter extends Filter {
    public boolean IsAcceptable(Object object) {
        if (object instanceof Integer) {
            if ((Integer) object % 2 == 0 || (Integer) object == 0) {
                return true;
            } else {
                return false;
            }
        } else
            return false;
    }

}
