const dict = {
	A: "00000",
	B: "00001",
	C: "00010",
	D: "00011",
	E: "00100",
	F: "00101",
	G: "00110",
	H: "00111",
	I: "01000",
	J: "01001",
	K: "01010",
	L: "01011",
	M: "01100",
	N: "01101",
	O: "01110",
	P: "01111",
	Q: "10000",
	R: "10001",
	S: "10010",
	T: "10011",
	U: "10100",
	V: "10101",
	W: "10110",
	X: "10111",
	Y: "11000",
	Z: "11001"
};


function baconCipher(text, decode = false, charA = "a", charB = "b") {
	if (decode) {
		return text.replace(/\w/g, m => m === charA ? 0 : 1).replace(/\w{5}/g, m => Object.keys(dict).find(k => dict[k] === m));
	} else {
		return text.replace(/\w/g, m => dict[m.toUpperCase()]).replace(/\w/g, m => Number(m) ? charB : charA);
	}
}