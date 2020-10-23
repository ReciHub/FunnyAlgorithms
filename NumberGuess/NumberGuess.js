var readline = require('readline');

function guess_num(){
    var question = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    
    const num = Math.floor(Math.random() * 100);     // returns a random integer from 0 to 99
    question.question("Guess The Number :", (answer)=>{
        if (num == answer){
            console.log("You Win!");
            return
        }
        else{
            console.log("You Lose");
        }
        question.close()
    })   
}

guess_num()
