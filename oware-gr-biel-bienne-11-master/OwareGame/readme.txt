note : suite a de nombreux bugs ne trouvant pas leurs solutions, 
en partie du a l'usage de différentes versions de java sur nos différents appareils, 
et aux différents OS, nous n'avons pas de "vrai" compile and run.
En théorie, le compiling se ferait avec "javac javaFX11.java",
suite a quoi l'on pourrait faire "java -jar javaFX11.jar"

Pour contourner le premier problème, nous avons utilisé la possibilité
donnée par eclipse d'exporter le document sous la forme d'un runnable jar
malheureusement , ne fonctionne pas sur mac, ni sur windows. Dans le cas de
windows, malgrés les tentatives d'ajouter un module-info.java,d'ajouter manuellement
les dll (manquantes?), et autres méthodes, les problèmes ont subsistés.
message d'erreur sur la commande windows:
Graphics Device initialization failed for :  d3d, sw
Error initializing QuantumRenderer: no suitable pipeline found

Par conséquent, nous ne voyons pas d'autres solutions accessibles dans le temps restant,
et donc notre seule option fonctionnelle pour compiler et lancer le programme sera
malheureusement de 
mettre les .java files dans eclipse, ajouter java fx 11 library
ajouter VM argument --module-path "C:\Users\username\javafx\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml
et, pour compiler utiliser l'option d'export
pour run appuyer sur le bouton vert

pour la structure, le main est contenu dans javaFX, la classe move prend les mouvements et captures
le robot donnera un int comme reponse, player aura les joueurs, storehouse les scores,
board aura la version de base du jeu (non fonctionnelle a présent)
voir le diagramme dans le dossier