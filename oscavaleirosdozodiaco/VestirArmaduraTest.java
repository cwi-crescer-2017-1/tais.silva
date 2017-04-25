import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest {
    @Test
    public void vestirArmadura() throws Exception {
        // Arrange
        Saint shaina = new SilverSaint("Shaina", "Serpente");
        Movimento movimento = new VestirArmadura(shaina);
        // Act
        movimento.executar();
        // Assert
        assertTrue(shaina.getArmaduraVestida());
    }

    @Test
    public void naoVestirArmadura() throws Exception {
        Saint shaina = new SilverSaint("Shaina", "Serpente");
        Movimento movimento = new VestirArmadura(shaina);
        assertFalse(shaina.getArmaduraVestida());
    }

    @Test(expected=NullPointerException.class)
    public void vestirArmaduraComSaintNull() throws Exception {
        // Arrange
        Saint shaina = null;
        Movimento movimento = new VestirArmadura(shaina);
        // Act
        movimento.executar();
    }

}