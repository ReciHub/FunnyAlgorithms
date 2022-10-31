function hot_potato_game(names: string[], repetitions: number): string {
    for (let i = 0; i < repetitions; i++) {
        const person = names.pop();
        names = [person, ...names];
    }

    return names.pop();
}

const loser = hot_potato_game(['Nick', 'John', 'Connor', 'Mike', 'Paul'], 12);
console.log(loser);