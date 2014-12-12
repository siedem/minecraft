/***
 * Excerpted from "Learn to Program with Minecraft Plugins, CanaryMod Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/ahmine2 for more book information.
***/
package helloworld;//(1)
import net.canarymod.plugin.Plugin;//(2)
import net.canarymod.logger.Logman;
import net.canarymod.Canary;
import net.canarymod.commandsys.*;
import net.canarymod.chat.MessageReceiver;

public class HelloWorld extends Plugin implements CommandListener {//(3)

  public static Logman logger;
    
  public HelloWorld() { 
    logger = getLogman();
  }

  @Override
  public boolean enable() { 
    logger.info("Starting up");   
    try {
      Canary.commands().registerCommands(this, this, false);
    } catch (CommandDependencyException e) {
      logger.error("Duplicate command name");
    }
    return true;
  }
  
  @Override
  public void disable() {
  }

  @Command(aliases = { "matrix/" },//(4)
            description = "Displays the hello world message.",
            permissions = { "" },
            toolTip = "/prawda/")
  @SuppressWarnings("unused")
  public void helloCommand(MessageReceiver caller, String[] parameters) {//(5)
    String msg = "Czy wiedziales, ze swiat w ktorym teraz jestes nie jest prawdziwy? "
        + "W prawdziwym swiecie jest wielki komputer w ktorym jest ten caly swiat. Stworzenia mieszkajace w tamtym "
        + "swiecie modom zrobic doslownie wszystko. Czy widziales kiedys noc nagle zmieniajacom sie na dzien? "
        + "To zrobili Oni. Wiec strzez sie Ich, bo moze teraz cie sledzom. UWAZAJ!!!!! ";
    Canary.instance().getServer().broadcastMessage(msg);
  }
}
