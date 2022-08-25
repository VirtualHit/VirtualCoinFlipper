package io.github.gronnmann.coinflipper.command.commands;

import org.bukkit.command.CommandSender;

import io.github.gronnmann.coinflipper.bets.BettingManager;
import io.github.gronnmann.coinflipper.command.CommandModule;
import io.github.gronnmann.coinflipper.customizable.Message;

public class CommandClear extends CommandModule{

	public CommandClear() {
		super(Message.CMD_CLEAR.getMessage(), "clear", 0, -1, false);
	}

	@Override
	public void runCommand(CommandSender sender, String[] args) {
		
		if (BettingManager.getManager().getBets().isEmpty()){
			sender.sendMessage(Message.CLEAR_FAILED_NOBETS.getMessage());
			return;
		}
		BettingManager.getManager().clearBets();
		sender.sendMessage(Message.CLEAR_SUCCESSFUL.getMessage());
	}

}
