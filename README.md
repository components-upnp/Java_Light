Lampe UPnP offrant des services permettant de contrôler sa luminosité à distance.

<strong>Installation:</strong>

Le fichier .jar permettant d'exécuter l'application se situe dans le répertoire build.

Voici un exemple d'exécution de l'application:

![alt tag](https://github.com/components-upnp/upnp_Light/blob/master/CaptureAmpoule.PNG)

<strong>Spécification UPnP:</strong>

Le composant Lampe offre deux services, LuminositeService et OrdreService, dont voici les spécifications.

LuminositeService:

   1) GetValeur(): permet de récupérer la valeur de la luminosité courante.
   2) SetValeu(int NewValeur): permet de définir la luminosité.
   
OrdreService:

   1) SetValeur(int NewTargetValue): permet de vérouiller ou dévérouiller la lampe avec la chîne de caractère "CENTRE"
   (A l'état vérouillé l'application se déverouille automatiquement au bout d'un certain temps)

Voci le schéma représentant le composant:

![alt tag](https://github.com/components-upnp/upnp_Light/blob/master/Ampoule.png)

<strong>Maintenance:</strong> 

C'est un projet Maven. 
Effectuer les modifications à faire, ajouter une configuration d'éxecution Maven avec la phase "package" pour exporter en .jar Executer cette commande;
 deux fichiers .jar sont crées dans un nouveau dossier target Ampoule-0.0.1-SNAPSHOT-jar-with-dependencies.jar qui est le bon éxecutable
