package fr.mrsheepsheep.tinthealth;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class TintHealth extends JavaPlugin{

	protected TintHealth plugin;
	protected THFunctions functions;
	protected boolean fade = false;
	protected int fadetime = 5;
	protected int intensity = 1;

	public void onEnable(){
		plugin = this;
		new PlayerListener(this);
		functions = new THFunctions(this);
		FileConfiguration config = getConfig();
		config.options().copyDefaults(true);

		config.addDefault("options.fade-enabled", this.fade);
		config.addDefault("options.fade-time", this.fadetime);
		config.addDefault("options.intensity-modifier", this.intensity);

		saveConfig();

		this.fade = config.getBoolean("options.fade-enabled");
		this.fadetime = config.getInt("options.fade-time");
		this.intensity = config.getInt("options.intensity-modifier");

	}
	
	protected void smallDelay(Runnable run){
		BukkitScheduler bs = getServer().getScheduler();
		bs.scheduleSyncDelayedTask(this, run, 1L);
	}
}
