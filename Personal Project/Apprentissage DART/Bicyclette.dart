class Bicyclette {
  int cadence;
  int? _speed;
  int gear;

  Bicyclette(this.cadence, this.gear, this._speed);

  @override
  String toString() {
    return "This bike goes at $_speed mph";
  }

  int? getSpeed() => _speed;

  void applyBreakUp(int down) => _speed -= down;

  void applySpeedUp(int up) => _speed += up;
}
