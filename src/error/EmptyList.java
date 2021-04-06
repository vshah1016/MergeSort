package error;

public class EmptyList extends ListError {
    public EmptyList() {
        super("The list is empty, we cannot sort it or even search it!");
    }
}
