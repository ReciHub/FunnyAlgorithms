let time = 0;
let wave = [];
let path = [];

let slider;
let slider1;

function setup(){
  createCanvas(650, 400);
  slider = createSlider(1, 30, 1, 1);
  slider1 = createSlider(50, 80, 50,5);
}

function draw() {
  background(255);
  translate(210, 200);

  let x = 0;
  let y = 0;

  for (let i = 0; i < slider.value(); i++) {
    let prevx = x;
    let prevy = y;
    
    let val = slider1.value();
    
    let n = i * 2 + 1;
    let radius = val * (4 / (n * PI));
    x += radius * cos(n * time);
    y += radius * sin(n * time);

    var color = map(slider.value(), 0, 50, 0, 255);
    
    noFill();
    stroke(55, color, 254);
    ellipse(prevx, prevy, radius * 2);

    stroke('blue');
    line(prevx, prevy, x, y);
  }
  wave.unshift(y);

  translate(250, 0);
  stroke(255, 0, 0);
  line(x - 250, y, 0, wave[0]);
  beginShape();
  noFill();
  for (let i = 0; i < wave.length; i++) {
    vertex(i, wave[i]);
    strokeWeight(1.5);
    stroke('green');
  }
  endShape();
  
  time += 0.05;

  if (wave.length > 250) {
    wave.pop();
  }
}

