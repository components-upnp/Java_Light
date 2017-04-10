import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by comkostiuk on 10/04/2017.
 */
public class Device extends Spy {

    public Device() {super("Ampoule (simulation)");}

    public void setValeur(String val) throws NoDevice, NoService, NotLaunched {
        HashMap<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("NewValeur",val);
        super.launchAction("LuminositeService","SetValeur",arguments);
    }

    public String getVal() throws NoDevice, NoService, NotLaunched {
        HashMap<String, Object> arguments = new HashMap<String, Object>();
        ArrayList<Object> val = super.launchAction("LuminositeService","GetValeur",arguments);
        System.out.println(val);
        return (String) val.get(0);
    }

    public void verouillage() throws NoDevice, NoService, NotLaunched {
        HashMap<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("NewTargetValue", "CENTRE");
        ArrayList<Object> val = super.launchAction("OrdreService","SetTarget",arguments);
        System.out.println(val);
    }

}
