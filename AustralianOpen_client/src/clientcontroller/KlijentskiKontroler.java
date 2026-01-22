package clientcontroller;

import Operation.Operations;
import java.util.List;
import model.User;
import transfer.KlijentskiZahtev;
import komunikacija.Komunikacija;
import model.Gost;
import model.Prijava;
import transfer.ServerskiOdgovor;

public class KlijentskiKontroler {
    private static KlijentskiKontroler instance;
    private User ulogovani;

    private KlijentskiKontroler() {}

    public static KlijentskiKontroler getInstance() {
        if (instance == null)
            instance = new KlijentskiKontroler();
        return instance;
    }
    
    public void registruj(User u) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operations.registracija, u);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();

        if (!so.isUspesno())  
            throw new Exception((String) so.getOdgovor());
    }
    
    public User login(String username, String sifra) throws Exception {
        String[] parametri = {username, sifra};
        KlijentskiZahtev kz = new KlijentskiZahtev(Operations.login, parametri);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();

        if (so.isUspesno())
            return (User) so.getOdgovor();
        else throw new Exception((String) so.getOdgovor());
    }

    public void prijaviSmenu(Prijava p) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operations.prijava_volontiranja, p);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        if (!so.isUspesno())
               throw new Exception((String) so.getOdgovor());  
    }

    public void prijaviSmenuGost(Gost g) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operations.prijava_volontiranja_GOST, g);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        if (!so.isUspesno())
               throw new Exception((String) so.getOdgovor());
    }
    
    public static List<Prijava> vratiListuPrijava(User u) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operations.vrati_listu_prijava, u);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        if (so.isUspesno())
            return (List<Prijava>) so.getOdgovor();
        else throw new Exception((String) so.getOdgovor());
    }

    public List<Gost> vratiListuPrijavaGost(String jmbg) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operations.vrati_listu_prijava_GOST, jmbg);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        if (so.isUspesno())
            return (List<Gost>) so.getOdgovor();
        else throw new Exception((String) so.getOdgovor());
    }

    public void izmeniPrijavu(Prijava pzi) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operations.izmeni_prijavu, pzi);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        if (!so.isUspesno())
               throw new Exception((String) so.getOdgovor());
    }
    
    public void obrisiPrijavu(Prijava pzb) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operations.obrisi_prijavu, pzb);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        if (!so.isUspesno())
               throw new Exception((String) so.getOdgovor());
    }
}
