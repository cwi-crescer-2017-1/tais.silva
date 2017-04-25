import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest {

    @Test
    public void golpearBronzeComArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        new VestirArmadura(shiryu).executar();
        Movimento golpear = new Golpear(shiryu, seiya);
        golpear.executar();
        assertEquals(80.0, seiya.getVida(), 0.01);
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }

    @Test
    public void golpearBronzeSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        Movimento golpear = new Golpear(shiryu, seiya);
        golpear.executar();
        assertEquals(90.0, seiya.getVida(), 0.01);
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }

    @Test
    public void golpearSilverComArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Golpe do Lagarto", 10));
        new VestirArmadura(misty).executar();
        Movimento golpear = new Golpear(misty, seiya);
        golpear.executar();
        assertEquals(70.0, seiya.getVida(), 0.01);
        assertEquals(100.0, misty.getVida(), 0.01);
    }

    @Test
    public void golpearSilverSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Golpe do Lagarto", 10));
        Movimento golpear = new Golpear(misty, seiya);
        golpear.executar();
        assertEquals(90.0, seiya.getVida(), 0.01);
        assertEquals(100.0, misty.getVida(), 0.01);
    }

    @Test
    public void golpearGoldComArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        aldebaran.aprenderGolpe(new Golpe("Grande Chifre", 10));
        new VestirArmadura(aldebaran).executar();
        Movimento golpear = new Golpear(aldebaran, seiya);
        golpear.executar();
        assertEquals(60.0, seiya.getVida(), 0.01);
        assertEquals(100.0, aldebaran.getVida(), 0.01);
    }

    @Test
    public void golpearGoldSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        aldebaran.aprenderGolpe(new Golpe("Grande Chifre", 40));
        Movimento golpear = new Golpear(aldebaran, seiya);
        golpear.executar();
        assertEquals(60.0, seiya.getVida(), 0.01);
        assertEquals(100.0, aldebaran.getVida(), 0.01);
    }

    @Test(expected=ArithmeticException.class)
    public void naoGolpear() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        Movimento golpear = new Golpear(aldebaran, seiya);
        golpear.executar();
    }
}
