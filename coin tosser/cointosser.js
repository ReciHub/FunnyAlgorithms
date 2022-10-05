function coinToss() {
    const rand = Math.round(Math.random());

    console.log(rand === 0 ? 'heads!' : 'tails!');
}

coinToss();