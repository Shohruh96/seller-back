package uz.shohruh.service;

import uz.shohruh.model.Purchase;
import uz.shohruh.repository.projection.PurchaseItem;

import java.util.List;

public interface PurchaseService {
    Purchase savePurchase(Purchase purchase);

    List<PurchaseItem> findPurchaseItemsOfUser(Long userId);
}
