package projectCalculationTool.subproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubProjectTest {

    @Test
    void correctHoursToWorkDays() {
        //8 hours = 1 workday
        //9 hours = 2 workdays
        //arrange
        int time=9;

        //act
        double calcWorkdays = (double)time/8;
        int workdays = (int) Math.ceil(calcWorkdays);

        int expected = 9;//number is in workdays
        //assert
        assertEquals(expected, workdays);
    }

    @Test
    void zeroTimeToWorkdays(){
        int time = 0;

        //act
        double calcWorkdays = (double)time/8;
        int workdays = (int) Math.ceil(calcWorkdays);

        int expected = 0;//number is in workdays
        //assert
        assertEquals(expected, workdays);
    }


}