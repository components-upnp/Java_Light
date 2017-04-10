import org.junit.Before;
import org.junit.Test;
import upnp.AmpouleServer;

import static org.junit.Assert.assertEquals;

public class TestService {

    private volatile Thread server;
    private Device device;
    @Before
    public void setUp() {
       server = new Thread(new AmpouleServer());
       server.start();
       pause(1000);
       this.device = new Device();
       pause(1000);
    }



    @Test
    public void testValeurInit() throws NoDevice, NoService, NotLaunched {
       String val = device.getVal();
       assertEquals("100", val);
    }

    @Test
    public void testChangementValeurValide() throws NoDevice, NoService, NotLaunched {
        device.setValeur("0");
        String val = device.getVal();
        assertEquals("0", val);
    }

    @Test
    public void testChangementValeurInvalide() throws NoDevice, NoService, NotLaunched {
        device.setValeur("LOL");
        String val = device.getVal();
        assertEquals("0", val);
    }

    @Test
    public void testVerouillage() throws NoDevice, NoService, NotLaunched {
        device.setValeur("100");
        pause(1000);
        device.verouillage();
        pause(1000);
        device.setValeur("0");
        assertEquals("100", device.getVal());
    }

    @Test
    public void testDeverouillage() {

    }


    public static void pause(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}