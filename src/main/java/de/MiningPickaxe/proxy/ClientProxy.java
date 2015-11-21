package de.MiningPickaxe.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import de.MiningPickaxe.Entity.EntityDragugeon;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderThings() {
		
		//Entity
		RenderingRegistry.registerEntityRenderingHandler(EntityDragugeon.class, new RendererDragugeon(new ModelDragugeon(), 0.3F));
		
	}
	
	public void registerTileEntitySpecialRenderer() {
		
	}

}
