package io.github.gronnmann.coinflipper.command.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.gronnmann.coinflipper.command.CommandModule;
import io.github.gronnmann.coinflipper.customizable.Message;
import io.github.gronnmann.coinflipper.gui.SelectionScreen;

public class CommandGUI extends CommandModule{

    public CommandGUI() {
		super(new String[] {Message.CMD_GUI.getMessage()}, "gui", 0, -1, true);
	}

	@Override
	public void runCommand(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		SelectionScreen.getInstance().openGameManager(p);
	}
}
