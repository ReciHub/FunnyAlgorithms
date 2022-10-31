const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: 'From 0-100 how cool you think you are?: '
});

rl.prompt();

rl.on('line', x => {
  printMessage(Number(x));
  rl.prompt();
});

function printMessage (x) {
  let i = 0;
  let lista = [];
  while (i < x) {
    const value = Math.floor(Math.random() * (x + 1));
    if (value === 0 || lista.includes(value)) {
      continue;
    }
    lista.push(value);
    i++;
  }
  const posi = Math.floor(Math.random() * x);
  if (lista[posi] > (x / 2)) {
    console.log('You are cool!');
  } else if (lista[posi] < (x / 2)) {
    console.log('You are not cool!');
  } else {
    console.log('You are the rarest kind of cool!');
  }
}
