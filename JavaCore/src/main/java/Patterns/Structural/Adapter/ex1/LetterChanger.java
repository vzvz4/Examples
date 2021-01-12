package Patterns.Structural.Adapter.ex1;

public class LetterChanger implements Processor{
    
    @Override
    public String process(Object input) {
        char[] str = ((String) input).toCharArray();
        for (int i = 0; i < (str.length - 1)/2; i++) {
            char temp = str[Math.abs(i - str.length + 1)];
            str[Math.abs(i - str.length + 1)] = str[i];
            str[i] = temp;
        }
        return new String(str);
    }
}
