#define LED 53

int byte_entrada = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(LED, OUTPUT);
  digitalWrite(LED, LOW);
}

void loop() {
  // put your main code here, to run repeatedly:
  byte_entrada = Serial.read();
  
  if(byte_entrada == '0') {
    digitalWrite(LED, LOW);
  }
  else if(byte_entrada == '1'){
    digitalWrite(LED, HIGH);
  }
  
}
