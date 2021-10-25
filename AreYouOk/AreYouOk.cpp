#include <iostream>
#include <stdio.h>

using namespace std;

void invalidAnswer(){
  cout << "Oh, I didn't understand you :(" << endl << "say 'y' for yes or 'n' for no" << endl;
  return;
}

int main()
{
    char answer;

    cout << "Oh, hey there, are u ok buddy?" << endl;

    do{
      cin >> answer;

      if(answer!='y'&& answer!='n'){
        invalidAnswer();
      }
    } while (answer!='y'&& answer!='n');

    if (answer=='n')
    {
        cout << ":(" << endl <<"Hope you get better my friend" << endl;  
    }
    else if (answer == 'y')
    {
        cout << "Really? oh that's great" << endl;
        cout << "Hey have you ever searched for 'sea doggos' videos?" << endl;
        
        do{
          cin >> answer;

          if(answer!='y'&& answer!='n'){
            invalidAnswer();
          }
        } while (answer!='y'&& answer!='n');

        if (answer== 'n')
        {
            cout << "You're definitely not ok." << endl;
            cout<< "Go there right now, you don't know what you're missing" << endl;
        }
        else if (answer == 'y')
        {
            cout <<"Oh! Nice" << endl;
            cout <<"Aren't they cute?"<< endl;

            do{
              cin >> answer;

              if(answer!='y'&& answer!='n'){
                invalidAnswer();
              }
            } while (answer!='y'&& answer!='n');

            if (answer == 'n')
            {
                cout <<"You're definitely not ok."<< endl;   
            }
            else if(answer == 'y')
            {
                cout <<":D"<< endl;
                cout <<"Well, everything actually seens ok with you"<< endl;
            }
        }
    }

    return 0;
}
