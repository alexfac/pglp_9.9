Lancement : mvn compile assembly:single
puis :      java -jar ./target/pglp_9.9-1.0-SNAPSHOT-jar-with-dependencies.jar 

Ensuite vous pourrez utiliser le logiciel
Il vous demandera un nom de dessin.
Apres lui avoir indique vous aurez acces a toutes les commandes disponibles et vous pourrez charger un dessin précédent.

Liste commande :
c=carre((0,0),0)
t=triangle((0,0),(0,0),(0,0))
ce=cercle((0,0),0)
r=rectangle((0,0),10,10)
delete(nomForme)
move(nomForme,(1,1))
moveall(1,1)
save // sauvegarde le dessin actuel
load(nomDessin)
quit
