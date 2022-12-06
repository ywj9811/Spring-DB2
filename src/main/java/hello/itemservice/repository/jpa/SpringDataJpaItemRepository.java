package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 * <>에는 순서대로 Entity이름과 pk타입(우리는 Long을 사용중이니 Long)
 */
public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemNameLike(String itemName);
    
    List<Item> findByPriceLessThanEqual(Integer price);

    /**쿼리 메소드가 너무 길어질 경우 쿼리를 직접 실행하자
     * List<Item> findByItemNameLikeAndPriceLessThanEqual(String itemName, Integer price); 이렇게 메소드로 작성하면 너무 길어짐
     * 따라서 아래와 같이 직접 쿼리문을 작성해서 실행시키자
     */
    
     @Query("select i from Item  i where i.itemName like :itemName and i.price <= :price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price") Integer price);
    /**
     * @Param 을 넣어주어야 쿼리문에 매칭이 된다!
     */
}
