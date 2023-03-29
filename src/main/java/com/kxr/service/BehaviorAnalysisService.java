package com.kxr.service;

import com.kxr.bean.ActionRule;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: kongxr
 * @Date: 2023-03-29 8:29
 * @Description:
 */
@Service
public class BehaviorAnalysisService {

    @Autowired
    KieSession kieSession;

    public void startAnalysis(){
        List<ActionRule> userActionRule = getUserActionRule();
        userActionRule.forEach(value -> kieSession.insert(value));
        kieSession.fireAllRules();
    }

    public List<ActionRule> getUserActionRule(){
        List<ActionRule> actionRules = new ArrayList<>();
        ActionRule actionRule = new ActionRule();
        actionRule.setUserName("甲");
        actionRule.setRecentBrowseCount(40);
        actionRule.setRecentOpenMemberDayCount(12);
        actionRules.add(actionRule);
        return actionRules;
    }
}
