package com.codingshuttle.projects.lovable_clone.service;

import com.codingshuttle.projects.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.codingshuttle.projects.lovable_clone.dto.subscription.UsageTodayResponse;

public interface UsageService {


    default UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    public default PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
