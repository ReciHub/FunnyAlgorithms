// Code by:Shashank
// Github: github.com/shshankm597
Math.floor(Math.random() * 20);

process.stdin.setEncoding('UTF-8');

const writeText = (text, waitResponse = true, method = 'process') => {
  switch (method) {
    case 'process':
      process.stdout.write(text);
      if (waitResponse) {
        return new Promise(resolve => {
          process.stdin.resume();
          process.stdin.on('data', function(data) {
            process.stdin.pause();
            resolve(data);
          });
        });
      } else {
        break;
      }
    case 'prompt':
      if (waitResponse) {
        return new Promise(resolve => resolve(prompt(text)));
      } else {
        alert(text);
      }
    default:
      console.log(text);
  }
};

async function Coolmeter() {
  const x = Number(await writeText('From 0-100 how cool you think you are?: '));
  let i = 0;
  const lista = [];
  if (typeof x === 'number' && x >= 0 && x <= 100) {
    while (i !== x) {
      let value = Math.round(Math.random() * (x + 1));
      if (lista.includes(value) === true) continue;
      if (value === 0) continue;
      lista.push(value);
      i = i + 1;
    }
    let posi = Math.round(Math.random() * (lista.length - 1));
    if (lista[posi] > x / 2) writeText('You are cool!', false);
    else if (lista[posi] < x / 2) writeText('You are not cool!', false);
    else writeText('You are the rarest kind of cool', false);
  } else {
    writeText('Out of range');
  }
}

Coolmeter();
