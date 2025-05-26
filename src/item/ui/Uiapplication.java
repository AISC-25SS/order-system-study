package item.ui;

import item.ItemRepository;
import item.ItemService;
import item.ItemServiceImpl;
import item.MemoryItemRepository;
import item.ItemUI;

public class Uiapplication {

        public static void main(String[] args) {
            ItemRepository itemRepository = new MemoryItemRepository();
            ItemService itemService = new ItemServiceImpl(itemRepository);
            ItemUI ui = new ItemUI(itemService);
            ui.start();
        }

}
