package at.reiters.tests.bsp2;

import at.reiters.bsp1.CombatType;
import at.reiters.bsp1.DamageType;
import at.reiters.bsp1.Sorter;
import at.reiters.bsp1.Weapon;
import at.reiters.bsp2.Functions;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionsTest
{

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void testAverage() throws Exception
    {
        int[] arr = {1,2,3,4,5,6};
        double result = Functions.average(arr);
        Assert.assertEquals("3.5", String.valueOf(result));
    }

    @Test
    public void testUpperCase() throws Exception
    {
        String[] arr = {"a", "B", "c", "d"};
        List<String> result = Functions.upperCase(arr);
        String[] expec = {"A", "B", "C", "D"};
        Assert.assertEquals(Arrays.asList(expec), result);
    }
}
