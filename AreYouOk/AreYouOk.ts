var readlineSync = require('readline-sync');
 
async function main () {
    console.log("Oh, hey there, are u ok buddy?");
    let answer = ""
    do {
        answer = readlineSync.question();
        if(answer != 'y' && answer != 'n'){
            invalidAnswer();
          }
    } while ((answer !== 'y') && (answer !== 'n'));
    if (answer == 'n') {
        console.log("You're definitely not ok.\n");
        console.log("Go there right now, you don't know what you're missing\n");
    }else if (answer == 'y'){
        console.log("Oh! Nice\n");
        console.log("Aren't they cute?\n");
        do {
            answer = readlineSync.question();
            if(answer != 'y' && answer != 'n'){
                invalidAnswer();
              }
        } while (answer != 'y' && answer != 'n');
        if (answer == 'n') {
            console.log("You're definitely not ok.\n");
        }
        else if(answer == 'y') {
            console.log(":D\n");
            console.log("Well, everything actually seens ok with you\n");
        }
    }
}
main()

function invalidAnswer() {
    console.log("Oh, I didn't understand you :(\nsay 'y' for yes or 'n' for no\n");
}
