package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {
    @Test
    public void testConstructorWithCorrectDataWorks() {
        FootballTeam team = new FootballTeam("Test", 2);
        Assert.assertEquals("Test", team.getName());
        Assert.assertEquals(2, team.getVacantPositions());
        Assert.assertNotNull(team);
    }

    @Test (expected = NullPointerException.class)
    public void testConstructorThrowsNullPointerExceptionWithInvalidName() {
        FootballTeam team = new FootballTeam(null, 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorThrowsIllegalArgumentExceptionWithInvalidVacantPositions() {
        FootballTeam team = new FootballTeam("Test", -1);
    }

    @Test
    public void getCountReturnsCorrectCount() {
        FootballTeam team = new FootballTeam("Test", 2);
        Assert.assertEquals(0, team.getCount());
    }

    @Test
    public void testAddFootballerAddsCorrectPlayerWhenSpaceIsAvailable() {
        FootballTeam team = new FootballTeam("Test", 2);
        team.addFootballer(new Footballer("Pesho"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFootballerThrowsIllegalArgumentExceptionWhenNoVacantSpots() {
        FootballTeam team = new FootballTeam("Test", 0);
        team.addFootballer(new Footballer("Pesho"));
    }

    @Test
    public void testRemoveFootballerRemovesCorrectPlayerWhenTheyExist() {
        FootballTeam team = new FootballTeam("Test", 2);
        team.addFootballer(new Footballer("Pesho"));
        team.removeFootballer("Pesho");
        Assert.assertEquals(0, team.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveFootballerThrowsIllegalArgumentExceptionWhenTheyDoNotExist() {
        FootballTeam team = new FootballTeam("Test", 2);
        team.removeFootballer("Pesho");
    }

    @Test
    public void testFootballerForSaleSetsActiveToFalse() {
        FootballTeam team = new FootballTeam("Test", 2);
        Footballer pesho = new Footballer("Pesho");
        team.addFootballer(pesho);
        team.footballerForSale("Pesho");
        Assert.assertEquals(false, pesho.isActive());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFootballerForSaleThrowsIllegalArgumentExceptionWhenTheyDoNotExist() {
        FootballTeam team = new FootballTeam("Test", 2);
        team.footballerForSale("Pesho");
    }

    @Test
    public void testGetStatisticsReturnsCorrectString() {
        FootballTeam team = new FootballTeam("Test", 2);
        team.addFootballer(new Footballer("Pesho"));
        Assert.assertEquals("The footballer Pesho is in the team Test.", team.getStatistics());
    }
}
