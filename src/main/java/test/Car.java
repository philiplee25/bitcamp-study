package test;

public class Car {
  Engine engine;

  void start() {
    engine.onSparkPlug();
    engine.MoveMotor();
  }

  void stop() {
    engine.offSparkPlug();
    engine.stopMotor();
  }
}
