package Entitati;

import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Timestamp;

public class Comanda {
    private static int counter = 1;
    private int id;
    private Client client;
    private List<Produs> produse;
    private String status;
    private Date dataPlasare;

    public Comanda(Client client) {
        this.id = counter++;
        this.client = client;
        this.produse = new ArrayList<>();
        this.status = "NEPROCESAT";
        this.dataPlasare = new Date();
    }

    public Comanda(Comanda other) {
        this.id = other.id;
        this.client = new Client(other.client);
        this.produse = new ArrayList<>();
        for (Produs p : other.produse) {
            this.produse.add(new Produs(p));
        }
        this.status = other.status;
        this.dataPlasare = new Date(other.dataPlasare.getTime());
    }

    public void adaugaProdus(Produs p) {
        produse.add(p);
    }

    public void proceseazaComanda() {
        status = "PROCESAT";
    }

    public void sorteazaProduseDupaPret() {
        produse.sort(Comparator.comparingDouble(Produs::getPret));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataPlasare() {
        return dataPlasare;
    }

    public void setDataPlasare(Date dataPlasare) {
        this.dataPlasare = dataPlasare;
    }

    public void setDataPlasare(Timestamp timestamp) {
        this.dataPlasare = new Date(timestamp.getTime());
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return "Comanda " + id + " pentru " + client.getNume() + " - " + status + " (plasat: " + sdf.format(dataPlasare) + ")";
    }
}
