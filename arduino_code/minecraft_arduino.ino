#define LED 53 //Change this to your arduino PIN

int input_byte = 0;

void setup() {
  
  Serial.begin(9600);
  pinMode(LED, OUTPUT);
  digitalWrite(LED, LOW);
}

void loop() {
  
  input_byte = Serial.read();
  
  if(input_byte == '0') {
    digitalWrite(LED, LOW);
  }
  else if(input_byte == '1'){
    digitalWrite(LED, HIGH);
  }
  
}
