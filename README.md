# PROGETTO DI OOP
Applicazione in JAVA con SpringBoot per recuperare informazioni ed effettuare statistiche sulla Serie A
**********

# Introduzione 
Il progetto è una applicazione completamente in Java che utilizza le API fornite da [Football-data.org](https://www.football-data.org) \
per scaricare (in formato JSON) informazioni sul campionato italiano, le sue squadre e i suoi marcatori,\
ed effettuare statistiche e filtri.

## Indice
1. Glossario
1. Installazione
1. Utilizzo
1. Diagrammi UML
1. Utilizzo
	1. Rotte
	1. Statistiche
	1. Filtri
1. Esempi
1. JavaDoc
1. Test

***
# 1. Glossario
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
# 2. Installazione
Per installare il programma nel proprio dispositivo è sufficiente lanciare da console il seguente comando
```
$ git clone https://github.com/leonardoman9/programmoggetti
```
o, alternativamente, scaricare la repository github manualmente.

Poi, aprire il progetto con Eclipse o con un qualsiasi IDE, e aprire come Spring Boot Application la classe DemoSpringBootApplication

# 3. UML
## Diagramma delle classi

## Diagramma dei casi d'uso

## Diagramma delle sequenze

# 4. Funzionamento
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


# 5. Utilizzo
Una volta avviata l'applicazione, ad ogni diversa rotta corrisponde una statistica o un filtro, o una richiesta da visualizzare a video.    
Inoltre, nella root del progetto, è disponibile una Collection Postman contenente tutte le richieste che è possibile effettuare. \
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

# 6. Esempi

