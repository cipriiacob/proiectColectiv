# proiectColectiv

deschizi cmd, navighezi in folderul proiectului

pentru a rula serverul: 'mvn spring-boot:run'

fiecare isi creeaza o baza de date cu numele 'proiect_colectiv'
ca si credentiale, sa aveti username 'root' si parola '1234'

pentru a crea tabelele bazei de date: 'mvn liquibase:update'
pentru a sterge tabelele bazei de date: 'mvn liquibase:dropAll'



### Frontend
npm install
cd frontend
node server.js        -start server
Access localhost:8080 on web client
