# Autovordlus_projekt
 
OOP Rühmatöö: Autovõrdluse rakendus

Autorid:
Artur Aleksander Kanošin
Margus Paas

Rühmatöö tulemusena valmib rakendus, mis võimaldab võrrelda erinevat tüüpi automarke ja erinevaid automudeleid nende kasutuskulude alusel, aitamaks autoostu otsust langetada. 
Arvesse võetakse sõidukite soetushinda, liisingutingimusi, elektri- või kütusekulu, sõiduulatust, laadimiseks kuluvat aega ja teisi parameetreid. 
Rakenduse eesmärgiks on MVP tasemel aidata leida vastuseid küsimustele:
•	Kas elektriauto soetamine ja pidamine tasub ennast rahalises mõttes ära võrreldes bensiini- või diiselautoga? 
•	Kui palju kulub elektriautoga rohkem aega läbimaks teatud pikkusega vahemaa võrreldes sisepõlemismootoriga autoga, kui sõidetakse sama keskmise kiirusega? 
•	Millised autod on teistest keskkonnasäästlikumad
MVP-s ei arvestata kasutuskulusid nagu hooldus, varuosad jne.  
Rakendus võimaldab võrrelda nii erinevaid autotüüpe (diisel-, bensiini- ja elektriauto) kui ka sama tüüpi autosid omavahel. 
Kõigepealt küsitakse kasutajalt, kas ta soovib lisada võrdlusse uue auto:
 
Seejärel avaneb dialoogiaken, kus on võimalik valida, mis tüüpi auto soovitakse lisada.
 
Seejärel avanevas aknas saab sisestada andmed konkreetsetse auto kohta.
 
Andmete küsimist jätkatakse, kuni kasutaja ei soovi enam autosid lisada.
Kuigi peaklassis on eelnevalt juba kütuse-ja elektrihinnad vaikimisi määratud, küsitakse kasutajalt, kas ta soovib neid uuendada.
 
Jaatava vastuse korral avaneb dialoogiaken, kus kasutaja saab lisada uued energiahinnad.
 
Liisingutingimused, auto kasutusperiood, aastane läbisõit ja valitud teekonna pikkus on MVP-s eelnevalt väärtustatud. Soovi korral saab kasutaja neid peaklassis ise muuta.
 
Peaklassis on määratud ka kütuse CO2 jalajälg vastavalt kütuse- või energiatüübile. Väärtused on eksperimentaalsed ja neid saab kogenud kasutaja soovi korral muuta.
Peaklassis on juba määratud 3 näidisautot, millega saab ülejäänud sisestatud autosid võrrelda. Soovi korral võib kasutaja need näidisautod välja kommenteerida.
Programm arvutab välja, milline on 100 km sõidukulu, valitud teekonna sõidukulu, kogukulu perioodi vältel arvestades soetamismaksumust ja liisingutingimusi, kolm kõige keskkonnasäästlikumat autot ning tagastab autode andmed.
Programmi ülesehitus
Programm koosneb klassist Auto ja selle alamklassidest:
•	Bensiiniauto
•	Diiselauto
•	Elektriauto
Klassides on konstruktorid, mis võimaldavad autode erinevaid parameetreid väärtustada, get-ja set meetodid ning meetodid, millega erinevaid autosid võrreldakse. 
Klassis Auto määratakse autode isendiväljad: mark, mudel, ostuhind, energiakulu (vastavalt tüübile kas kütuse- või energiakulu 100 km. läbimiseks), 
Samuti on rakenduses klass Jaam selle alamklassid, mis , tarnivad autode jaoks vajalikku energiat:
•	Elektrijaam
•	Bensiinijaam
•	Diislijaam
Neis saab määrata sõidukite liigutamiseks kasutatavate energiaallikate hinda ja ökoloogilist jalajälge.
Klassis AutodeVõrdleja toimub autode võrdlemine meetodite kasutuskulu, kolm kiireimat liikujat, ja kolm kiireimat autot. Samuti on klassis meetod autode andmete väljastamise kohta.
Peaklassi käivitamisel saab lisada võrdlusse autod, täpsustada kütusehinnad ja väljastatakse konsooliaknas autode võrdluse tulemused.
Rakendus on edasiarendatav, see tähendab, et tulevikus saab lisada uusi parameetreid ja võrdluskriteeriume. Rühmatöö teises etapis on plaanis lisada rakendusele rohkem võimalusi ja funktsionaalsust, lisades kasutuskuludele ka võimalikud hooldus- ja remondikulud, amortisatsioon ja lisada graafiline kasutajaliides.
Projekti tegemise protsessi kirjeldus
Projekti loomine algas ideest, selle aluseks sai ühes praktikumis olnud kodutöö Elektriauto ja tekkis mõte seda edasi arendada, kuna idee võib eduka realiseerimise korral kasutust leida.
Seejärel sündis projekti spetsifikatsioon, klasside ja meetodite kirjeldus. Seejärel alamklasside loomine, meetodite loomine ning andmete sisestamiseks algse kasutajaliidese tegemine.
Margus: Idee, dokumentatsioon, klassid Auto, Jaam, meetodid autode võrdlemiseks, peaklassis osa, mis puudutab autode andmete väljastamist.
Artur Aleksander: Alamklassid, kasutajaliides, meetodite rakendamine – ühesõnaga suurem osa kodeerimistööst.
Lisada tuleks liisingutingimuste , kasutusperioodi ja teekonna pikkuse sisestamine.
Testimine toimus jooksvalt, vastavalt uute funktsionaalsuste lisandumisele.
Tulemus sai tegelikult päris hea ja sportlikku hasarti tekitav. Siit on võimalik tekitada täiesti korralik reaalne rakendus, millest võib autoostjatele abi olla.
Peamiseks probleemiks jäi ikkagi ajanappus. Projekti kirjeldus ja peamised klassid olid Githubis ammu üleval, aga muude kohustustetõttu ei olnud kummalgi aega tegelda ja lõpuks valmis kõik viimasel minutil, mistõttu võiks olla rohkem viimistletud ja läbi mõeldud. Aga kuna on tegemist MVP-ga, siis püüame seda teises etapis parandada.

