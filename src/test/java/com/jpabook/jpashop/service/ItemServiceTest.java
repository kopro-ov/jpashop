package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.item.Item;
import com.jpabook.jpashop.repository.ItemRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 상품_등록() throws Exception {
        //given
        Item item = new Item();
        item.setName("item");

        //when
        Long itemId = itemService.saveItem(item);

        //then
        assertEquals(item.getId(), itemRepository.findOne(itemId).getId());
    }

}