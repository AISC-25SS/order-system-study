package Item;

public class ItemService {
    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item register(String name, int price) {
        Item item = new Item(null, name, price);
        return repository.save(item);
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Item getItem(Long id) {
        return repository.findById(id);
    }

    public boolean updateItem(Long id, String name, int price) {
        Item item = repository.findById(id);
        if (item == null) return false;
        repository.update(id, name, price);
        return true;
    }

    public boolean deleteItem(Long id) {
        Item item = repository.findById(id);
        if (item == null) return false;
        repository.delete(id);
        return true;
    }
}