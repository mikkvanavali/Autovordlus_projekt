# Autovordlus_projekt
 
Rühmatöö Autovõrdlus

Rühmatöö tulemusena valmib rakendus, mis võimaldab võrrelda erinevat tüüpi automarke ja erinevaid automudeleid nende kasutuskulude alusel. 
Arvesse võetakse sõidukite soetushinda, elektri- või kütusekulu, sõiduulatust, laadimiseks kuluvat aega ja teisi parameetreid. 
Kas elektriauto ostmine tasub ennast rahalises mõttes ära võrreldes bensiini- või diiselautoga? 
Kui palju kulub elektriautoga rohkem aega läbimaks teatud pikkusega vahemaa võrreldes sisepõlemismootoriga autoga, kui sõidetakse sama keskmise kiirusega? 
Rakendus võimaldab võrrelda nii erinevaid autotüüpe (Diisel- Bensiini- ja elektriauto) kui ka sama tüüpi autosid omavahel
Kasutaja saab anda sisendparameetrid  kütuse, elektrikuulu, nende hind, auto soetamismaksumus, sõiduulatus jne. 
Programm arvutab välja, milline on 100 km sõidukulu, valitud teekonna sõidukulu, kogukulu perioodi vältel arvestades soetamismaksumust ja liisingutingimusi.
MVP-s ei arvestata kasutuskulusid nagu hooldus, varuosad jne.  
Rakendus on edasiarendatav, see tähendab, et tulevikus saab lisada uusi parameetreid ja võrdluskriteeriume.
Programm koosneb klassist Auto ja selle alamklassidest:

•	Bensiiniauto

•	Diiselauto

•	Elektriauto

Klassides on konstruktorid, mis võimaldavad autode erinevaid parameetreid väärtustada, get-ja set meetodid ning meetodid, millega erinevaid autosid võrreldakse. 
Samuti klassist Jaam ja selle alamklassidest:

•	Elektrijaam

•	Bensiinijaam

•	Diislijaam

, kus saab määrata sõidukite liigutamiseks kasutatavate energiaallikate hinda.
Peaklassis saab  väärtustada testitavate sõidukite parameetrid, periood, liisingutingimused,  võrdluskriteeriumid ja kuvada võrdluse tulemused. 
