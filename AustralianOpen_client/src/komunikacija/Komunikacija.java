package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class Komunikacija {
    private Socket s;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private static Komunikacija instance;
    
    private Komunikacija(){
        try {
            s = new Socket("localhost", 9000);
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
        } catch (IOException e) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static Komunikacija getInstance() {
        if (instance == null) 
            instance = new Komunikacija();
        return instance;
    }
    
    public ServerskiOdgovor primiOdgovor(){
        try {
            return (ServerskiOdgovor) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void posaljiZahtev(KlijentskiZahtev kz){
        try {
            oos.reset();
            oos.writeObject(kz);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
