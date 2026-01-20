function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}

function getCoolnessLevel() {
  const input = prompt("From 0-100 how cool do you think you are?: ");
  const coolnessLevel = Number(input);
  if (isNaN(coolnessLevel) || coolnessLevel < 0 || coolnessLevel > 100) {
    alert("Please enter a valid number between 0 and 100.");
    return null;
  }
  return coolnessLevel;
}

function generateUniqueRandomNumbers(count, max) {
  const uniqueNumbers = new Set();
  while (uniqueNumbers.size < count) {
    const randomNumber = getRandomInt(max + 1);
    if (randomNumber !== 0) {
      uniqueNumbers.add(randomNumber);
    }
  }
  return Array.from(uniqueNumbers);
}

function evaluateCoolness(coolnessLevel, randomNumbers) {
  const randomIndex = getRandomInt(coolnessLevel);
  const selectedNumber = randomNumbers[randomIndex];
  if (selectedNumber > coolnessLevel / 2) {
    alert("You are cool!");
  } else if (selectedNumber < coolnessLevel / 2) {
    alert("You are not cool!");
  } else {
    alert("You are the coolest of the coolest!");
  }
}

function Coolmeter() {
  const coolnessLevel = getCoolnessLevel();
  if (coolnessLevel === null) return;

  const randomNumbers = generateUniqueRandomNumbers(coolnessLevel, coolnessLevel);
  evaluateCoolness(coolnessLevel, randomNumbers);
}

Coolmeter();Math.floor(Math.random() * 20);


function Coolmeter () {
  const x = Number(prompt("From 0-100 how coolio you think you are?: "));
  let i = 0;
    let lista =[];
    while(i!= x) {
        
        let value = Math.random(x+1);
        if (lista.includes(value) == true)
            continue;
        if (value == 0)
            continue;
        lista.push(value);
        i = i+1;
    }
    let posi = Math.random(x);
    if(lista[posi]>x/2)
        prompt("You are cool!");
    else if(lista[posi]< x/2)
        prompt("You are not coolio!");
    else
    prompt("You are the coolest of the coolest");
};
