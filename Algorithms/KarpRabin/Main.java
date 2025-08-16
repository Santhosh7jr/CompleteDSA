package Algorithms.KarpRabin;
import java.util.*;

public class Main {

    private static final int PRIME = 101;

    public static void main(String[] args) {

        search("abdcedbabdadbcabd", "abd");

    }

    public static void search(String text, String pattern) {

        int patternLen = pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, patternLen));

        for (int i = 0; i <= text.length() - patternLen; i++) {

            if (textHash == patternHash) {

                if (text.substring(i, i+patternLen).equals(pattern)) {

                    System.out.println("pattern found at index: "+i);

                }

            }

            if (i < text.length() - patternLen){

                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLen), patternLen);

            }

        }

    }

    private static double calculateHash(String str) {

        double hash = 0;

        for(int i = 0; i < str.length(); i++) {

            hash += str.charAt(i) * Math.pow(PRIME, i);

        }

        return hash;

    }

    private static double updateHash(double prevHash, char oldChar, char newChar, int patternLen) {

        double newHash = (prevHash - oldChar) / PRIME;
        newHash += newChar * Math.pow(PRIME, patternLen - 1);

        return newHash;

    }

}
