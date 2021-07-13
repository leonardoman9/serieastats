# PROGETTO DI OOP
Applicazione in JAVA con SpringBoot per recuperare informazioni ed effettuare statistiche sulla Serie A
**********

# Introduzione 
Il progetto è una applicazione completamente in Java che utilizza le API fornite da [Football-data.org](https://www.football-data.org) \
per scaricare (in formato JSON) informazioni sul campionato italiano, le sue squadre e i suoi marcatori,\
ed effettuare statistiche e filtri.

## Indice
1. [Glossario](#glossario)
1. [Installazione](#installazione)
1. [Diagrammi UML](#UML)
1. [Funzionamento](#funzionamento)
1. [Struttura](#struttura)
1. [Utilizzo](#utilizzo)
	1. [Rotte](#rotte)
	1. [Statistiche](#statistiche)
	1. [Filtri](#filtri)
1. [Esempi](#esempi)
1. [JavaDoc](#esempi)
1. [Test](#esempi)
1. [Software e Risorse utilizzate](#software-e-risorse-utilizzate)
1. [Sviluppatori](#sviluppatori)

***
# Glossario
| Termine utilizzato  | Significato |
| ------------- |:-------------:|
| Competition         | Evento calcistico composto da più partite nella sua                         definizione più generale (Capmionato, Coppe, ecc                           ...)    |
| League      | Tipo di Competition, caratterizzato da un numero                           predefinito di partite (giornate), giocato da un numero di                 Team che non possono essere squalificati     |
| Area      | Luogo geografico di svolgimento di una Competition    |
| Team      | Insieme di Players, fa parte di una League e compete con altri Team, ha varie caratteristiche come nome lungo, nome corto,  ID, nome abbreviato, Url del logo societario, numero di telefono, indirizzo email, indirizzo web, indirizzo stradale della sede, anno di fondazione, colori societari. |
|Season | Rappresenta l'intervallo temporale in cui si svolge una                      Competition, e la squadra vincente di quella edizione di Competition (se esiste)
|WinnerTeam | Team che ha vinto l'ultima Season di una Competition|
|Player     | Componente di una squadra, ha varie caratteristiche come nome, cognome, nome completo, data di nascita, nazionalità, posizione.|
|Scorer     | Sottoclasse di player, rappresenta un player che ha segnato almeno un gol
|Position   | Ruolo di un giocatore (Attacker, Midfielder, Defender o Goalkeeper)|
|Nazionalità | L'appartenenza a una nazione come entità etnica |
|Venue      | Luogo di svolgimento delle partite "in casa" di un Team (stadio)|
|Short Name | Il nome di una squadra "corto" (esempio: "Inter") | 
| Long Name | Il nome di una squadra "lungo" (esempio: "FC Internazionale Milano)|

# Installazione
1. Clonare il repository (o scaricare e scompattare lo zip)
```
$ git clone https://github.com/leonardoman9/programmoggetti
```
1. Importare il progetto con Eclipse/IntelliJ
> File --> Import --> Existing Maven Project
>
1.Avviare DemoSpringBootActivationApplication.java come Spring Boot App

1. Eseguire le richieste sotto elencate  all'indirizzo http://localhost:8080.

# 3. UML
## Diagramma delle classi

## Diagramma dei casi d'uso

## Diagramma delle sequenze

# Funzionamento
Il programma, per prima, cosa effettua un download delle risorse necessarie tramite richieste `GET`:
* Vengono effettuate richieste alle API per ottenere dei JSON contenenti informazioni riguardanti la "League" Serie A e gli "Scorers" della serie A:\
Dato l'url dell'API a cui effettuare la richiesta, tramite la classe `Dataset` si effettua il download in formato .json.\
Queste due richieste sono effettuate ogni volta che l'applicazione viene lanciata, così da avere ogni volta un dataset \
aggiornato su cui poi applicare statistiche e filtri.
* L'applicazione effettua una connessione col server utilizzando la nostra auth-key gratuita: \
Ciò comporta delle limitazioni nel DataSet: utilizzando un account gratuito, non è possibile \
avere alcuni dati necessari per le specifiche del progetto (tutti i player di un team): per ovviare \
a questo problema, abbiamo effettuato le statistiche e i filtri non su i Player, ma sugli Scorer, \
che invece venivano forniti integralmente nonostante la nostra autenticazione gratuita.
* Le string JSON recuperate dalle API vengono salvati in due file `league.json` e `scorers.json`, \
presenti nella directory `src/main/resources/data/` dell'applicazione.
* Successivamente vengono parsati i due file json in due classi
opportunamente create \
per memorizzare i dati e lavorarci in modo più semplice e efficiente.
* Il risultato dell'avvio del programma saranno quindi due file: 
    1. `league.json`, che contiene informazioni sulla League Serie A e un array di Team partecipanti;
    1. `scorers.json`, che contiene informazioni su tutti i marcatori della Serie A
* Una volta ottenuti i due json, inizia l'effettiva interazione dell'utente con l'applicazione, che, \
tramite applicazioni come Postman che permettono di effettuare chiamate API (o comuni browser), può \
seguire una delle rotte predefinite, visualizzabili più avanti in questo Readme (o nella documentazione Javadoc).
* Le richieste effettuabili sono contenute nelle classi del package Requests, divise tra Requests, Stat e Filters.

# Struttura

1. **Main**
    1. **Main**: L'entry point dell'applicazione
1. **Controller**
    1. **SimpleRestController**: Controller dell'applicazione, contiene le funzioni che gestiscono le rotte dell'applicazione.
1. **Model**
    1. **Competition**: Classe per mappare  le informazioni di una Competition
    1. **Area**: Classe per rappresentare la zona dove si svolge una Competition
    1. **Season**: Classe per rappresentare la durata temporale di una Competition
    1. **Team**: Classe per rappresentare un partecipante di una Competition
    1. **League**: Classe per mappare le informazioni di una League
    1. **DateOfBirth**: Classe per rappresentare una data di nascita e convertire date di nascita da Stringhe a oggetti DateOfBirth
    1. **Player**: Classe per rappresentare un elemento di un Team
    1. **Scorer**: Sottoclasse di Player, che abbia effettuato almeno un goal
    1. **Scorers**: Classe che rappresenta tutti gli scorers di una League
    1. **WinnerTeam**: Sottoclasse di Team, che ha vinto una Competition
1.**Requests**
    1. **Directories**: Interfaccia per memorizzare le directories dove salvare i .json scaricati
    1. **Requests**: Classe che implementa Directories, utilizzata per effettuare il download delle risorse richieste e ritornare un oggetto League o Scorers
    1. **Stat**: Classe per effettuare statistiche sulle risorse scaricate
    1. **Filters**: Classe per effettuare filtri sulle risorse scaricate
1. **Utilities**
    1. **Dataset**: Dato un url, ritorna in una stringa il contenuto in esso memorizzato
    1. **JsonParser**: Data la directory della risorsa scaricata, ritorna un oggetto deserializzato dei tipo League, Scorers o Team.
    1. **UrlConnection**: Dato un url, apre una connessione utilizzando un token di autenticazione predefinito
    1. **FileInputOutput**: Classe per gestire la lettura e la scrittura di/in file, nelle directory indicate dall'interfaccia Directories.
    1. **AgeCalculator**: Classe per passare da una stringa nel formato "yyyy-MM-dd" ad un oggetto DateOfBirth
    1. **Nationalities**: Classe che contiene memorizzate tutte le nazionalità, per effettuare controlli e verificare che una nazionalità inserita dall'utente sia effettivamente esistente.
    1. **Positions**: Classe che contiene memorizzati tutti i ruoli, per effettuare controlli e verificare che una posizione inserita dall'utente sia effettivamente esistente
1. **Exceptions**
    1. **MissingTeamException**: Eccezione per gestire l'assenza di una squadra ricercata o l'errato inserimento del nome di una squadra
    1. **MissingNationalityException**: Eccezione lanciata nel caso in cui l'utente faccia una richiesta contenente una nazionalità inesistente.


# Utilizzo
Una volta avviata l'applicazione, ad ogni diversa rotta corrisponde una statistica o un filtro, o una richiesta da visualizzare a video.    
Inoltre, nella root del progetto, è disponibile una Collection Postman contenente tutte le richieste che è possibile effettuare. 
<p>
  <img src="https://github.com/leonardoman9/programmoggetti/blob/master/src/main/resources/images/postmancollection.png?raw=true">
    <h6 align="center">
        La collection di Postman utilizzabile per effettuare richieste
      </h6>
  </img>
</p>

Le richieste vanno effettuate all'indirizzo  `localhost:8080` alla rotta desiderata. Tutte le richieste sono di tipo `GET`.
## Rotte
In questo caso, il tipo di ritorno sarà un Oggetto diverso da una Stringa.

| Rotta | Parametri | Output|
|-------|-----------|:-------:|
|`/league`   |    `?showTeams=true` o  `?showTeams=false`| Mostra informazioni riguardanti la Serie A, `showTeams=true` per mostrare anche le squadre, `?showTeams=false` altrimenti.|
`/leagueScorers` | Nessuno | Mostra tutti i marcatori della Serie A|
|`/team` | `?name={name}` | Mostra informazioni riguardo alla squadra indicata (utilizzare lo short name)
## Statistiche

In questo caso, il tipo di ritorno sarà una Stringa.

| Rotta | Parametri | Output |
|-------|-----------|:------:|
|`/venues`|Nessuno | Mostra i nomi degli stadi delle partite di Serie A.|
|`/teamsForEachVenue` | Nessuno| Mostra tutti gli stadi e il numero di squadra che giocano in ognuno di essi le partite "in casa"|
|`/foundedAfter`|`?year={year}` | Mostra tutte le squadre fondate dopo un certo anno |
|`/teamScorers` | `?team={longName}` | Mostra tutti i marcatori di una certa squadra |
|`/teamNationalities` | `?team={longName}` | Mostra tutte le nazionalità di cui fanno parte i marcatori di una squadra |
|`/countNationalities` | `?team={longName}` | Conta tutte le nazionalità di cui fanno parte i marcatori di una squadra |
|`/youngScorers` | `?team={longName}` | Mostra tutti i marcatori di una squadra con età minore di 28 anni |

## Filtri

In questo caso, il tipo di ritorno sarà una Stringa.

| Rotta | Parametri | Output |
|-------|-----------|:------:|
|`/startsWith` | `?letter={letter}` | Mostra tutte le squadre il cui nome completo inizia per una certa lettera |
|`/foundedIn` | `?year={year}` | Mostra tutte le squadre fondate in un certo anno |
|`/nationalitiesForTeam` | `?team={longName}&?nationality={nationality}` | Mostra tutti i giocatori di una o più nazionalità di una squadra, a scelta dell'utente. |
|`/scorersForPosition` | `?team={longName}&?position={position}` | Mostra tutti i marcatori di un ruolo di una squadra a scelta dell'utente|

# Esempi
<h6>Richiesta /league </h6>

```
{
   "count":20,
   "filters":{
      
   },
   "competition":{
      "id":2019,
      "area":{
         "id":2114,
         "name":"Italy"
      },
      "name":"Serie A",
      "code":"SA",
      "plan":"TIER_ONE",
      "lastUpdated":"2021-04-17T07:19:44Z"
   },
   "season":{
      "id":638,
      "startDate":"2020-09-20",
      "endDate":"2021-05-23",
      "currentMatchday":38,
      "winner":{
         "id":108,
         "name":"FC Internazionale Milano",
         "shortName":"Inter",
         "tla":"INT",
         "crestUrl":"https://crests.football-data.org/108.svg"
      }
   },
   "teams":[
      {
         "id":98,
         "area":{
            "id":2114,
            "name":"Italy"
         },
         "name":"AC Milan",
         "shortName":"Milan",
         "tla":"MIL",
         "crestUrl":"https://crests.football-data.org/98.svg",
         "address":"Via Filippo Turati 3 Milano 20121",
         "phone":"+39 (02) 62281",
         "website":"http://www.acmilan.com",
         "email":null,
         "founded":1899,
         "clubColors":"Red / Black",
         "venue":"Stadio Giuseppe Meazza",
         "lastUpdated":"2020-11-26T02:19:28Z"
      },
      {
         "id":99,
         "area":{
            "id":2114,
            "name":"Italy"
         },
         "name":"ACF Fiorentina",
         "shortName":"Fiorentina",
         "tla":"FIO",
         "crestUrl":"https://crests.football-data.org/99.svg",
         "address":"Viale Manfredo Fanti 4 Firenze 50137",
         "phone":"+39 (055) 5030190",
         "website":"http://www.acffiorentina.it",
         "email":"segreteria@acffiorentina.it",
         "founded":1926,
         "clubColors":"Purple / White",
         "venue":"Stadio Artemio Franchi",
         "lastUpdated":"2020-11-26T02:23:02Z"
      },
      {
         "id":100,
         "area":{
            "id":2114,
            "name":"Italy"
         },
         "name":"AS Roma",
         "shortName":"Roma",
         "tla":"ROM",
         "crestUrl":"https://crests.football-data.org/100.svg",
         "address":"Via di Trigoria km. 3,600 Roma 00128",
         "phone":"+39 (06) 501911",
         "website":"http://www.asroma.it",
         "email":"info@asromaweb.com",
         "founded":1927,
         "clubColors":"Maroon / Orange / White",
         "venue":"Stadio Olimpico",
         "lastUpdated":"2021-04-08T22:27:08Z"
      },
     ... Eccetera per tutte le 20 squadre
   ]
}
```
<h6>Richiesta /leagueScorers </h6>

```
{
   "count":285,
   "filters":{
      "limit":285
   },
   "competition":{
      "id":2019,
      "area":{
         "id":2114,
         "name":"Italy"
      },
      "name":"Serie A",
      "code":"SA",
      "plan":"TIER_ONE",
      "lastUpdated":"2021-04-17T07:19:44Z"
   },
   "season":{
      "id":638,
      "startDate":"2020-09-20",
      "endDate":"2021-05-23",
      "currentMatchday":38,
      "winner":{
         "id":108,
         "name":"FC Internazionale Milano",
         "shortName":"Inter",
         "tla":"INT",
         "crestUrl":"https://crests.football-data.org/108.svg"
      }
   },
   "scorers":[
      {
         "player":{
            "id":44,
            "name":"Cristiano Ronaldo",
            "firstName":"Cristiano Ronaldo",
            "lastName":null,
            "dateOfBirth":"1985-02-05",
            "countryOfBirth":"Portugal",
            "nationality":"Portugal",
            "position":"Attacker",
            "shirtNumber":null,
            "lastUpdated":"2021-05-26T09:46:02Z"
         },
         "team":{
            "id":109,
            "name":"Juventus FC"
         },
         "numberOfGoals":29
      },
      {
         "player":{
            "id":3662,
            "name":"Romelu Lukaku",
            "firstName":"Romelu",
            "lastName":null,
            "dateOfBirth":"1993-05-13",
            "countryOfBirth":"Belgium",
            "nationality":"Belgium",
            "position":"Attacker",
            "shirtNumber":null,
            "lastUpdated":"2020-11-26T02:19:38Z"
         },
         "team":{
            "id":108,
            "name":"FC Internazionale Milano"
         },
         "numberOfGoals":24
      },
      {
         "player":{
            "id":57,
            "name":"Luis Muriel",
            "firstName":"Luis Fernando",
            "lastName":null,
            "dateOfBirth":"1991-04-16",
            "countryOfBirth":"Colombia",
            "nationality":"Colombia",
            "position":"Attacker",
            "shirtNumber":null,
            "lastUpdated":"2020-09-07T21:10:15Z"
         },
         "team":{
            "id":102,
            "name":"Atalanta BC"
         },
         "numberOfGoals":22
      },
      {
         "player":{
            "id":82002,
            "name":"Dušan Vlahović",
            "firstName":"Dušan",
            "lastName":null,
            "dateOfBirth":"2000-01-28",
            "countryOfBirth":"Serbia",
            "nationality":"Serbia",
            "position":"Attacker",
            "shirtNumber":null,
            "lastUpdated":"2020-09-07T21:10:05Z"
         },
         "team":{
            "id":99,
            "name":"ACF Fiorentina"
         },
         "numberOfGoals":21
      },
      eccetera con tutti i marcatori
   ]
}



```




<p>
  <img src="https://github.com/leonardoman9/programmoggetti/blob/master/src/main/resources/images/leagueexample.png?raw=true">
    <h6 align="center">
        Esempio di richiesta /league
      </h6>
  </img>
</p>

 
<p>
  <img src="https://github.com/leonardoman9/programmoggetti/blob/master/src/main/resources/images/foundedinexample.png?raw=true">
    <h6 align="center">
       Esempio di statistica /foundedIn?year=1904
      </h6>
  </img>
</p><p>
  <img src="https://github.com/leonardoman9/programmoggetti/blob/master/src/main/resources/images/teamscorersexample.png?raw=true">
    <h6 align="center">
        Esempio di filtro /teamScorers?team=FC Crotone
      </h6>
  </img>
</p>

# JavaDoc

# Test

# Software e Risorse Utilizzate
* [Eclipse IDE](https://www.eclipse.org/ide/): Ambiente di Sviluppo
* [Spring Boot](https://spring.io/projects/spring-boot): Framework per lo sviluppo di applicazioni Web in Java
* [Postman](https://www.postman.com): Software di sviluppo API, permette di testare, modificare e costruire API, realizzando richieste con diversi metodi, header, autenticazioni, eccetera. 
* [Maven](https://maven.apache.org): Framework di gestione di progetti software basati su Java, permette di controllare librerie Java e plug-in Maven dai vari repository definiti scaricandoli in locale o in un repository centralizzato lato sviluppo.
* [JUNIT 5](https://junit.org/junit5/docs/current/user-guide/): Framework di unit testing per il linguaggio di programmazione Java.
* [JavaDoc](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html): Strumento utilizzato per la generazione automatica di documentazione di codice sorgente JAVA.

Documentazione:
* [Documentazione Java](https://docs.oracle.com/en/java/)
* [Documentazione Spring Boot](https://docs.spring.io/spring-framework/docs/current/reference/html/) 

# Sviluppatori
| Nome | Matricola | Contributo |
|-------|-----------|:------:|
|Leonardo Mannini | 1090620 | 50% |
|Luca Ranucci | 1089277 | 50% |