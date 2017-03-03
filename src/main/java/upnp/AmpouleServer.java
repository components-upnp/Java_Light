/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upnp;

import display.Fenetre;
import java.io.IOException;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.UpnpServiceImpl;
import org.fourthline.cling.binding.LocalServiceBindingException;
import org.fourthline.cling.binding.annotations.AnnotationLocalServiceBinder;
import org.fourthline.cling.model.DefaultServiceManager;
import org.fourthline.cling.model.meta.DeviceDetails;
import org.fourthline.cling.model.meta.DeviceIdentity;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.meta.ManufacturerDetails;
import org.fourthline.cling.model.meta.ModelDetails;
import org.fourthline.cling.model.types.DeviceType;
import org.fourthline.cling.model.types.UDADeviceType;
import org.fourthline.cling.model.types.UDN;

/**
 *
 * @author telly
 */
public class AmpouleServer implements Runnable{

    @Override
    public void run() {
         try {

            final UpnpService upnpService = new UpnpServiceImpl();

            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    upnpService.shutdown();
                }
            });

            // Add the bound local device to the registry
            upnpService.getRegistry().addDevice(
                    createDevice()
            );

        } catch (Exception ex) {
            System.err.println("Exception occured: " + ex);
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }
	
	public LocalDevice createDevice()
            throws  LocalServiceBindingException, IOException, org.fourthline.cling.model.ValidationException {

        DeviceIdentity identity =
                new DeviceIdentity(
                        UDN.uniqueSystemIdentifier("Ampoule Java")
                );

        DeviceType type =
                new UDADeviceType("Ampoule", 1);

        DeviceDetails details =
                new DeviceDetails(
                        "Ampoule (simulation)",					// Friendly Name
                        new ManufacturerDetails(
                                "UPS-IRIT & CreaTech",								// Manufacturer
                                ""),								// Manufacturer URL
                        new ModelDetails(
                                "Ampoule",						// Model Name
                                "simulation d'une Ampoule",	// Model Description
                                "v1" 								// Model Number
                        )
                );
        LocalService<OrdreService> ordreService =
                new AnnotationLocalServiceBinder().read(OrdreService.class);
        ordreService.setManager(
                new DefaultServiceManager(ordreService, OrdreService.class)
        );
        LocalService<LuminositeService> luminositeService = 
                new AnnotationLocalServiceBinder().read(LuminositeService.class);
        luminositeService.setManager(
                new DefaultServiceManager(luminositeService,LuminositeService.class)
        );
        
        new Fenetre(ordreService,luminositeService).setVisible(true);
      
        return new LocalDevice(
                identity, type, details, 
                new LocalService[] {ordreService,luminositeService} 
        );
    }

}


