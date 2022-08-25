package io.github.gronnmann.utils.coinflipper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;


public class PacketUtils {
	
	public enum TitleType{TITLE, SUBTITLE, ACTIONBAR}
	
	private static String getJsonString(String field, String value){
		return "{\""+field+"\":\"" + value + "\"}";
	}
	
	public static void sendPacket(Player player, Object packet){
		try {
			Object playerHandle = player.getClass().getMethod("getHandle").invoke(player);
			Object connection = playerHandle.getClass().getField("playerConnection").get(playerHandle);
			Method sendPacket = connection.getClass().getMethod("sendPacket", getServerClass("Packet"));
			
			sendPacket.invoke(connection, packet);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Class<?> getServerClass(String afterPackage){
		String servPack = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		
		try {
			return Class.forName("net.minecraft.server." + servPack + "." + afterPackage);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected static String color(String text) {
	    return ChatColor.translateAlternateColorCodes('&', text);
	}
	
	//Titles
	public static void sendTitle(Player player, String title, TitleType type, int fadeIn, int stay, int fadeOut){
		switch(type) {
            case ACTIONBAR:
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(color(title)));
                break;
            case SUBTITLE:
                player.sendTitle("§7", color(title), fadeIn, stay, fadeOut);
                break;
            case TITLE:
                player.sendTitle(color(title), "§7", fadeIn, stay, fadeOut);
                break;
            default:
                break;
		    
		}
	    
	    
	    //PacketPlayOutTitle titleP = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"Test\"}"));
		//((CraftPlayer) player).getHandle().playerConnection.sendPacket(titleP);
		/*title = title.replaceAll("\n", "");
		try{
			Constructor<?> titleConst = getServerClass("PacketPlayOutTitle")
					.getConstructor(getServerClass("PacketPlayOutTitle$EnumTitleAction"), 
					getServerClass("IChatBaseComponent"), int.class, int.class, int.class);
			
			Object titleType = getServerClass("PacketPlayOutTitle$EnumTitleAction").getField(type.toString()).get(null);
			Object message = getServerClass("IChatBaseComponent$ChatSerializer").getMethod("a", String.class)
					.invoke(null, getJsonString("text", title));
			
			Object titlePacket = titleConst.newInstance(titleType, message, fadeIn, stay, fadeOut);
			
			sendPacket(player, titlePacket);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		*/	
	}
	
	public static void sendWorldBorder(Player player, Location center, int size){
		
		
		
	/*
	 * Orginal WorldBorder code:
	 	WorldBorder border = new WorldBorder();
		border.setCenter(center.getX(), center.getZ());
		border.setSize(size);
		
		PacketPlayOutWorldBorder packet = new PacketPlayOutWorldBorder(border, EnumWorldBorderAction.INITIALIZE);
		
		import net.minecraft.server.v1_9_R1.PacketPlayOutWorldBorder;
		import net.minecraft.server.v1_9_R1.PacketPlayOutWorldBorder.EnumWorldBorderAction;
		import net.minecraft.server.v1_9_R1.WorldBorder;
	*/
		
		try{
		
			Object worldBorder = getServerClass("WorldBorder").newInstance();
			
			Method setCenter = worldBorder.getClass().getMethod("setCenter", double.class, double.class);
			setCenter.invoke(worldBorder, center.getX(), center.getZ());
			
			Method setSize = worldBorder.getClass().getMethod("setSize", double.class);
			setSize.invoke(worldBorder, size);
			
			Constructor<?> worldBorderPacketConstructor = getServerClass("PacketPlayOutWorldBorder").getConstructor(
					getServerClass("WorldBorder"), getServerClass("PacketPlayOutWorldBorder$EnumWorldBorderAction"));
			
			Object initializeEnum = getServerClass("PacketPlayOutWorldBorder$EnumWorldBorderAction").getField("INITIALIZE").get(null);
			
			Object worldBorderPacket = worldBorderPacketConstructor.newInstance(worldBorder, initializeEnum);
			
			
			sendPacket(player, worldBorderPacket);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
