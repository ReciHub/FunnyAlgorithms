using System.Globalization;
using System.Linq;
using System.Text;


namespace ConsoleApp6
{
    public static class BaconCipher
    {
        private static string alfabeto = "abcdefghijklmnopqrstuvwxyz";
        private static string[] baconAlfabeto = { "00000", "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001", "01010", "01011", "01100", "01101", "01110", "01111", "10000", "10001", "10010", "10011", "10100", "10101", "10110", "10111", "11000", "11001" };

        public static string CifraBacon(string mensagem, bool decodificar = false, char char1 = 'A', char char2 = 'B')
        { 
            var resultado = "";

            mensagem = new string(mensagem.Replace(" ", "").Normalize(NormalizationForm.FormD).Where(ch => char.GetUnicodeCategory(ch) != UnicodeCategory.NonSpacingMark).ToArray());

            if (decodificar)
            {
                mensagem = mensagem.Replace(char1, '0').Replace(char2, '1');
                for (int i = 0; i < mensagem.Length; i += 5)
                {
                    for (int j = 0; j < baconAlfabeto.Length; j++)
                    {
                        if (mensagem.Substring(i, 5) == baconAlfabeto[j])
                        {
                            resultado += alfabeto[j];
                        }
                    }
                }
            }
            else
            {
                for (int i = 0; i < mensagem.Length; i++)
                {
                    for (int j = 0; j < alfabeto.Length; j++)
                    {
                        if (mensagem[i] == alfabeto[j])
                        {
                            resultado += baconAlfabeto[j];
                            break;
                        }
                    }
                }
            }

            return resultado.Replace('0', char1).Replace('1', char2);
        }
    }
}
