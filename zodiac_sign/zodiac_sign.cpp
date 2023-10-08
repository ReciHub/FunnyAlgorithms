#include<bits/stdc++.h>

using namespace std;
int main()
{
    int mmdd;
    string Zodiac_sign;
    cout << "Please eneter your date of birth in MMDD format : " ;
    cin >> mmdd;
    Zodiac_sign = "Not available for this input";

    if (120 <= mmdd && mmdd  <= 218)
    {   
        Zodiac_sign = "Aquarius";
    }    
    else if (219 <= mmdd && mmdd  <= 320)
    {   
        Zodiac_sign = "Pisces";
    }
    else if (321 <= mmdd && mmdd  <= 419)
    {   
        Zodiac_sign = "Aries";
    }
    else if (420 <= mmdd && mmdd  <= 520)
    {   
        Zodiac_sign = "Taurus";
    }
    else if (521 <= mmdd && mmdd  <= 621)
    {   
        Zodiac_sign = "Gemini";
    }
    else if (622 <= mmdd && mmdd  <= 722)
    {   
        Zodiac_sign = "Cancer";
    }
    else if (723 <= mmdd && mmdd  <= 822)
    {   
        Zodiac_sign = "Leo";
    }
    else if (823 <= mmdd && mmdd  <= 922)
    {   
        Zodiac_sign = "Virgo";
    }
    else if (923 <= mmdd && mmdd  <= 1023)
    {   
        Zodiac_sign = "Libra";
    }
    else if (1024 <= mmdd && mmdd  <= 1121)
    {   
        Zodiac_sign = "Scorpio";
    }
    else if (1122 <= mmdd  && mmdd  <= 1221)
    {   
        Zodiac_sign = "Sagittarius";
    }
    else if ((1222 <= mmdd && mmdd  <= 1231)||((101 <= mmdd && mmdd  <= 119)))
    {   
        Zodiac_sign = "Capricorn";
    }
    else
    {
        cout << "Invalid format of Date of Birth!! " << endl;
    }
    
    cout << "Your Zodiac Sign is: " << Zodiac_sign << endl;

    return 0;
}
