/*
 * Copyright © 2020 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package me.lambdaurora.spruceui.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an event callback which is fired when an {@link Screen} is opened.
 *
 * @author LambdAurora
 * @version 1.2.0
 * @since 1.2.0
 */
@FunctionalInterface
public interface ScreenOpenCallback
{
    Event<ScreenOpenCallback> EVENT = EventFactory.createArrayBacked(ScreenOpenCallback.class, listeners -> (client, screen) -> {
        for (ScreenOpenCallback event : listeners) {
            event.apply(client, screen);
        }
    });

    void apply(@NotNull MinecraftClient client, @Nullable Screen screen);
}