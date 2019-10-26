package Data.Filters;

public class OddFilter extends Filter {

    public boolean IsAcceptable(Object object) {
        if (object instanceof Integer) {
            if ((Integer) object % 2 != 0) {
                return true;
            } else {
                return false;
            }
        } else
            return false;
    }
}
