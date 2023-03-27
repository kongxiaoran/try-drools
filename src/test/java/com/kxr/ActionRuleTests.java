package com.kxr;

import com.kxr.bean.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
class ActionRuleTests {

    @Autowired
    private KieSession session;

    @Test
    public void actionRule1Test(){
        ActionRule action = new ActionRule();
        action.setUserName("甲");
        action.setRecentBrowseCount(40);
        action.setRecentOpenMemberDayCount(12);
        session.insert(action);
        session.fireAllRules();
    }

    @AfterEach
    public void runDispose() {
        session.dispose();//释放资源
    }
}
