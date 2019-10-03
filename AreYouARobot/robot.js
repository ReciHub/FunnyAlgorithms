process.stdin.setEncoding("utf8");

const ROBOT_SPEED_MS = 200;
const QUESTIONS = [
  "Ready to know if you are a robot?\n",
  "What is 2+2?\n",
  "Good to know that you know basic math, but lets get real...\n",
  "What is the answer of the universe, life and everything?\n",
  "I want to believe that you are not a robot. Last Question...\n",
  "What is the key? Only robots would know\n"
];

const display = (str, deplayMs = ROBOT_SPEED_MS) =>
  new Promise(resolve => {
    let i = 0;
    let intervalId = setInterval(() => {
      process.stdout.write(str.charAt(i++));

      if (i > str.length) {
        clearInterval(intervalId);
        resolve();
      }
    }, ROBOT_SPEED_MS);
  });

const displayIdx = idx => display(QUESTIONS[idx]);

const answer = () =>
  new Promise(resolve => {
    process.stdin.resume();
    process.stdin.on("data", function(data) {
      process.stdin.pause();
      resolve(data.replace(/^[\r\n]+|\.|[\r\n]+$/g, ""));
    });
  });

async function main() {
  await displayIdx(0);
  await displayIdx(1);

  if ((await answer()) === "4") {
    await displayIdx(2);
    await displayIdx(3);

    if ((await answer()) === "42") {
      await displayIdx(4);
      await displayIdx(5);

      if ((await answer()) === "i'm a robot") {
        await display("You truly are a robot\n");
        process.exit();
      }
    }
  }

  await display("You aren't a robot\n", 0);
  process.exit(1);
}

main();
