package book;

import book.model.Book;
import com.google.inject.persist.Transactional;
import jpa.GenericJpaDao;

import javax.persistence.NoResultException;
import java.util.Optional;

public class BookDao extends GenericJpaDao {

    @Transactional
    public Optional<Book> findByIsbn13(String isbn13) {
        try {
            return Optional.of(entityManager.createQuery("SELECT i FROM Isbn13 i WHERE i.isbn13 = :isbn13", Book.class)
                    .setParameter("isbn13", isbn13)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
