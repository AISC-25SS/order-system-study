package item;

import java.util.List;

public interface ItemRepository {
    Item save(Item item);
    List<Item> findAll();
    Item findById(Long id);
    void update(Long id, String name, int price);
    void delete(Long id);
}
