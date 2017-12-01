package src;

public class Code1 implements Cipher {

  private final int sub = 32; // this value is
  // subtracted from characters to make the character system effectively start at "space"
  private final int charCount = 94; // total number of available characters

  public String encode(String toCode, String codeKey) {
    char[] input = toCode.toCharArray();
    char[] key = codeKey.toCharArray();

    char[] output = new char[input.length * 2];

    int k = 0;
    int i = 0;
    for (char val : input) { // encodes each character
      char val1 = 'a';
      char val2 = 'a';

      val1 = (char) (val - ((val - sub) - (Math.random() * (val - sub))));
      val2 = (char) (val - (val1 - sub));

      val1 = (char) ((((val1 + (key[k] - sub)) - sub) % charCount) + sub);
      val2 = (char) ((((val2 + (key[k] - sub)) - sub) % charCount) + sub);

      while (val1 == 39 || val2 == 39) {

        val1 = (char) (val - ((val - sub) - (Math.random() * (val - sub))));
        val2 = (char) (val - (val1 - sub));

        val1 = (char) ((((val1 + (key[k] - sub)) - sub) % charCount) + sub);
        val2 = (char) ((((val2 + (key[k] - sub)) - sub) % charCount) + sub);

      }

      output[i] = val1;
      output[i + 1] = val2;

      i += 2;
      if (k == key.length - 1)
        k = 0;
      else
        k++;
    }

    return new String(output);

  }

  public String decode(String toDecode, String codeKey) {

    char[] input = toDecode.toCharArray();
    char[] key = codeKey.toCharArray();
    char[] output = new char[input.length / 2];

    int k = 0;
    int i = 0;

    Character prevchar = null;
    for (char val : input) { // decodes every pair of characters
      if (prevchar == null)
        prevchar = val;
      else {
        char value = (char) ((prevchar - sub) + val);
        value = (char) (((((value - sub) - 2 * (key[k] - sub)) + charCount * 2) % charCount) + sub);
        output[i] = (value);
        prevchar = null;
        i++;
        if (k == key.length - 1)
          k = 0;
        else
          k++;
      }
    }
    return new String(output);
  }
}
