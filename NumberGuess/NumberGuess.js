//
// def guess_num():
//   num=random.randint(1,100)
//   chance=1
//   while chance<=5:
//     n=int(input("Guess The Number : "))
//     if num==n:
//       return "You Win"
//      else:
//       chance+=1
//       return "Try Again"
//     return "You Lose"
 
// game_play='Y'
// while game_play='y' or game_play='Y':
//   guess_num()
//   game_play=input("Do You Wanna PLay Again? ")
var readline = require('readline');
function guess_num(){
    var question = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    
    const num = Math.floor(Math.random() * 100);     // returns a random integer from 0 to 99
    chance = 1;


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