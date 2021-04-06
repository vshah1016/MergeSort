package error;

import helper.Data;

public class ListLimit extends ListError {
    public ListLimit() {
        super("You have already added " + Data.MAXIMUM_LENGTH + " numbers to the list. You cannot add any more.");
    }
}
