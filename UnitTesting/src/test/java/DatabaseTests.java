import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private static final Integer[] INITIAL_VALID_ELEMENTS = new Integer[]{1, 2, 3};
    private Database db;

    public DatabaseTests() {
    }

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        this.db = new Database(INITIAL_VALID_ELEMENTS);
    }

    @Test(
            expected = OperationNotSupportedException.class
    )
    public void testCreateDatabaseThrowsErrorWithEmptyConstructor() throws OperationNotSupportedException {
        new Database();
    }

    @Test(
            expected = OperationNotSupportedException.class
    )
    public void testCreateDatabaseThrowsErrorWithMoreThan16Elements() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test
    public void testCreateDatabaseWithCorrectDataWorks() {
        Assert.assertArrayEquals(INITIAL_VALID_ELEMENTS, this.db.getElements());
    }

    @Test
    public void testAddValueAddsCorrectData() throws OperationNotSupportedException {
        this.db.add(4);
        Assert.assertArrayEquals(new Integer[]{1,2,3,4}, this.db.getElements());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddThrowsExceptionWhenAddingNullValue() throws OperationNotSupportedException {
        this.db.add(null);
    }

    @Test
    public void testRemoveRemovesLastValueCorrectly() throws OperationNotSupportedException {
        this.db.remove();
        Assert.assertArrayEquals(new Integer[]{1,2}, this.db.getElements());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveThrowsExceptionWhenRemovingFromEmptyDatabase() throws OperationNotSupportedException {
        this.db.remove();
        this.db.remove();
        this.db.remove();
        this.db.remove();
    }

}
