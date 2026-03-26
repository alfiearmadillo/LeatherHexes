package com.leatherhex;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.component.DyedItemColor;

public class LeatherHexTooltipMod implements ClientModInitializer {

    private static final Identifier LATE_PHASE =
            Identifier.fromNamespaceAndPath("leather-hex-tooltip", "late");

    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.addPhaseOrdering(Event.DEFAULT_PHASE, LATE_PHASE);

        ItemTooltipCallback.EVENT.register(LATE_PHASE, (stack, context, type, lines) -> {
            for (var entry : stack.getComponents()) {
                if (entry.type() == DataComponents.DYED_COLOR
                        && entry.value() instanceof DyedItemColor dyed) {

                    int rgb = dyed.rgb() & 0xFFFFFF;
                    if (rgb == 0xA06540) return;
                    String hex = String.format("#%06X", rgb);

                    for (Component existing : lines) {
                        if (existing.getString().contains(hex)) return;
                    }

                    Component line = Component.literal("")
                            .append(Component.translatable("item.color", "")
                                    .withStyle(ChatFormatting.GRAY))
                            .append(Component.literal(hex)
                                    .withStyle(Style.EMPTY.withColor(rgb)));

                    lines.add(1, line);
                    break;
                }
            }
        });
    }
}