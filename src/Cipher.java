package src;

public abstract interface Cipher {
  
  /**
   * encodes input with key and returns encoded text.
   * 
   * @return encoded text
   * 
   * @param input text input to encode
   * @param key key used for encoding
   * */
  String encode(String input, String key);
  
  /**
   * decodes input with key and returns decoded text.
   * 
   * @return decoded text
   * 
   * @param input encoded text input to decode
   * @param key key used for decoding
   * */
  abstract String decode(String input, String key);
}
