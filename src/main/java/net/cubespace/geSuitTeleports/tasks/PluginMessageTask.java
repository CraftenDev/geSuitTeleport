package net.cubespace.geSuitTeleports.tasks;

import net.cubespace.geSuitTeleports.geSuitTeleports;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.ByteArrayOutputStream;
import java.util.Collection;

public class PluginMessageTask extends BukkitRunnable {
    private final ByteArrayOutputStream bytes;

    public PluginMessageTask(ByteArrayOutputStream bytes) {
        this.bytes = bytes;
    }

    public void run() {
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        if (onlinePlayers.isEmpty()) {
            geSuitTeleports.INSTANCE.getLogger().info("Tried to send a pluginMessage with an empty server. Cancelling.");
        } else {
            onlinePlayers.iterator().next().sendPluginMessage(geSuitTeleports.INSTANCE, "geSuitBans", bytes.toByteArray());
        }
    }
}
