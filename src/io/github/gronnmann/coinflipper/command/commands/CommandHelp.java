package io.github.gronnmann.coinflipper.command.commands;

import org.bukkit.command.CommandSender;

import io.github.gronnmann.coinflipper.command.CommandModule;
import io.github.gronnmann.coinflipper.customizable.Message;

public class CommandHelp extends CommandModule {

    private String help = "";

    public CommandHelp() {
        super("help", "help", 0, -1, false);
        this.help = Message.SYNTAX_L1.getMessage() + "\n" + Message.SYNTAX_L2.getMessage() + "\n"
                + Message.SYNTAX_L3.getMessage() + "\n" + Message.SYNTAX_L4.getMessage() + "\n"
                + Message.SYNTAX_L5.getMessage();
        ;
    }

    @Override
    public void runCommand(CommandSender sender, String[] args) {
        sender.sendMessage(help);
    }

}
