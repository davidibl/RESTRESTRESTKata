# REST REST REST Kata
**how to make web services cool again**

In dieser Kata wird die Bereitstellung und der Konsum von REST web services geübt.

ZU dieser Kata existiert ein Artikel auf medium.com über die Implementierung von REST services:
https://medium.com/@davidibl/rest-rest-rest-169847261a79

Die verschiedenen Schritte werden durch unterschiedliche Branches repräsentiert.

1. Dokumentation (von *master* auf *boilerplate*)
Fügt eine aussagekräftige Dokumentation ein. Alle Ressourcen und Modelle sollten hinreichend beschrieben sein.

2. Server Boilerplate (von *boilerplate* auf *robust*)
Reduziert den Boilerplate Code Serverseitig. Sorgt für einen vereinfachten Umgang mit Fehlern. Idealerweise können am Ende irgendo im Code Exceptions ausgelöst werden, die die in der DOkumentation angegebenen Error Status und Modelle auslösen.

3. Robust (von *robus*)
Bringt den CLient im Test zum brechen...
Das heißt: Der Test soll zu unrecht rot werden. Implementiert server-seitig eine Änderung die Tests rot werden lässt ohne dass sich an der Funktionalität was ändert.
Welche Änderungen sind hier relevant?
Wie kann man den Client gegenüber solcher Änderungen robust gestalten?

Die Lösung der Aufgabe 3 wird in Kürze nachgereicht.