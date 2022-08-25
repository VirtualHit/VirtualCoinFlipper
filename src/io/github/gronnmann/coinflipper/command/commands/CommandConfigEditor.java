package io.github.gronnmann.coinflipper.command.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.gronnmann.coinflipper.command.CommandModule;
import io.github.gronnmann.coinflipper.customizable.Message;
import io.github.gronnmann.coinflipper.gui.configurationeditor.FileEditSelector;

public class CommandConfigEditor extends CommandModule{

	public CommandConfigEditor() {
		super(Message.CMD_CONFIG.getMessage(), "config", 0, -1, true);
	}

	@Override
	public void runCommand(CommandSender sender, String[] args) {
		FileEditSelector.getInstance().openConfigurator(((Player)sender));
	}
	
}
