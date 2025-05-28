# Music Store - Sistem de gestiune

**Realizat de:** Dragomir Daria Nicoleta, grupa 252  
**Laborant:** Băicoianu Daniela  

## Descrierea aplicației

Aplicația Music Store este un sistem de gestiune pentru un magazin de produse muzicale. Scopul principal este de a permite administrarea eficientă a produselor (instrumente și accesorii), a comenzilor realizate de clienți, a facturilor emise, a recenziilor pentru produse și a relației cu furnizorii.

Aplicația este structurată modular, cu o separare clară între:
- Entități (ex: Client, Produs, Factură),
- Servicii (logica de business),
- Repository-uri (salvarea și citirea datelor din fișiere),
- Interfață interactivă prin consolă (prezentată în `Main.java`).

## Sistem de gestiune tip consolă pentru un magazin muzical

Mai precis, este o aplicație:
- **Desktop**, rulată din consolă (CLI – Command Line Interface),
- **Standalone** (nu depinde de internet sau servere externe),
- **CRUD-based** – adică permite:
  - Create (ex: adaugă client, produs, recenzie),
  - Read (ex: afișează comenzi, produse),
  - Update/Delete – (în unele servicii, deși nu toate sunt implementate explicit),
  - Persistă datele local, în fișiere (prin sistemul Repository).

## Tipuri de obiecte (entități)

1. **Client**  
   Reprezintă un utilizator al magazinului, care poate plasa comenzi și lăsa recenzii.  
   *Atribute tipice:* nume, prenume, email, telefon.

2. **Produs (abstract)**  
   Clasă de bază pentru toate tipurile de produse vândute în magazin.  
   *Atribute:* ID, denumire, preț, furnizor.  
   Este moștenită de:
   - **Instrument** – produse muzicale principale (ex: chitară, pian).
   - **Accesoriu** – produse auxiliare (ex: cabluri, huse).

3. **Comandă**  
   Reprezintă o achiziție făcută de un client.  
   Include o listă de produse.  
   Este asociată unui client.

4. **Factură**  
   Document care detaliază o comandă.  
   Conține: data emiterii, suma totală, clientul beneficiar, ID-ul comenzii.

5. **Furnizor**  
   Reprezintă sursa de aprovizionare a produselor.  
   Poate furniza mai multe produse.  
   *Atribute:* nume, adresă, cod fiscal etc.

6. **Recenzie**  
   Comentariu sau evaluare adăugată de un client pentru un produs cumpărat.  
   Conține: scor (rating), text descriptiv, referință la produs și la client.

## Alte tipuri de obiecte (logice/tehnice)

7. **Servicii (*Serviciu.java)**  
   Clase care implementează logica aplicației pentru fiecare entitate (ex: `ClientServiciu`, `ComandaServiciu`, `FacturaServiciu` etc.).

8. **Repository-uri (*Repository.java)**  
   Clase care gestionează salvarea și încărcarea datelor în/din fișiere pentru fiecare entitate.  
   Exemple: `ClientRepository`, `ProdusRepository`, `FacturaRepository`.

## Funcționalități principale

- Gestionarea clienților  
- Gestionarea furnizorilor  
- Gestionarea produselor  
- Plasarea comenzilor  
- Emiterea de facturi  
- Recenzii produse

## Ce poate face un utilizator

Un utilizator al aplicației (în special clientul, din perspectiva interacțiunii în `Main.java`) are acces la următoarele funcții:

### Prin meniul interactiv:

- **Adăugarea de entități**
- **Vizualizarea datelor:**
  - Clienți
  - Furnizori
  - Produse
  - Comenzi
  - Facturi
  - Recenzii

### Interacțiuni comerciale:

- Plasarea unei comenzi (clientul alege produsele)
- Generarea unei facturi pentru o comandă
- Adăugarea unei recenzii pentru un produs
- Sortare alfabetică a clienților
- Sortarea produselor crescător după preț
- Aplicarea promoției la comenzi
- Căutare comandă după ID
- Căutare produse după categorie
- Generare raport de vânzări pentru o anumită perioadă
- Filtrare produse cu preț cuprins într-un anumit interval
- Raport clienți fideli
- Grupare instrumente după brand
- Raport vânzări dintr-o anumită perioadă de timp
- Procesare comandă

### Persistența datelor:

La fiecare acțiune (ex: adăugare client, comandă, recenzie), datele sunt salvate prin sistemul de fișiere folosind clasele Repository, care scriu în fișiere text pentru a păstra starea aplicației.

## Structura interacțiunii

Aplicația pornește din clasa `Main`, unde utilizatorul este întâmpinat cu un meniu în buclă. Aici, utilizatorul alege o opțiune din meniu (ex: „Adaugă client”, „Plasează comandă”) și interacționează cu aplicația prin consolă. Clasa `Magazin` este componenta principală care grupează toate serviciile și oferă funcționalitățile legate de logica de business.
