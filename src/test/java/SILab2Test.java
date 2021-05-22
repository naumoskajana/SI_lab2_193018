import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<Time> createList(Time...times){
        return new ArrayList<>(Arrays.asList(times));
    }

    private final SILab2 lab = new SILab2();

    @Test
    void multipleCondition(){
        RuntimeException ex;

        //test slucai za 'if (hr < 0 || hr > 24)'
        Time time1 = new Time(-3, 30,30); //T||X
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time1)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        Time time2 = new Time(25, 30, 50); //F||T
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time2)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        Time time3 = new Time(5,10,12); //F||F
        List<Integer> list1 = Arrays.asList(18612);
        assertEquals(list1,lab.function(createList(time3)));


        //test slucai za 'if (min < 0 || min > 59)'
        Time time4 = new Time(10, 60,12); //T||X
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time4)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        Time time5 = new Time(20, 65, 30); //F||T
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time5)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

            //time3 -> F||F
        List<Integer> list2 = Arrays.asList(18612);
        assertEquals(list2,lab.function(createList(time3)));


        //test slucai za 'if (sec >= 0 && sec <= 59)'
        Time time6 = new Time(12, 20,-6); //FX
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time6)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        Time time7 = new Time(20, 10, 63); //TF
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time7)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

            //time3 -> TT
        List<Integer> list3 = Arrays.asList(18612);
        assertEquals(list2,lab.function(createList(time3)));


        //test slucai za 'if (hr == 24 && min == 0 && sec == 0)'
        Time time8 = new Time(24, 0, 0);//TTT
        List<Integer> result3 = Arrays.asList(86400);
        assertEquals(result3,lab.function(createList(time8)));

        Time time9 = new Time(24, 0, 12); //TTF
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time9)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        Time time10 = new Time(24, 10, 12); //TFX
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time10)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

    }

    @Test
    void everyBranch(){
        List<Integer> list = new ArrayList<>();
        RuntimeException ex;

        Time time1 = new Time(-3, 30, 30);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time1)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        Time time2 = new Time(25,30,50);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time2)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        Time time3 = new Time(5, 10, 12);
        list= Arrays.asList(18612);
        assertEquals(list, lab.function(createList(time3)));

        Time time4 = new Time(10, 60,12);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time4)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        Time time5 = new Time(20,30,60);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time5)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        Time time6 = new Time(24,0,0);
        list= Arrays.asList(86400);
        assertEquals(list, lab.function(createList(time6)));

        Time time7 = new Time(24,0,5);
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(time7)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

    }
}