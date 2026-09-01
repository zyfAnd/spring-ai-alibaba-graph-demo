package com.kg2s.node;

import com.alibaba.cloud.ai.graph.OverAllState;
import com.alibaba.cloud.ai.graph.action.NodeAction;
import com.kg2s.mode.StateKeys;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 最终的approval 还是reject
 */
@Component("finalApprovalNode")
public class FinalApprovalNode  implements NodeAction {

    /**
     * 确定性的代码 没有引入AI LLM 接口
     * @param state
     * @return
     * @throws Exception
     */

    @Override
    public Map<String, Object> apply(OverAllState state) throws Exception {
        Boolean creditPassed = (Boolean) state.value(StateKeys.CREDIT_PASSED).orElse(false);
        Boolean incomePassed  = state.value(StateKeys.INCOME_PASSED, false);
        Object appliyAmountObj = state.value(StateKeys.APPROVED_AMOUNT, "0");

        Map<String,Object> updateState = new HashMap<>();

        if(creditPassed && incomePassed){
            updateState.put(StateKeys.APPROVED_AMOUNT, new BigDecimal(appliyAmountObj.toString()));
            updateState.put(StateKeys.INTEREST_RATE, new BigDecimal("0.0385"));
            updateState.put(StateKeys.FINAL_SATTUS, "APPROVED");
        }else{
            updateState.put(StateKeys.APPROVED_AMOUNT, BigDecimal.ZERO);
            updateState.put(StateKeys.FINAL_SATTUS,"FINAL_REJECTED");
        }

        return updateState;
    }
}
