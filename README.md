Ampoule simule le fonctionnement d'une ampoule sur laquelle on peut regler la luminosité

Specification UPnP: L'ampoule reçoit deux commandes UPnP pour soit régler la luminosité ou verouiller/deverouiller le réglage
1- Réglage de la luminosité: l'ampoule réçoit une chaine de caractère représentant une valeur entière entre 0 et 100
   et la luminosité est automatiquement reglée sur cette valeur si l'ampoule est déverouillée
2- Vérouillage/Déverouillage : l'ampoule réçoit la chaine "CENTRE" et se vérouille/déverouille en fonction de l'état courant.
A l'état vérouillé l'application se déverouille automatiquement au bout d'un certain temps  

Execution: Le repertoire build le .jar de l'application

Maintenance: C'est un projet Maven. 
Effectuer les modifications à faire Ajouter une configuration d'éxecution Maven avec la phase "package" pour exporter en .jar Executer cette commande;
 deux fichiers .jar sont crées dans un nouveau dossier target Ampoule-0.0.1-SNAPSHOT-jar-with-dependencies.jar qui est le bon éxecutable
