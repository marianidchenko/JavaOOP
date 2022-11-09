package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GiftFactoryTests {
    private GiftFactory gf;
    private Gift gift1;
    private Gift gift2;

    @Before
    public void setUp() throws Exception {
        gf = new GiftFactory();
        gift1 = new Gift("Toy", 10);
        gift2 = new Gift("Book", 5);
    }

    @Test
    public void testConstructorCreatesInstanceOfClassWithCountZero() {
        Assert.assertEquals(0 ,this.gf.getCount());
    }

    @Test
    public void testCreateGiftCreatesAndReturnsCorrectDataWithValidInformation() {
        String result = this.gf.createGift(this.gift1);
        Assert.assertEquals("Successfully added gift Toy with magic 10.00.", result);
        Assert.assertEquals(1, this.gf.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateGiftThrowsIllegalArgumentExceptionWhenGiftAlreadyExists() throws Exception {
        this.gf.createGift(this.gift1);
        this.gf.createGift(this.gift1);
    }

    @Test
    public void testRemoveGiftRemovesGiftAndReturnsTrueWhenItExists() {
        this.gf.createGift(this.gift1);
        boolean returnStatement = this.gf.removeGift("Toy");
        Assert.assertEquals(true, returnStatement);
        Assert.assertEquals(0, this.gf.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveGiftRemovesGiftThrowsNullPointerExceptionWhenGiftNameIsNull() {
        this.gf.removeGift(null);
    }

    @Test
    public void testGetPresentWithLeastMagicReturnsLesserOutOfTwoGifts() {
        this.gf.createGift(this.gift1);
        this.gf.createGift(this.gift2);
        Gift returnStatement = this.gf.getPresentWithLeastMagic();
        Assert.assertEquals(gift2, returnStatement);
    }

    @Test
    public void testGetPresentReturnsCorrectPresentByName() {
        this.gf.createGift(this.gift1);
        Gift returnStatement = this.gf.getPresent("Toy");
        Assert.assertEquals(gift1, returnStatement);
    }

    @Test
    public void testGetPresentsReturnsUnmodifiableCollection() {
        this.gf.createGift(this.gift1);
        System.out.println(gf.getPresents().getClass().getSimpleName());
        Assert.assertEquals("UnmodifiableCollection", this.gf.getPresents().getClass().getSimpleName());
    }

}
