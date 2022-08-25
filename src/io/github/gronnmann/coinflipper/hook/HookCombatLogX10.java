package io.github.gronnmann.coinflipper.hook;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.github.sirblobman.combatlogx.api.ICombatLogX;
import com.github.sirblobman.combatlogx.api.manager.ICombatManager;

public final class HookCombatLogX10 {
	private HookCombatLogX10() {}
	private static final HookCombatLogX10 hook = new HookCombatLogX10();
	public static HookCombatLogX10 getHook(){
		return hook;
	}

	private ICombatManager combatManager;
	public void register(){
		ICombatLogX combatLogX = (ICombatLogX) Bukkit.getPluginManager().getPlugin("CombatLogX");
		this.combatManager = combatLogX.getCombatManager();
	}

	public boolean isTagged(Player player) {
	    return this.combatManager.isInCombat(player);
	}
}
