import com.gildrose.GildedRose;
import com.gildrose.item.Item;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class GildedRoseTest {

    @Test
    public void test_common_item_normal_decrease() {
        Item item = new Item("+5 Dexterity Vest", 10, 10);

        GildedRose.updateItemQuality(item);

        assertTrue("Common item decrease sell in", item.getSellIn() == 9);
        assertTrue("Common item decrease quality", item.getQuality() == 9);
    }

    @Test
    public void test_common_item_double_decrease() {
        Item item = new Item("+5 Dexterity Vest", 0, 10);

        GildedRose.updateItemQuality(item);

        assertTrue("Common item don't decrease sell in", item.getSellIn() == -1);
        assertTrue("Common item decrease quality double", item.getQuality() == 8);
    }

    @Test
    public void test_common_item_quality_no_negative() {
        Item item = new Item("+5 Dexterity Vest", 5, 0);

        GildedRose.updateItemQuality(item);

        assertTrue("Common item don't decrease sell in", item.getSellIn() == 4);
        assertTrue("Common item decrease quality double", item.getQuality() == 0);
    }

    @Test
    public void test_item_quality__max_value() {
        Item item = new Item("Aged Brie", 2, 50);

        GildedRose.updateItemQuality(item);

        assertTrue("Common item decrease sell in", item.getSellIn() == 1);
        assertTrue("Common item decrease quality double", item.getQuality() == 50);
    }

    @Test
    public void test_brie_increase_quality() {
        Item item = new Item("Aged Brie", 2, 0);

        GildedRose.updateItemQuality(item);

        assertTrue("Brie decrease sell in", item.getSellIn() == 1);
        assertTrue("Brie increase quality", item.getQuality() == 1 );
    }

    @Test
    public void test_brie_max_increase_quality_over_sellIn() {
        Item item = new Item("Aged Brie", -4, 50);

        GildedRose.updateItemQuality(item);

        assertTrue("Brie decrease sell in", item.getSellIn() == -5);
        assertTrue("Brie don-t increase quality", item.getQuality() == 50 );
    }

    @Test
    public void test_brie_increase_quality_over_sellIn() {
        Item item = new Item("Aged Brie", -4, 49);

        GildedRose.updateItemQuality(item);

        assertTrue("Brie decrease sell in", item.getSellIn() == -5);
        assertTrue("Brie increase quality", item.getQuality() == 50 );
    }

    @Test
    public void test_sulfuras_is_the_same() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);

        GildedRose.updateItemQuality(item);

        assertTrue("Sulfuras sell in is the same", item.getSellIn() == 0);
        assertTrue("Sulfuras quality is the same", item.getQuality() == 80);

    }

    @Test
    public void test_backstage_more_upselling_time() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);

        GildedRose.updateItemQuality(item);

        assertTrue("Backstage decrease sell in", item.getSellIn() == 14);
        assertTrue("Backstage increase quality", item.getQuality() == 21);
    }

    @Test
    public void test_backstage_medium_upsellIn_time() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);

        GildedRose.updateItemQuality(item);

        assertTrue("Backstage decrease sell in", item.getSellIn() == 9);
        assertTrue("Backstage increase quality", item.getQuality() == 22);
    }

    @Test
    public void test_backstage_less_upselling_time() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20);

        GildedRose.updateItemQuality(item);

        assertTrue("Backstage decrease sell in", item.getSellIn() == 2);
        assertTrue("Backstage increase quality", item.getQuality() == 23);
    }

    @Test
    public void test_backstage_over_upselling_time() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        GildedRose.updateItemQuality(item);

        assertTrue("Backstage decrease sell in", item.getSellIn() == -1);
        assertTrue("Backstage increase quality", item.getQuality() == 0);
    }

    @Test
    public void test_conjured_degrade_twice() {
        Item item = new Item("Conjured Mana Cake", 3, 6);

        GildedRose.updateItemQuality(item);

        assertTrue("Conjured decrease sell in", item.getSellIn() == 2);
        assertTrue("Conjured decrease twice in quality", item.getQuality() == 4);
    }

    @Test
    public void test_conjured_degrade_twice_over_sellinin() {
        Item item = new Item("Conjured Mana Cake", -1, 6);

        GildedRose.updateItemQuality(item);

        assertTrue("Conjured decrease sell in", item.getSellIn() == -2);
        assertTrue("Conjured decrease twice in quality", item.getQuality() == 2);
    }
}
