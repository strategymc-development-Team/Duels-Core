package dev.m7wq.duelscore;

import dev.m7wq.duelscore.data.cache.CacheManager;
import dev.m7wq.duelscore.listener.PacketListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Plugin extends JavaPlugin {

    private CacheManager cacheManager;

    @Override
    public void onEnable() {
        getServer().getMessenger().registerIncomingPluginChannel(this,"BungeeCord",new PacketListener());
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

    }


    public void init(){
        this.cacheManager = new CacheManager();
    }

    @Override
    public void onDisable() {
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
    }
}
