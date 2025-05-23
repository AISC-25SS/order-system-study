package item;

import java.util.List;

public interface ItemService {

    Item registerItem(String name, int price);    //아이템을 등록한다.

    void listItems();

    List<Item> getAllItems();

    Item getItem(Long id);

    boolean updateItem(Long id, String name, int price);

    boolean deleteItem(Long id);
}
