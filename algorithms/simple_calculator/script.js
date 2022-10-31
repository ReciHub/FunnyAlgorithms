function dis(val) {
    document.getElementById("sac").value += val;
}
//function for evaluation
function solve() {
    let x = document.getElementById("sac").value;
    let y = eval(x);
    document.getElementById("sac").value = y;
}
//function for clearing the display
function clr() {
    document.getElementById("sac").value = "";
}