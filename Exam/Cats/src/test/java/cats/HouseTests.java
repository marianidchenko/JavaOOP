package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {
    @Test
    public void testConstructorWithCorrectDataWorks() {
        House house = new House("TestHouse", 2);
        Assert.assertNotNull(house);
        Assert.assertEquals(House.class, house.getClass());
    }

    @Test
    public void testConstructorWithCorrectDataSetsDataCorrectly() {
        House house = new House("TestHouse", 2);
        Assert.assertEquals("TestHouse", house.getName());
        Assert.assertEquals(2, house.getCapacity());
    }

    @Test (expected = NullPointerException.class)
    public void testConstructorThrowsNullPointerExceptionWithInvalidName() {
        new House(" ", 2);
        new House(null, 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorThrowsIllegalArgumentExceptionWithInvalidCapacity() {
        new House("TestHouse", -1);
    }

    @Test
    public void testGetCountReturnsCorrectCatSize() {
        House house = new House("TestHouse", 2);
        Assert.assertEquals(0, house.getCount());
        house.addCat(new Cat("TestCat"));
        Assert.assertEquals(1, house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddCatThrowsIllegalArgumentExceptionWhenHouseIsFull() {
        House house = new House("TestHouse", 1);
        house.addCat(new Cat("TestCat1"));
        house.addCat(new Cat("TestCat2"));
    }

    @Test
    public void testRemoveCatRemovesCatSuccessfully() {
        House house = new House("TestHouse", 2);
        house.addCat(new Cat("TestCat"));
        house.removeCat("TestCat");
        Assert.assertEquals(0, house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveCatThrowsIllegalArgumentExceptionWhenCatDoesNotExist() {
        House house = new House("TestHouse", 2);
        house.removeCat("TestCat");
    }

    @Test
    public void testCatForSaleReturnsCorrectCatByName() {
        House house = new House("TestHouse", 2);
        Cat cat = new Cat("TestCat");
        house.addCat(cat);
        Assert.assertEquals(cat, house.catForSale("TestCat"));
        Assert.assertFalse(cat.isHungry());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCatForSaleThrowsIllegalArgumentExceptionWhenCatDoesNotExist() {
        House house = new House("TestHouse", 2);
        house.catForSale("TestCat");
    }

    @Test
    public void getStatisticsReturnsCorrectString() {
        House house = new House("TestHouse", 2);
        Cat cat = new Cat("TestCat");
        house.addCat(cat);
        Assert.assertEquals("The cat TestCat is in the house TestHouse!", house.statistics());
    }

}
