/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upnp;

import java.beans.PropertyChangeSupport;

import org.fourthline.cling.binding.annotations.*;

/**
 *
 * @author telly
 */
@UpnpService(
        serviceId = @UpnpServiceId("OrdreService"),
        serviceType = @UpnpServiceType(value = "OrdreService", version = 1)
)
public class OrdreService {
    private final PropertyChangeSupport propertyChangeSupport;
    
    public OrdreService(){
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    
    public PropertyChangeSupport getPropertyChangeSupport(){
        return propertyChangeSupport;
    }
    
    @UpnpStateVariable(defaultValue = "Aucun", sendEvents = false)
    private String target = "Aucun";
	
    @UpnpStateVariable(defaultValue = "Aucun")
    private String status = "Aucun";
    
    @UpnpAction
    public void setTarget(@UpnpInputArgument(name = "NewTargetValue") String newTargetValue){
        String targetOldValue = target;
        String statusOldValue = status;
        if(newTargetValue.equals("CENTRE")){
            status = newTargetValue;
            target = status;
            //getPropertyChangeSupport().firePropertyChange("target", targetOldValue, target);
            getPropertyChangeSupport().firePropertyChange("status", statusOldValue, status);
           
            status = "Aucun";
            target = "Aucun";
        }
    }

}
