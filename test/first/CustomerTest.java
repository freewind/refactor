package first;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    private Customer customer;
    private String name;

    @Before
    public void setUp() throws Exception {
        name = "tester";
        customer = new Customer(name);
    }

    @org.junit.Test
    public void shouldName1() throws Exception {
        Customer customer = this.customer;
        Movie movie = new Movie("rose", Movie.REGULAR);
        customer.addRental(new Rental(movie, 5));
        String result = customer.statement();
        assertThat(result, is("Rental Record for tester\n" +
                "\trose\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points"));
    }

    @Test
    public void shouldName2() throws Exception {
        Customer customer = this.customer;
        Movie movie = new Movie("rose", Movie.CHILDRENS);
        customer.addRental(new Rental(movie, 5));
        String result = customer.statement();
        assertThat(result, is("Rental Record for tester\n" +
                "\trose\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points"));
    }

    @Test
    public void shouldName3() throws Exception {
        Customer customer = this.customer;
        Movie movie = new Movie("rose", Movie.NEW_RELEASE);
        customer.addRental(new Rental(movie, 5));
        String result = customer.statement();
        System.out.println(result);
        assertThat(result, is("Rental Record for tester\n" +
                "\trose\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points"));
    }
}
