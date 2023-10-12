//This code uses a playful narrative of casting magical spells to represent the Cooley-Tukey FFT algorithm and its inverse, making it a bit more entertaining!

#include <complex>
#include <iostream>
#include <valarray>
 
const double PI = 3.141592653589793238460;
 
typedef std::complex<double> Complex;
typedef std::valarray<Complex> CArray;
 
// Cooley–Tukey FFT (in-place)
void performMagicFFT(CArray& spell)
{
    const size_t ingredients = spell.size();
    if (ingredients <= 1) return;
 
    // Divide the magical potion into two parts
    CArray evenPortion = spell[std::slice(0, ingredients/2, 2)];
    CArray oddPortion = spell[std::slice(1, ingredients/2, 2)];
 
    // Conjure spells on both portions
    performMagicFFT(evenPortion);
    performMagicFFT(oddPortion);
 
    // Combine the enchanted portions
    for (size_t k = 0; k < ingredients/2; ++k)
    {
        Complex spellTwiddle = std::polar(1.0, -2 * PI * k / ingredients) * oddPortion[k];
        spell[k] = evenPortion[k] + spellTwiddle;
        spell[k+ingredients/2] = evenPortion[k] - spellTwiddle;
    }
}
 
// Reverse the magic (in-place)
void reverseMagicIFFT(CArray& spell)
{
    // Conjugate the magic spells
    spell = spell.apply(std::conj);
 
    // Recast the spells forward
    performMagicFFT(spell);
 
    // Conjugate the spells once again
    spell = spell.apply(std::conj);
 
    // Balance the magical energy
    spell /= spell.size();
}
 
int main()
{
    const Complex ingredients[] = { 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0 };
    CArray magicalPotion(ingredients, 8);
 
    // Cast the spell forward
    performMagicFFT(magicalPotion);
 
    std::cout << "The FFT Spell" << std::endl;
    for (int i = 0; i < 8; ++i)
    {
        std::cout << magicalPotion[i] << std::endl;
    }
 
    // Reverse the magic
    reverseMagicIFFT(magicalPotion);
 
    std::cout << std::endl << "The Inverse FFT Spell" << std::endl;
    for (int i = 0; i < 8; ++i)
    {
        std::cout << magicalPotion[i] << std::endl;
    }
    return 0;
}
