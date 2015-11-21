package de.MiningPickaxe.UniverseDimensions;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import de.MiningPickaxe.Entity.EntityDragugeon;
import de.MiningPickaxe.core.WorldGenerationHandler;
import de.MiningPickaxe.dimension.UniverseDimPortal;
import de.MiningPickaxe.dimension.UniverseDimPortalMaker;
import de.MiningPickaxe.dimension.UniverseDimPortalStone;
import de.MiningPickaxe.dimension.UniverseDimWorldProvider;
import de.MiningPickaxe.handler.EntityHandler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.DimensionManager;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main{
	//mod
	public static final String MODID = "universedim";
	public static final String VERSION = "Beta1.0";
	
	//creativetab
	public static CreativeTabs universedimtab = new CreativeTabs("universedimtab") {
		@Override
		public Item getTabIconItem(){
			return Items.diamond_hoe;
		}
	};
	
	
	
	//dimension
	public static Block portal;
	public static Block portalstone;
	public static Block portalmaker;
	public static int dimid = 257;
	
	
	@Instance(MODID)
	public static Main instance;
	
	@EventHandler
	public static void preinit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
		portal = new UniverseDimPortal().setBlockName("dim_portal").setBlockTextureName(MODID + ":portal").setCreativeTab(universedimtab);
		portalstone = new UniverseDimPortalStone().setBlockName("dim_portalstone").setBlockTextureName(MODID + ":portalstone").setCreativeTab(universedimtab);
		portalmaker = new UniverseDimPortalMaker().setBlockName("dim_portalmaker").setBlockTextureName(MODID + ":portalmaker").setCreativeTab(universedimtab);
		
		GameRegistry.registerBlock(portal, portal.getUnlocalizedName());
		GameRegistry.registerBlock(portalmaker, portalmaker.getUnlocalizedName());
		GameRegistry.registerBlock(portalstone, portalstone.getUnlocalizedName());
		
		DimensionManager.registerProviderType(dimid, UniverseDimWorldProvider.class, false);
		DimensionManager.registerDimension(dimid, dimid);
		
		GameRegistry.registerWorldGenerator(new WorldGenerationHandler(), 100);
		
		
		//Entity
		EntityHandler.registerMonsters(EntityDragugeon.class, "Dragugeon");
		
	}
	
	
	@EventHandler
	public static void postinit(FMLPostInitializationEvent event) {
		
	}
	
	
}