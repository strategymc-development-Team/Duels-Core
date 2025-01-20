package dev.m7wq.duelscore.listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import dev.m7wq.duelscore.data.cache.CacheManager;
import dev.m7wq.duelscore.data.entity.DuelsData;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;


@AllArgsConstructor
public class PacketListener implements PluginMessageListener {

    private CacheManager cacheManager;


    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {

        if (!channel.equals("BungeeCord"))
            return;

        ByteArrayDataInput in = ByteStreams.newDataInput(message);

        String subChannel = in.readUTF();

        if (!subChannel.equals("VarticsDuels"))
            return;


        String uuid = in.readUTF();
        DuelsData data = cacheManager.getData(uuid);



        String operation = in.readUTF(); // Set or Increase
        String type = in.readUTF();

        int value = in.readInt();



            switch (type){


                case "Wins":
                    if (operation.equals("Set"))
                        cacheManager.getCacheMap().get(uuid).setWins(value);
                    else if (operation.equals("Increase"))
                        cacheManager.getCacheMap().get(uuid)
                                .setWins(data.getWins() + value);
                case "Loses":
                    if (operation.equals("Set"))
                        cacheManager.getCacheMap().get(uuid).setLoses(value);
                    else if (operation.equals("Increase"))
                        cacheManager.getCacheMap().get(uuid)
                                .setLoses(data.getLoses() + value);
                case "Winstreak":
                    if (operation.equals("Set"))
                        cacheManager.getCacheMap().get(uuid).setWinStreak(value);
                    else if (operation.equals("Increase"))
                        cacheManager.getCacheMap().get(uuid)
                                .setWinStreak(data.getWinStreak() + value);
                case "Coins":
                    if (operation.equals("Set"))
                        cacheManager.getCacheMap().get(uuid).setCoins(value);
                    else if (operation.equals("Increase"))
                        cacheManager.getCacheMap().get(uuid)
                                .setCoins(data.getCoins() + value);

            }








    }
}
