package com.leatherhex;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class LeatherHexTooltipMod implements ClientModInitializer {

    private static final Identifier LATE_PHASE = Identifier.of("leather-hex-tooltip", "late");

    @Override
    public void onInitializeClient() {
        // Run after the default phase so all other mods have already added their lines
        ItemTooltipCallback.EVENT.addPhaseOrdering(Event.DEFAULT_PHASE, LATE_PHASE);

        ItemTooltipCallback.EVENT.register(LATE_PHASE, (stack, context, type, lines) -> {
            //if (!type.isAdvanced()) return;

            for (var entry : stack.getComponents()) {
                if (entry.type() == DataComponentTypes.DYED_COLOR
                        && entry.value() instanceof DyedColorComponent dyed) {

                    int rgb = dyed.rgb() & 0xFFFFFF;
                    if (rgb == 0xA06540) return;
                    String hex = String.format("#%06X", rgb);

                    // All other mods have already added their lines — safe to check now
                    for (Text existing : lines) {
                        if (existing.getString().contains(hex)) return;
                    }

                    // No other mod showed the hex — add it ourselves
                    Text line = Text.literal("")
                            .append(Text.translatable("item.color", "").formatted(Formatting.GRAY))
                            .append(Text.literal(hex).setStyle(Style.EMPTY.withColor(rgb)));

                    lines.add(1, line);
                    break;
                }
            }
        });
    }
}