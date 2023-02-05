package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest extends TestCase {
    @Autowired
    BoardDao boardDao;

    @Test
    public void select() throws Exception {
        assertTrue(boardDao != null);
        System.out.println("boardDao = " + boardDao);
        BoardDto boardDto = boardDao.select(1);
        System.out.println("boardDto = " + boardDto);
        assertTrue(boardDto.getBno().equals(1));
    }
}