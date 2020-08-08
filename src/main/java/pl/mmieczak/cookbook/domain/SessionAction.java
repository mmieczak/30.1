package pl.mmieczak.cookbook.domain;

import java.util.ArrayList;
import java.util.List;

public class SessionAction {

    private List<String> votedForReceipts = new ArrayList<>();

    public List<String> getVotedForReceipts() {
        return votedForReceipts;
    }

    public void setVotedForReceipts(List<String> votedForReceipts) {
        this.votedForReceipts = votedForReceipts;
    }

    public List<String> addVotedReceiptID(String receiptID) {
        this.votedForReceipts.add(receiptID);
        return votedForReceipts;
    }
}
