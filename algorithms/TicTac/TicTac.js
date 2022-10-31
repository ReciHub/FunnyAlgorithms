const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

function sleep(milliseconds) {
    var start = new Date().getTime();
    for (var i = 0; i < 1e7; i++) {
      if ((new Date().getTime() - start) > milliseconds){
        break;
      }
    }
  }

rl.question('How much time to wait? (in seconds) ', (answer) => {
    t = parseInt(answer)
    while (t > 0) {
        console.log(t)
        sleep(1000)
        t = t - 1
    }
    console.log("BOOM!");
  rl.close();
});