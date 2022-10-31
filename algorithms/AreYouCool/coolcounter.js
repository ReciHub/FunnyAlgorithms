Math.floor(Math.random() * 20);


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
