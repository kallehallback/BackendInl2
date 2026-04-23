package se.yrgo.services.calls;

import java.util.Collection;

import se.yrgo.domain.Action;
import se.yrgo.domain.Call;
import se.yrgo.services.customers.CustomerManagementService;
import se.yrgo.services.customers.CustomerNotFoundException;
import se.yrgo.services.diary.DiaryManagementService;

public class CallHandlingServiceImpl implements CallHandlingService {

    private CustomerManagementService cms;
    private DiaryManagementService dms;

    public void setCms(CustomerManagementService cms) {
        this.cms = cms;
    }

    public void setDms(DiaryManagementService dms) {
        this.dms = dms;
    }

    @Override
    public void recordCall(String customerId, Call newCall, Collection<Action> actions)
            throws CustomerNotFoundException {

        cms.recordCall(customerId, newCall);

        for (Action action : actions) {
            dms.recordAction(action);
        }
    }
}