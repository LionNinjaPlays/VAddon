package org.vined.vaddon.modules;

import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.StringSetting;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.client.MinecraftClient;

import org.vined.vaddon.VAddon;

public class ForceOP extends Module {
    private final Setting<String> serverIp = settings.create(new StringSetting.Builder()
        .name("server-ip")
        .defaultValue("your_server_ip") // Change this to your server's IP
        .build());

    private final MinecraftClient mc = MinecraftClient.getInstance();

    public ForceOP() {
        super(Category.Misc, "force-op", "Violently threatens the server (/j) to give you OP (operator).");
    }

    @Override
    public void onActivate() {
        // Get the username of the currently logged-in player
        String username = mc.getSession().getUsername();
        // Create the /op command using the detected username
        String opCommand = "/op " + username;
        // Execute the OP command
        ChatUtils.sendPlayerMsg(opCommand);
    }
}
