package src;

public class Driver {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    String input = args[0];
    String key = args[1];
    String mode = args[2]; // encode/decode
    String code = args[3];

    Cipher method = null;

    switch (code) {
    case ("Code1") :
      method = new Code1();
      break;
    default:
      System.out.println("provide a valid code value");
    }
    
    if(method != null) {
    switch (mode) {
    case ("encode"):
      System.out.println(method.encode(input, key));
      break;
    case ("decode"):
      System.out.println(method.decode(input, key));
      break;
    default:
      System.out.println("provide a valid mode");
    }
    }
    
  }

}
