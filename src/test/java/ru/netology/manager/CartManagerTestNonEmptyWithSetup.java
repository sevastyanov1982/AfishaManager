package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTestNonEmptyWithSetup {
    private CartManager manager = new CartManager();
    private PurchaseItem first = new PurchaseItem(1,1,"first",1,1);
    private PurchaseItem second = new PurchaseItem(2,2,"first",1,1);
    private PurchaseItem thrid = new PurchaseItem(3,3,"first",1,1);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(thrid);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeByID(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{thrid, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldnotRemoveIfNotExists() {
        int idToRemove = 4;
        manager.removeByID(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{thrid, second};

        assertArrayEquals(expected, actual);
    }
}