package src;

public class Code1 {
    
    /**
     * Main Method encodes and decodes text.
     * Returns input and output
     * 
     * @param args command line input that follows the format [Text, Key, {encode/decode}]
     * */
    public static void main(String[] args) { 
        
        char[] input = args[0].toCharArray();
        char[] key = args[1].toCharArray();
        
        if (args[2].equals("encode")) {
            char[] output = new char[input.length*2];
            
            int k = 0;
            int i = 0;
            for (char val : input) { //encodes each character
                char val1 = 'a';
                char val2 = 'a';
                
                val1 = (char)(val - ((val - 32) - 
                                     (Math.random() * (val - 32))));
                val2 = (char)(val - (val1 - 32));
                
                val1 = (char)((((val1 + (key[k] - 32)) - 32) % 94) + 32);
                val2 = (char)((((val2 + (key[k] - 32)) - 32) % 94) + 32);
                
                while (val1 == 39 || val2 == 39) {
                    
                    val1 = (char)(val - ((val - 32) - 
                                         (Math.random() * (val - 32))));
                    val2 = (char)(val - (val1 - 32));
                    
                    val1 = (char)((((val1 + (key[k] - 32)) - 32) % 94) + 32);
                    val2 = (char)((((val2 + (key[k] - 32)) - 32) % 94) + 32);
                    
                }
                
                
                
                output[i] = val1;
                output[i+1] = val2;
                
                i += 2;
                if(k == key.length - 1)
                    k = 0;
                else
                    k++;
            }
            
            System.out.println(input);
            System.out.println(output);
            
        } else if (args[2].equals("decode")) {
            char[] output = new char[input.length/2];
            
            int k = 0;
            int i = 0;
            
            Character prevchar = null;
            for (char val : input) { //decodes every pair of characters
                if (prevchar == null)
                    prevchar = val;
                else {
                    char value = (char)((prevchar - 32) + val);
                    value = (char)(((((value - 32) - 2*(key[k] - 32)) + 94*2)
                                        % 94) + 32);
                    output[i] = (value);
                    prevchar = null;
                    i++;
                    if(k == key.length-1)
                        k = 0;
                    else
                        k++;
                }
            }
            
            System.out.println(input);
            System.out.println(output);
        } else {
            System.out.print(args[2]);
        }
    }
    
}
