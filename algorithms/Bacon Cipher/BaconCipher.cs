using System.Globalization;
using System.Linq;
using System.Text;


namespace ConsoleApp6
{
    public static class BaconCipher
    {
        private static string alphabet = "abcdefghijklmnopqrstuvwxyz";
        private static string[] baconaAlphabet = { "00000", "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001", "01010", "01011", "01100", "01101", "01110", "01111", "10000", "10001", "10010", "10011", "10100", "10101", "10110", "10111", "11000", "11001" };

        public static string CifraBacon(string mensagem, bool decodificar = false, char char1 = 'A', char char2 = 'B')
        { 
            var result = "";

            mensagem = new string(mensagem.Replace(" ", "").Normalize(NormalizationForm.FormD).Where(ch => char.GetUnicodeCategory(ch) != UnicodeCategory.NonSpacingMark).ToArray());

            if (decodificar)
            {
                mensagem = mensagem.Replace(char1, '0').Replace(char2, '1');
                for (int i = 0; i < mensagem.Length; i += 5)
                {
                    for (int j = 0; j < baconaAlphabet.Length; j++)
                    {
                        if (mensagem.Substring(i, 5) == baconaAlphabet[j])
                        {
                            result += alphabet[j];
                        }
                    }
                }
            }
            else
            {
                for (int i = 0; i < mensagem.Length; i++)
                {
                    for (int j = 0; j < alphabet.Length; j++)
                    {
                        if (mensagem[i] == alphabet[j])
                        {
                            result += baconaAlphabet[j];
                            break;
                        }
                    }
                }
            }

            return result.Replace('0', char1).Replace('1', char2);
        }

        /*Fontes:
         * https://wiki.imesec.ime.usp.br/books/ctf-starter-pack/page/cifra-de-bacon
         * https://pt.wikipedia.org/wiki/Código_Bacon
         */
    }
}
