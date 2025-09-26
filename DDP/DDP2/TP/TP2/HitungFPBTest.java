import static org.junit.Assert.*;
import org.junit.Test;

public class HitungFPBTest {

    @Test
    public void checkFPB_case0(){
        assertEquals(1, HitungFPB.hitungFPB(3, 4));
    }

    @Test
    public void checkFPB_case1(){
        assertEquals(4, HitungFPB.hitungFPB(8, 12));
    }

    @Test
    public void checkFPB_case2(){
        assertEquals(21, HitungFPB.hitungFPB(63, 42));
    }

    @Test
    public void checkFPB_case3(){
        assertEquals(21, HitungFPB.hitungFPB(42, 63));
    }

    @Test
    public void checkFPB_case4(){
        assertEquals(11, HitungFPB.hitungFPB(22,121));
    }
    
}