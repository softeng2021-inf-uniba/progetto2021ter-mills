# Relazione tecnica finale

 Indice
---
<br/>

1. [Introduzione](#Introduzione)
2. [Modello di dominio](#Modello-di-dominio)
3. [Requisiti specifici](#Requisiti-specifici)
    * [Requisiti funzionali](#requisiti-funzionali)
    * [Requisiti non funzionali](#requisiti-non-funzionali)
4. [System Design](#System-Design)
    * [Stile architetturale adottato](#Stile-architetturale-adottato)
    * [Commento delle decisioni prese]
5. [OO Design]
    * [Diagramma delle classi e diagramma di sequenza]
    * [Design pattern utilizzati]
    * [Commento delle decisioni prese]
6. [Riepilogo test]
7. [Manuale utente](#Manuale-utente)
8. [Processo di sviluppo e organizzazione del lavoro](#Processo-di-sviluppo-e-organizzazione-del-lavoro)
9. [Analisi retrospettiva](#Analisi-retrospettiva)
    * [Cosa ci ha resi soddisfatti](#Cosa-ci-ha-resi-soddisfatti)
    * [Cosa ci ha resi insoddisfatti](#Cosa-ci-ha-resi-insoddisfatti)
    * [Cosa ci ha fatto impazzire](#Cosa-ci-ha-fatto-impazzire)
10. [Conclusione](#Conclusione)

<br/><br/>

##  **Introduzione**

Questo documento ha il compito di illustrare l’utilizzo della prima versione dell’applicazione della **Dama Italiana**.
Il programma consente a due giocatori di sfidarsi in una partita tramite interfaccia a [linea di comando(CLI)](https://devindev.lidialab.it/cli-command-line-interface-o-command-line-interpreter/), indicando le proprie mosse in notazione algebrica. L'esecuzione del progetto

L'applicativo software, oggetto del documento, è stato sviluppato dal gruppo **mills**, il cui nome si riferisce al grande ingegnere del software Harlan D. Mills. Il gruppo mills è composto da:

* [Riccardo Ranieri](https://github.com/RickNewere)
* [Giorgio Grimaldi](https://github.com/GiorgioGrimaldi)
* [Giuliano Picilli](https://github.com/Giuly123)
* [Fabio Spaccavento](https://github.com/fabiospaccavento)
* [Daniele Saccà](https://github.com/danielesacca)

L'applicazione della Dama Italiana è eseguita tramite [Docker](https://hub.docker.com/).

<br/>

##  **Modello di dominio**

//TODO

<br/>

##  **Requisiti specifici**

Di seguito l'elenco dei requisiti specifici ( funzionali e non funzionali)

<br/>

## **Requisiti funzionali**

<center><img src = "../res/img/report-finale/schermataIniziale.png"></center>

L'applicazione, una volta avviata, risponde ai seguente requisiti:

* L'utente può visualizzare i comandi disponibili tramite il comando ```help```.
<center><img src = "../res/img/report-finale/helpCommand.PNG"></center>

* L'utente può iniziare una nuova partita tramite il comando ```gioca```.
<center><img src = "../res/img/report-finale/giocaInizio.PNG"></center>

* L'utente può abbandonare una partita già cominciata tramite il comando ```abbandona```.
<center><img src = "../res/img/report-finale/abbandonaConferma.PNG"></center>

* L'utente può chiudere il programma, previa conferma, tramite il comando ```esci```.
<center><img src = "../res/img/report-finale/esci.PNG"></center>

* L'utente può vedere la damiera numerata tramite il comando ```numeri```.
<center><img src = "../res/img/report-finale/numeri.PNG"></center>

* L'utente può vedere la damiera con le pedine tramite il comando ```damiera```.
<center><img src = "../res/img/report-finale/dam.PNG"></center>

* L'utente può vedere il tempo trascorso, dall'inizio della partita, per entrambi i giocatori tramite il comando ```tempo```.
<center><img src = "../res/img/report-finale/tempo.PNG"></center>

* L'utente può visionare lo storico di pedine prese di entrambi i giocatori tramite il comando ```prese```.
<center><img src = "../res/img/report-finale/prese.PNG"></center>

* L'utente può visionare lo storico delle mosse eseguite di entrambi i giocatori tramite il comando ```mosse```.
<center><img src = "../res/img/report-finale/mosse.PNG"></center>

<br/>

## **Requisiti non funzionali**

**Portabilità**

Il deployment dell'applicazione è automatizzato grazie a [Docker](https://hub.docker.com/) basato su [Alpine Linux](https://hub.docker.com/_/alpine). Tramite esso è possibile utiilizzare l'applicazione sulle sueguenti **shell**:

*  **Windows**: [Windows Subsystem for Linux (WSL)](https://docs.microsoft.com/it-it/windows/wsl/about), [Git Bash](https://gitforwindows.org/), [Windows Terminal](https://docs.microsoft.com/it-it/windows/terminal/get-started);
* **MacOS** e **Linux**: qualunque terminale con supporto a UTF-8.

* Il progetto deve essere scaricato tramite
  [Docker](https://hub.docker.com/) con il comando da shell: <center>

  ```docker pull docker.pkg.github.com/softeng2021-inf-uniba/progetto2021ter-mills/dama-mills:latest``` </center>

* Il progetto deve essere eseguito tramite [Docker](https://hub.docker.com/) con il comando da shell: <center>

  ```docker run --rm -it docker.pkg.github.com/softeng2021-inf-uniba/progetto2021ter-mills/dama-mills:latest```</center>

**Affidabilità**

L'applicazione non genera eccezioni. Queste vengono tutte catturate e gestite. Eventualmente, vengono stampati messaggi di errore.

## **System Design**

Di seguito viene riportato lo *Stile architetturale adottato* e il *Commento delle decisioni prese*.

## **Stile architetturale adottato**

Il programma, non essendo molto complesso, non è stato sviluppato con uno stile architetturale predefinito. Tuttavia si possono trovare alcuni punti in comune con il pattern architetturale [MVC](https://it.wikipedia.org/wiki/Model-view-controller) (Model - View - Controller).

L'applicazione è suddivisa secondo la seguente logica:

*
*
*
//TODO




## **Manuale utente**

L'applicazione 'Dama Italiana' mira a ricreare l'esperienza dell'omonimo gioco da tavolo, caratterizzata dalla simulazione su terminale della damiera e di tutti i suoi pezzi.

Per lanciare l'applicazione, una volta [scaricata](#Requisiti-non-funzionali), è possibile eseguirla tramite il comando:<center>

```docker run --rm -it docker.pkg.github.com/softeng2021-inf-uniba/progetto2021ter-mills/dama-mills:latest```
 </center>

 <br/>

Quando il programma sarà avviato verrà visualizzato il messaggio:<center>

```"⛃ Benvenuto  nella Dama  Italiana ⛃" ```

```"Digitare un comando o scrivere 'help' per visualizzare la lista dei comandi disponibili"```</center>

<br/>

Se avviato correttammente da questo momento in poi si potranno inserire i seguenti comandi:

* ```help``` - comando che viene suggerito dal banner iniziale, e che se invocato mostra la lista dei comandi disponibili. Inoltre descrive la notazione algebrica utilizzata per eseguire le mosse.

<br/>

* ```gioca``` - comando utilizzato per iniziare una nuova partita. Se invocato a partita non incorso si predisporrà a ricevere mosse esibendo il messaggio:<center>

  ```"É il turno del giocatore bianco"```

  Se viene richiamato durante una partita in corso apparirà il seguente messaggio di errore:<center>

  ```"Questo comando può essere utilizzato solamente fuori dalla partita"```</center>

<br/>    

* ```abbandona``` - comando utilizzato per abbandonare una partita in corso. Se invocato durante una partita, il programma richiede una conferma [si/no] e in caso affermativo termina la partita dando la vittoria a tavolino al giocatore avversario. In caso negativo si ripredispone a ricevere comandi previo seguente messaggio: <center>

  ```"La partita continua..."```</center>

  Se invocato al di fuori di una partita apparirà un messaggio di errore e successivamente il suggerimento di iniziare una nuova partita. I messaggi sono i seguenti:<center>

  ```"Questo comando può essere utilizzato solamente durante la partita"```

  ```"Inserire comando 'gioca' per iniziare una nuova partita"```</center>

  Qualora non si inserisca nè 'si/Si/sI/SI', nè 'no/No/nO/NO' l'applicazione rimane in attesa di una risposta consona previo messaggio di errore:<center>

  ```"Risposta non permessa! Riprova con 'si' o 'no'"```</center>

<br/>

* ```esci``` - comando utilizzato per uscire dall'applicazione. Se invocato mentre non si è in partita, il programma richiede una conferma [si/no] e in caso affermativo l'applicazione si chiude restituendo uno zero exit code. In caso negativo si ripredispone a ricevere comandi previo seguente messaggio:<center>

  ```"Uscita non eseguita..."```</center>

  Se invocato durante una partita apparirà un messaggio di errore che recita:<center>

  ```"Questo comando può essere utilizzato solamente fuori dalla partita"```</center>

  Qualora non si inserisca nè 'si/Si/sI/SI', nè 'no/No/nO/NO' l'applicazione rimane in attesa di una risposta consona previo messaggio di errore:<center>

  ```"Risposta non permessa! Riprova con 'si' o 'no'"```</center>

<br/>

* ```numeri``` - comando utilizzato per mostrare la damiera numerata. Il comando può essere invocato sia durante una partita che non poichè mostra solamente i numeri (da 1 a 32), disposti sulla damiera.

    <center><img src = "../res/img/report-finale/num.PNG"></center>

<br/>

* ```damiera``` - comando utilizzato per mostrare la damiera con le pedine. Se utilizzato durante una partita mostra il posizionamento delle pedine in quel momento.

    <center><img src = "../res/img/report-finale/dam.PNG"></center>

  Se invocato al di fuori di una partita apparirà un messaggio di errore e successivamente il suggerimento di iniziare una nuova partita. I messaggi sono i seguenti:<center>

  ```"Questo comando può essere utilizzato solamente durante la partita"```

  ```"Inserire comando 'gioca' per iniziare una nuova partita"```</center>

<br/>

* ```tempo``` - comando utilizzato per mostrare il tempo trascorso per entrambi i giocatori. Comincerà a decorrere per il primo giocatore, nel nostro caso sempre il bianco, non appena verrà invocato il comando '*gioca*'. Non appena il bianco effettuerà una mossa ritenuta valida, finirà il suo turno ed inizierà quello del giocatore nero e anche il tempo del secondo giocatore comincerà a decorrere. Qualora si abbandoni una partita e si cominci una nuova, i due cronometri saranno azzerati e ripartiranno all'inizio del turno del primo giocatore. Se invocato al di fuori di una partita apparirà un messaggio di errore e successivamente il suggerimento di iniziare una nuova partita. I messaggi sono i seguenti:<center>

  ```"Questo comando può essere utilizzato solamente durante la partita"```

  ```"Inserire comando 'gioca' per iniziare una nuova partita"```</center>

<br/>

* ```prese``` - comando utilizzato per mostrare lo storico delle prese di entrambi i giocatori. Se invocato durante una partita mostra le pedine mangiate sia del bianco che del nero fino a quel momento. Se invocato al di fuori di una partita apparirà un messaggio di errore e successivamente il suggerimento di iniziare una nuova partita. I messaggi sono i seguenti:<center>

  ```"Questo comando può essere utilizzato solamente durante la partita"```

  ```"Inserire comando 'gioca' per iniziare una nuova partita"```</center>

<br/>

* ```mosse``` - comando utilizzato per mostrare lo storico delle mosse di entrambi i giocatori. Se invocato durante una partita mostra tutte le mosse fatte dai due giocatori in ordine cronologico. Se invocato al di fuori di una partita apparirà un messaggio di errore e successivamente il suggerimento di iniziare una nuova partita. I messaggi sono i seguenti:<center>

  ```"Questo comando può essere utilizzato solamente durante la partita"```

  ```"Inserire comando 'gioca' per iniziare una nuova partita"```</center>

  Se nessuna mossa è stata effettuata stamperà:<center>

  ```"Nessuna mossa effettuata"```</center>

<br/>

Una volta iniziata la partita tramite il comando '*gioca*' il programma si mette in attesa di una mossa del primo giocatore, nel nostro caso sempre il bianco. Se la mossa è corretta, viene eseguita e il turno viene aggiornato automaticamente. La mossa deve seguire la notazione algebrica:

<center><img src = "../res/img/report-finale/mosseDisp.PNG"></center>

<br/>

Per gli spostamenti semplici si deve seguire "l'Art 4 - Gli spostamenti semplici" del [regolamento](http://www.fid.it/regolamenti/capo1.htm). Per le prese, sia singole che multiple, si devono seguire "l'Art 5-6 - Le prese - Le regole di presa" dello stesso regolamento.

Inoltre:

* Per ogni spostamento eseguito correttamente secondo notazione prestabilita si visualizzerà: <center>

  ```Mossa eseguita```

  ```É il turno del giocatore [colore_avversario]```</center>

* Per ogni presa di una pedina eseguita correttamente secondo notazione prestabilita (indipendentemente se si tratti di presa multipla o semplice), si visualizzerà, oltre a quello già riportato sopra: <center>

  ```Presa effettuata```</center>

* In caso di damatura eseguita correttamente secondo notazione prestabilita (indipendentemente se sia stata raggiunta con una presa o con uno spostamento semplice), si visualizzerà, oltre quello già riportato in precedenza: <center>

  ```Damatura effettuata```</center>

    <br/>

In caso di mosse errate i messaggi visualizzati, a seconda dei casi, saranno i seguenti:

* Casella di arrivo già occupata: <center>

  ```"Errore, non puoi fare questo spostamento"```</center>

* Casella di arrivo inesistente: <center>

  ```"Errore: Hai inserito una posizione al di fuori della damiera"```</center>

* Provare a muovere un pedina avversaria nel proprio turno: <center>

  ```"Errore: Hai selezionato una pedina avversaria"```</center>

* Presa singola/multipla errata:<center>

  ```"Errore: non puoi effettuare questa presa"```</center>

* Provare a muovere una pedina da una posizione di partenza vuota:<center>

  ```"Hai selezionato una casella vuota"```</center>

<br/>

## **Processo di sviluppo e organizzazione del lavoro**

## Processo di sviluppo

Il programma è stato realizzato applicando la metodologia di [Sviluppo Agile](https://it.wikipedia.org/wiki/Metodologia_agile). Quest'ultima è caratterizzata da [Scrum](https://it.wikipedia.org/wiki/Scrum_(informatica)), un framework di processo che prevede di dividere il progetto in blocchi rapidi di lavoro denominati [Sprint](https://it.wikipedia.org/wiki/Scrum_(informatica)#Sprint), ognuno dei quali prevede un certo numero di funzionalità ([User Story](https://en.wikipedia.org/wiki/User_story)) richieste dal Product Owner. Tutte le user story sono contenute nella Product RoadMap del gruppo **mills** su [GitHub](https://github.com/).

<br/>

## **Suddivisione dei progetto**

Il progetto è stato diviso in quattro sprint. Dopo aver creato una **project board generale** che conteneva le user story e le sprint board, per ogni sprint:

* Veniva creato il **Milestone** corrispondente con gli obiettivi dello sprint

* Veniva creata una **project board** per lo sprint, che veniva suddivisa in cinque colonne ognuna delle quali indicava lo stato delle issue in quel momento. Gli stati sono:

    * **To Do**: nella quale si finivano le issue appena create;
    * **In Progress**: nella quale si trovavano le issue in elaborazione.
    * **Review**: nella quale si trovavano le issue pronte per essere revisionate;
    * **Ready**: nella quale si trovavano le issue chiuse e pronte per la revisione da parte dei docenti;
    * Done: nella quale si trovavano le issue chiuse e approovate dai docenti.

* Venivano aggiunte le user story dello sprint nello stato '*To Do*'.

* Ogni user story veniva assegnata:

    * a un partecipante in caso di user story poco complesse;

    * a più partecipanti in caso di user story più complesse così da fare pair programming.

* Ad ogni user story veniva assegnata una o più label, veniva messa in uno o più Project e assegnata ad un Milestone.

<br/>

## Suddivisione dei compiti

Ad ogni **[scrum meeting](https://www.agileway.it/il-daily-scrum-meeting/#:~:text=In%20quest'ultimo%20caso%2C%20lo,grafico%20prima%20di%20ogni%20meeting.)**, con cadenza settimanale, si è cercato di assegnare lo stesso numero di compiti da svolgere ad ogni singolo partecipante in modo da coinvolgere tutti ed essere quanto più equi possibile.

Per issue semplici, si è preferito assegnarle a singoli. Issue più o meno complesse venivano assegnate a coppie così da fare un lavoro di **[pair programming](https://it.wikipedia.org/wiki/Pair_programming)**. Le coppie variavano sempre in modo che tutti potessero lavorare con tutti, accrescendo così l'intesa del Team.

Il lavoro di revisione, tramite **[pull request](https://marcolombardo.com/blog/open/source/2019/03/13/iniziare-con-git-e-github-la-pull-request.html)**, veniva anch'esso diviso. Per issue semplici, si preferiva assegnare la revisione ad un solo membro, per issue più complessi anche a più di un membro.

<br/>

## Piattaforme di comunicazione

Per la comunicazione, il nostro gruppo, ha adottato due piattaforme:

* **[Discord](https://discord.com/brand-new)**
* **[Whatsapp](https://www.whatsapp.com/?lang=it)**

La prima è stata scelta poichè una piattaforma a tutti i membri del gruppo familiare, la quale permetteva di fare videoconferenze e di condividere lo schermo. Ciò è stato molto utile nel momento in cui uno o più membri hanno avuto difficoltà con particolari issue, che con l'aiuto di tutti, sono stati risolti in poco tempo.

<center><img src = "../res/img/report-finale/discord.jpeg"></center>

La seconda è stata scelta poichè, essendo anche questa familiare, era il mezzo di comunicazione più veloce in ogni momento. Tramite essa ci si confrontava durante le lezioni, si decidevano i giorni e gli orari per gli **scrum meeting** / **meeting di retrospettiva** e ci si teneva in contatto.

<center><img src = "../res/img/report-finale/whatsapp.jpeg"></center>

<br/>

## **Analisi retrospettiva**

A posteriori queste sono i risultati dell'analisi retrospettiva:

## **Cosa ci ha resi soddisfatti**

Il denominatore comune tra tutti i membri del gruppo è la consapevolezza di aver acquisito una minima capacità di lavorare in team. Questa simulazione di un'esperienza lavorativa è servita ad ognuno di noi per:

* Imparare il linguaggio java e il paradigma ad oggetti;

* Affinare ed acquisire *skill* di programmazione;

* Comprendere l'utilizzo di strumenti di version control come *Git e GitHub*;

* Comprendere l'utilizzo di strumenti di deployement automatizzato con *Docker*;

È stato molto interessante mettersi alla prova nei limiti di tempo dei vari sprint, per sentirsi poi soddisfatti quando al termine funzionava tutto.

Durante gli sprint, considerate le scarse conoscenze pregresse del linguaggio utilizzato, ci sono stati problemi durante gli sviluppi di alcune issue, ma grazie al lavoro di squadra non è stato difficile risolverli.

## **Cosa ci ha resi insoddisfatti**

La cosa che ha demoralizzato maggiormente è stata l'impossibilità di potersi incontrare giornalmente in università data la situazione **pandemica**. Infatti, almeno all'inizio, c'era quel velo di vergogna tra persone che non si erano mai viste. Ciò è sparito con il passare del tempo e le numerose call fatte. In particolare il rapporto si è consolidato nel mese di Maggio quando ci siamo incontrati per le prime volte in università.

## **Cosa ci ha fatto impazzire**

Come già scritto, la situazione pandemica ha costretto tutti noi a svolgere questo progetto a distanza.

A nome di tutto il gruppo ciò che ci ha fatto impazzire è stato il microfono e la connessione di **[Fabio Spaccavento](https://github.com/fabiospaccavento)** che ad ogni call non funzionava e noi ci divertivamo a prendere in giro.

## **Conclusione**

Scherzi a parte, riteniamo che questo progetto  sia stato un importante banco di prova. Nonostante le difficoltà siamo riusciti comunque a centrare gli obiettivi stabiliti e a trarre il meglio da questa esperienza formativa.

**Cosa più importante è stata l'amicizia nata tra membri del gruppo!**

<right> Lo staff, **mills**</right>