package pl.coderslab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {

    @Modifying
    @Transactional
    @Query("update Book b set b.isbn=?1, b.title=?2, b.author=?3, b.publisher=?4, b.type=?5 where b.id=?6")
    void update(String isbn, String title, String author, String publisher, String type, Long id);
}
