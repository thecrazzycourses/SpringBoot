package com.crazzy.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Pierantonio Cangianiello
 */
public class SelfExpiringHashMapTests {

    private final static int SLEEP_MULTIPLIER = 60000;

    @Test
    public void basicGetTest() throws InterruptedException {
        SelfExpiringMap<String, String> map = new SelfExpiringHashMap<String, String>();
        map.put("accessToken", "abcdefghijklmnopqrstuvwxyz0123456789", 2 * SLEEP_MULTIPLIER);
        Thread.sleep(1 * SLEEP_MULTIPLIER);
        assertEquals("abcdefghijklmnopqrstuvwxyz0123456789", map.get("accessToken"));
    }

    @Test
    public void basicExpireTest() throws InterruptedException {
        SelfExpiringMap<String, String> map = new SelfExpiringHashMap<String, String>();
        map.put("accessToken", "abcdefghijklmnopqrstuvwxyz0123456789", 1 * SLEEP_MULTIPLIER);
        Thread.sleep(2 * SLEEP_MULTIPLIER);
        assertNull(map.get("accessToken"));
    }

    /*@Test
    public void basicRenewTest() throws InterruptedException {
        SelfExpiringMap<String, String> map = new SelfExpiringHashMap<String, String>();
        map.put("a", "b", 3 * SLEEP_MULTIPLIER);
        Thread.sleep(2 * SLEEP_MULTIPLIER);
        map.renewKey("a");
        Thread.sleep(2 * SLEEP_MULTIPLIER);
        assertEquals("b", map.get("a"));
    }*/

   /* @Test
    public void getRenewTest() throws InterruptedException {
        SelfExpiringMap<String, String> map = new SelfExpiringHashMap<String, String>();
        map.put("a", "b", 3 * SLEEP_MULTIPLIER);
        Thread.sleep(2 * SLEEP_MULTIPLIER);
        assertEquals("b", map.get("a"));
        Thread.sleep(2 * SLEEP_MULTIPLIER);
        assertEquals("b", map.get("a"));
    }*/

    /*@Test
    public void multiplePutThenRemoveTest() throws InterruptedException {
        SelfExpiringMap<String, String> map = new SelfExpiringHashMap<String, String>();
        map.put("a", "b", 2 * SLEEP_MULTIPLIER);
        Thread.sleep(1 * SLEEP_MULTIPLIER);
        map.put("a", "c", 2 * SLEEP_MULTIPLIER);
        Thread.sleep(1 * SLEEP_MULTIPLIER);
        map.put("a", "d", 400 * SLEEP_MULTIPLIER);
        Thread.sleep(2 * SLEEP_MULTIPLIER);
        assertEquals("d", map.remove("a"));
    }*/

    /*@Test
    public void multiplePutThenGetTest() throws InterruptedException {
        SelfExpiringMap<String, String> map = new SelfExpiringHashMap<String, String>();
        map.put("a", "b", 2 * SLEEP_MULTIPLIER);
        Thread.sleep(1 * SLEEP_MULTIPLIER);
        map.put("a", "c", 2 * SLEEP_MULTIPLIER);
        Thread.sleep(1 * SLEEP_MULTIPLIER);
        map.put("a", "d", 400 * SLEEP_MULTIPLIER);
        Thread.sleep(2 * SLEEP_MULTIPLIER);
        assertEquals("d", map.get("a"));
    }*/

    /*@Test
    public void insertionOrderTest() throws InterruptedException {
        SelfExpiringMap<String, Integer> map = new SelfExpiringHashMap<String, Integer>(30000);
        map.put("123456", 999);
        assertEquals(map.get("123456"), Integer.valueOf(999));
        map.put("123456", 123);
        map.put("777456", 333);
        assertEquals(map.get("123456"), Integer.valueOf(123));
        assertEquals(map.get("777456"), Integer.valueOf(333));
        map.put("777456", 123);
        map.put("123456", 321);
        assertEquals(map.get("123456"), Integer.valueOf(321));
        assertEquals(map.get("777456"), Integer.valueOf(123));
    }*/

}