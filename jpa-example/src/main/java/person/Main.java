package person;

import com.github.javafaker.Faker;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.ZoneId;
import java.util.Locale;


public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");

    private static Faker faker = new Faker(new Locale("hu"));


    private static Person randomPerson() {
        Person person = Person.builder()
                .name(faker.name().name())
                .dob(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .gender(faker.options().option(Person.Gender.class))
                .address(faker.address())
                .email(faker.internet().emailAddress())
                .profession(faker.company().profession())
                .build();

        Address address = Address.builder()

                .country(faker.address().country())
                .state(faker.address().state())
                .city(faker.address().city())
                .streetAddress(faker.address().streetAddress())
                .zip(faker.address().zipCode())
                .build();

        return person;
    }


    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();


        try {
            for (int i = 0; i < 1000; i++) {
                em.getTransaction().begin();
                em.persist(randomPerson());
                em.getTransaction().commit();

            }
        } finally {
            em.close();
        }
    }
}







