// import static org.junit.Assert.*;
// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;

// public class ContraAtaqueTest
// {
//     @Test
//     public void contraAtaque() throws Exception {
//         Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
//         shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 60));
//         Saint misty = new SilverSaint("Misty", "Lagarto");
//         misty.aprenderGolpe(new Golpe("Golpe do Lagarto", 10));
//         Movimento golpear = new Golpear(shiryu, misty);
//         golpear.executar();                
//         assertEquals(100.0, shiryu.getVida(), 0.01);
//         assertEquals(40.0, misty.getVida(), 0.01);
//         Movimento contraAtaque = new ContraAtaque(shiryu, misty); 
//         contraAtaque.executar();
//         assertEquals(75.0, shiryu.getVida(), 0.01);
//         assertEquals(40.0, misty.getVida(), 0.01);
        
        
//         golpear.executar();
//         assertEquals(75.0, shiryu.getVida(), 0.01);
//         assertEquals(40.0, misty.getVida(), 0.01);
//     }
    

// }
