class MapTest {
  Map<String, int> uneMap;

  MapTest(this.uneMap);

  void ajouter(String key, int value) => uneMap[key] = value;

  void retirer(String key) => uneMap.remove(key);

  int? element(String key) => uneMap[key];
}
