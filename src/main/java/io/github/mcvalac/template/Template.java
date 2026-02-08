package io.github.mcvalac.template;

import io.github.mcengine.mcextension.api.IMCExtension;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.logging.Level;

/**
 * Main entry point for the Template extension.
 * <p>
 * This class handles the lifecycle events of the extension, including initialization
 * and directory setup when loaded by the main plugin.
 */
public class Template implements IMCExtension {

    /**
     * Called when the extension is loaded.
     * <p>
     * This method initializes the extension's working directory at {@code extensions/template}
     * inside the parent plugin's data folder. If the directory does not exist, it will be created.
     *
     * @param plugin   The main {@link JavaPlugin} instance loading this extension.
     * @param executor The {@link Executor} used for asynchronous tasks (if applicable).
     */
    @Override
    public void onLoad(JavaPlugin plugin, Executor executor) {
        // Define the custom folder path: .../plugins/YourPlugin/extensions/template
        File extensionFolder = new File(plugin.getDataFolder(), "extensions/template");

        // Create the directory if it does not exist
        if (!extensionFolder.exists()) {
            boolean created = extensionFolder.mkdirs();
            if (!created) {
                plugin.getLogger().log(Level.WARNING, "[MCValac] [Template] Failed to create extension directory.");
            }
        }

        plugin.getLogger().info("[MCValac] [Template] Loaded Successfully.");
    }

    /**
     * Called when the extension is disabled.
     * <p>
     * Use this method to clean up resources, cancel tasks, or save data before the
     * extension shuts down.
     *
     * @param plugin   The main {@link JavaPlugin} instance.
     * @param executor The {@link Executor} used for tasks.
     */
    @Override
    public void onDisable(JavaPlugin plugin, Executor executor) {}
}
