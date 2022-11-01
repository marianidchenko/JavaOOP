import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class ExtendedDatabaseTests {
    private static final Person INITIAL_VALID_PERSON = new Person(1, "Pesho");
    private Database db;

    public ExtendedDatabaseTests() {
    }

    @Before
    public void setUp() throws Exception {
        this.db = new Database(INITIAL_VALID_PERSON);
    }

    @Test
    public void testCreateDatabaseWithCorrectDataWorks() throws OperationNotSupportedException {
        Assert.assertArrayEquals(new Database(INITIAL_VALID_PERSON).getElements(), this.db.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreateDatabaseThrowsExceptionWithNoData() throws OperationNotSupportedException {
        new Database();
    }

    @Test
    public void testAddAddsTheCorrectData() throws OperationNotSupportedException {
        this.db.add(new Person(2, "Gosho"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowsExceptionWhenAddingNullValue() throws OperationNotSupportedException {
        this.db.add(null);
    }

    @Test
    public void testRemoveSuccessfullyRemovesLastPerson() throws OperationNotSupportedException {
        this.db.remove();
        System.out.println(Arrays.toString(this.db.getElements()));
        Assert.assertEquals(0, this.db.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveThrowsExceptionWhenRemovingFromEmptyDatabase() throws OperationNotSupportedException {
        this.db.remove();
        this.db.remove();
    }

    @Test
    public void testFindByUsernameReturnsCorrectResult() throws OperationNotSupportedException {
        Person actualPerson = this.db.findByUsername("Pesho");
        Assert.assertEquals(INITIAL_VALID_PERSON, actualPerson);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsExceptionWhenUsernameIsNotFound() throws OperationNotSupportedException {
        this.db.findByUsername("2");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsExceptionWhenUsingNull() throws OperationNotSupportedException {
        this.db.findByUsername(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsExceptionWhenNameHasWrongCase() throws OperationNotSupportedException {
        this.db.findByUsername("pesho");
    }

    @Test
    public void testFindByIdReturnsCorrectPerson() throws OperationNotSupportedException {
        Person actualPerson = this.db.findById(1);
        Assert.assertEquals(INITIAL_VALID_PERSON, actualPerson);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByIdThrowsExceptionWhenIdIsnotFound() throws OperationNotSupportedException {
        this.db.findById(2);
    }

}
