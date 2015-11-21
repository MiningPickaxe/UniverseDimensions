package de.MiningPickaxe.dimension;

import de.MiningPickaxe.UniverseDimensions.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class UniverseDimPortalMaker extends Block{

	public UniverseDimPortalMaker() {
		super(Material.fire);
		// TODO Auto-generated constructor stub
	}

	public void onBlockAdded(World world, int x, int y, int z){
		if(world.getBlock(x, y - 1, z) != Main.portalstone|| !UniverseDimPortal.func_150000_e(world, x, y, z)); 
	}
	
}
