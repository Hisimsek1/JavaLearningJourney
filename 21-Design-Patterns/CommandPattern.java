import java.util.ArrayDeque;
import java.util.Deque;

public class CommandPattern {

    interface Command {
        void execute();
        void undo();
    }

    static class TextEditor {
        private StringBuilder text = new StringBuilder();

        void insertText(String s) {
            text.append(s);
        }

        void deleteText(int count) {
            int len = text.length();
            text.delete(Math.max(0, len - count), len);
        }

        String getText() {
            return text.toString();
        }
    }

    static class InsertCommand implements Command {
        private TextEditor editor;
        private String text;

        InsertCommand(TextEditor editor, String text) {
            this.editor = editor;
            this.text = text;
        }

        public void execute() {
            editor.insertText(text);
        }

        public void undo() {
            editor.deleteText(text.length());
        }
    }

    static class DeleteCommand implements Command {
        private TextEditor editor;
        private int count;
        private String deleted;

        DeleteCommand(TextEditor editor, int count) {
            this.editor = editor;
            this.count = count;
        }

        public void execute() {
            String t = editor.getText();
            deleted = t.substring(Math.max(0, t.length() - count));
            editor.deleteText(count);
        }

        public void undo() {
            editor.insertText(deleted);
        }
    }

    static class CommandHistory {
        private Deque<Command> history = new ArrayDeque<>();

        void execute(Command cmd) {
            cmd.execute();
            history.push(cmd);
        }

        void undo() {
            if (!history.isEmpty()) {
                history.pop().undo();
            }
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        CommandHistory history = new CommandHistory();

        history.execute(new InsertCommand(editor, "Hello"));
        System.out.println(editor.getText());

        history.execute(new InsertCommand(editor, " World"));
        System.out.println(editor.getText());

        history.execute(new DeleteCommand(editor, 5));
        System.out.println(editor.getText());

        history.undo();
        System.out.println("After undo: " + editor.getText());

        history.undo();
        System.out.println("After undo: " + editor.getText());

        history.undo();
        System.out.println("After undo: " + editor.getText());
    }
}
