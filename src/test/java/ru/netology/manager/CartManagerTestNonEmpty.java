package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTestNonEmpty {
    @Test
    public void shouldRemoveIfExists() {
        CartManager manager = new CartManager();
        int idToRemove = 1;
        PurchaseItem first = new PurchaseItem(1,1,"first",1,1);
        PurchaseItem second = new PurchaseItem(2,2,"second",1,1);
        PurchaseItem third = new PurchaseItem(3,3,"thrid",1,1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeByID(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldnotRemoveIfNotExists() {
        CartManager manager = new CartManager();
        int idToRemove = 4;
        PurchaseItem first = new PurchaseItem(1,1,"first",1,1);
        PurchaseItem second = new PurchaseItem(2,2,"second",1,1);
        PurchaseItem third = new PurchaseItem(3,3,"thrid",1,1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeByID(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second};

        assertArrayEquals(expected, actual);
    }

}