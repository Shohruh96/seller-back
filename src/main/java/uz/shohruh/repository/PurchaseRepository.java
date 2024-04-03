package uz.shohruh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.shohruh.model.Purchase;
import uz.shohruh.repository.projection.PurchaseItem;
import uz.shohruh.model.Product;


import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query(value = "SELECT " +
            "prd.name as nane, pur.price as price, pur.purchaseTime as purchaseTime " +
            "FROM Purchase pur LEFT JOIN Product prd ON prd.id = pur.productId " +
            "WHERE pur.userId = :userId", nativeQuery = true
    )
    List<PurchaseItem> findAllPurchaseOfUser(@Param("userId") Long userId);
}


//@Query("SELECT " +
//        "prd.name as nane, pur.price as price, pur.purchaseTime as purchaseTime " +
//        "FROM Purchase pur LEFT JOIN Product prd ON prd.id = pur.productId " +
//        "WHERE pur.userId = :userId"
//)
