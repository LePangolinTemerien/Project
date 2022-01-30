import 'MapTest.dart';

void main(List<String> args) {
  Map<String, int> map = {'hello': 1};
  var mapT = MapTest(map);
  print(mapT.element('hello'));
  mapT.ajouter('bye', 2);
  print(mapT.element('bye'));
  mapT.retirer('bye');
  print(mapT.element('bye'));
}
