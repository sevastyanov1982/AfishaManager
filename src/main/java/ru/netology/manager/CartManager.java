package ru.netology.manager;

import ru.netology.domain.PurchaseItem;

public class CartManager {
    private PurchaseItem[] items = new PurchaseItem[0];

    public void add(PurchaseItem item) {
        // создаем новый массив размером на единицу больше
        int lenght = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[lenght];
        // itar + tab
        // копируем поэлементно
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладем последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] getAll() {
        PurchaseItem[] result = new PurchaseItem[items.length];
        // перебираем массив в прямом порядке
        // но кладем результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    // наивная реализация
    public void removeByID(int id) {
        int lenght = items.length - 1;
        PurchaseItem[] tmp = new PurchaseItem[lenght];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        // меняем наши элементы
        items = tmp;
    }
}