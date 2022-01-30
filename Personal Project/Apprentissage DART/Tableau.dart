class Tableau {
  List<int> number;

  Tableau(this.number);

  void add(int num) => number.add(num);

  int tailleTab() => number.length;

  int numTab(int index) => number[index];
}
