// Hill Cipher implementation in Java

import java.util.Arrays;
import java.util.Scanner;

public class HillCipher {

        // Generate the key matrix for the key string
        static void getKeyMatrix(String key, int keyMatrix[][])
        {
            int c = 0;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    keyMatrix[i][j] = (key.charAt(c)) % 65;
                    c++;
                }
            }
        }

        // Encrypt the message
        static void encrypt(int cipherMatrix[][],
                            int keyMatrix[][],
                            int messageMatrix[][])
        {
            int x, i, j;
            for (i = 0; i < 3; i++)
            {
                for (j = 0; j < 1; j++)
                {
                    cipherMatrix[i][j] = 0;

                    for (x = 0; x < 3; x++)
                    {
                        cipherMatrix[i][j] += keyMatrix[i][x] * messageMatrix[x][j];
                    }

                    cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
                }
            }
        }

        // Function to implement Hill Cipher
        static void HillCipher(String message, String key)
        {
            // Get key matrix from the key string
            int [][]keyMatrix = new int[3][3];
            getKeyMatrix(key, keyMatrix);

            int [][]messageMatrix = new int[3][1];

            // Generate vector for the message
            for (int i = 0; i < 3; i++)
                messageMatrix[i][0] = (message.charAt(i)) % 65;

            int [][]cipherMatrix = new int[3][1];

            // Generate the encrypted vector
            encrypt(cipherMatrix, keyMatrix, messageMatrix);

            String CipherText="";

            // Generate the encrypted text from the encrypted vector
            for (int i = 0; i < 3; i++)
                CipherText = CipherText + (char)(cipherMatrix[i][0] + 65);

            // Finally print the ciphertext
            System.out.print("Ciphertext:\t" + CipherText);
        }

        public static void main(String[] args)
        {

            Scanner in = new Scanner(System.in);

            // Message to be encrypted
            System.out.print("Enter the message:\t");
            String message = in.next();

            // Enter the key
            //Minimum 9 characters
            System.out.print("Enter the key:\t");
            String key = in.next();

            HillCipher(message, key);
        }
    }

