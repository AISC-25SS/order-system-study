package item.ui;

import item.ItemRepository;
import item.ItemService;
import item.ItemServiceImpl;

public class Uiapplication {

        public static void main(String[] args) {
            ItemRepository itemRepository = new ItemRepository();
            ItemService itemService = new ItemServiceImpl(itemRepository);
            Ui ui = new Ui(itemService);
            ui.start();
        }

}
