package io.github.gronnmann.coinflipper.command.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.gronnmann.coinflipper.animations.AnimationGUI;
import io.github.gronnmann.coinflipper.command.CommandModule;
import io.github.gronnmann.coinflipper.customizable.Message;

public class CommandAnimation extends CommandModule{

	public CommandAnimation() {
		super(new String[] {Message.CMD_ANIMATION.getMessage(), "animation", "anim"}, "animation", 0, -1, true);
	}

	@Override
	public void runCommand(CommandSender sender, String[] args) {
		AnimationGUI.getManager().openGUI(((Player)sender));
		
	}

}
