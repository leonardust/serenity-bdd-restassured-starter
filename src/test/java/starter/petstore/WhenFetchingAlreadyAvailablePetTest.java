package starter.petstore;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenFetchingAlreadyAvailablePetTest {

    Long newPetId = null;
    PetApiActions petApiActions;

    @Test
    void fetchAlreadyAvailablePetTest() {

        //Arrange (Given): Set the stage to call the GET api by pre-loading the pet named 'Kitty' using a HTTP POST call documented here.
        newPetId = petApiActions.givenKittyIsAvailableInPetStore();

        //Act (When): Call the API under test using the ID of 'Kitty'
        petApiActions.whenIAskForAPetWithId(newPetId);

        //Assert (Then): Check that the API returns a pet with name 'Kitty'
        petApiActions.thenISeeKittyAsResult();
    }
}
