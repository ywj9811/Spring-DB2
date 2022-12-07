package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface JpaItemRepository extends JpaRepository<Item, Long> {
}
