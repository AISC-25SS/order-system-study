package item;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item registerItem(String name, int price) {
        Item item = new Item(null, name, price);
        return repository.save(item);
    }

    @Override
    public void listItems() {
        List<Item> items = repository.findAll();
        if (items.isEmpty()) {
            System.out.println("등록된 상품이 없습니다.");
        } else {
            System.out.println("등록된 상품 목록:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    @Override
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @Override
    public Item getItem(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean updateItem(Long id, String name, int price) {
        Item item = repository.findById(id);
        if (item == null) return false;
        repository.update(id, name, price);
        return true;
    }
    @Override
    public boolean deleteItem(Long id) {
        Item item = repository.findById(id);
        if (item == null) return false;
        repository.delete(id);
        return true;
    }
}