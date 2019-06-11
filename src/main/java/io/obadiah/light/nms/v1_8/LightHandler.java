package io.obadiah.light.nms.v1_8;

import io.obadiah.light.nms.BaseLightHandler;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.EnumSkyBlock;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

public class LightHandler extends BaseLightHandler {

    @Override
    public void setLight(World world, int x, int y, int z, int lightLevel) {
        WorldServer server = ((CraftWorld) world).getHandle();
        BlockPosition position = new BlockPosition(x, y, z);
        server.a(EnumSkyBlock.BLOCK, position, lightLevel);
        this.applyAdjacently(world.getBlockAt(x, y, z));
    }

    @Override
    public void updateLight(World world, int x, int y, int z) {
        WorldServer server = ((CraftWorld) world).getHandle();
        BlockPosition position = new BlockPosition(x, y, z);
        server.c(EnumSkyBlock.BLOCK, position);
    }
}
