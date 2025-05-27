package item;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MemoryItemRepository implements ItemRepository {
    private final Map<Long, Item> store = new LinkedHashMap<>();
    private long sequence = 0;

    @Override
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Item findById(Long id) {
        return store.get(id);
    }

    @Override
    public void update(Long id, String name, int price) {
        Item item = store.get(id);
        if (item != null) {
            item.setName(name);
            item.setPrice(price);
        }
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }
}