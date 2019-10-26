package Data.Transforms;


public class CharTransformer extends Transformer {
    public Object Apply(Object object) {
        String Alphabet = "abcdefghijklmnopqrstuvwxyz";
        String Result = "";
        if (object instanceof String) {
            char[] temp1 = ((String) object).toLowerCase().toCharArray();
            for (int i = 0; i < temp1.length; i++) {
                Result += Integer.toString(Alphabet.indexOf(temp1[i]) + 1);
            }
        }
        return Result;

    }
}
