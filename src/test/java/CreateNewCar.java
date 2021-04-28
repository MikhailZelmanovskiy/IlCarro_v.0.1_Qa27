import models.Car;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewCar extends TestBase{
    @BeforeMethod
    public void preconditions(){
        if(!app.user().isLogged()){
            app.user().loggin();
        }
    }
    @Test
    public void createNewCar(){
        app.car().openCreationForm();
        app.car().fillCarForm(new Car().withLocation("Tel-Aviv")
                .withMake("Subaru")
                .withModel("Forester")
                .withYear("2017")
                .withEngine("2000")
                .withFuel("Petrol")
                .withGear("AT")
                .withWd("RWD")
                .withDoors("5")
                .withSeats("5")
                .withCarClass("Luxury")
                .withFuelConsumption("10")
                .withCarRegNum("8612432")
                .withPrice("350")
                .withDistanceIncluded("500"));
        app.car().attachfoto("C:/Users/madin/Desktop/QA27/IlCarro_v.0.1_Qa27/Subaru.jpg");
        app.car().pause(2000);
        app.car().pushButtonSubmit();
        Assert.assertTrue(app.car().isCarAdded());
    }
    @AfterMethod
    public void postconditions(){
    }
}
