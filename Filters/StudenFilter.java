package Data.Filters;

import Data.TestObjects.Student;

public class StudenFilter extends Filter {
    public boolean IsAcceptable(Object object) {
        if (object instanceof Student) {
            if (((Student) object).getAverage() >= 60 && ((Student) object).getProgrammingMark() >= 60) {
                return true;
            } else {
                return false;
            }
        } else
            return false;
    }
}
