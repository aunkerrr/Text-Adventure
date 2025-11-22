import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class main {

    public static void main(String[] args) {
        Terminal terminal = null;
        Screen screen = null;

        try {
            terminal = new DefaultTerminalFactory().createTerminal();
            screen = new DefaultTerminalFactory().createScreen();
            screen.startScreen();

            screen.newTextGraphics()
                    .setForegroundColor(TextColor.ANSI.GREEN)
                    .putString(5, 5, "Hello, Lanterna World!");

            screen.refresh();

            KeyStroke key = terminal.readInput();


            char character = (key.getKeyType() == KeyType.Character) ? key.getCharacter() : ' ';


            screen.newTextGraphics()
                    .putString(5, 7, "Pressed key: " + character);
            screen.refresh();

            terminal.readInput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (screen != null) {
                try {
                    screen.stopScreen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}