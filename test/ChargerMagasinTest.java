import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;


public class ChargerMagasinTest {

    @Test
    public void testChargerMagasin() throws Exception {
        //Preparation
        XML.ChargeurMagasin loader = new XML.ChargeurMagasin("musicbrainzSimple/");

        //Méthode testée
        donnees.Magasin magasin = loader.chargerMagasin();

        //Test
        assertEquals(12, magasin.getNombreCds());
    }

    @Test
    public void testChargerMagasinThrows() throws Exception {
        //Preparation
        boolean result = false;
        XML.ChargeurMagasin loader = new XML.ChargeurMagasin("musicbrainzSimpleLOL/");

        try{
            assertFalse(result);
            Magasin mag = loader.chargerMagasin();
        } catch (FileNotFoundException e) {
            result = true;
        }

        //Test
        assertTrue(result);
    }
}
